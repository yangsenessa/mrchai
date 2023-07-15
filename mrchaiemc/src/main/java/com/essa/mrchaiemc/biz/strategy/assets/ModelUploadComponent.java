package com.essa.mrchaiemc.biz.strategy.assets;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.dal.dao.MinIOFileInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.ModelDetailInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.MinIOFileInfoDO;
import com.essa.mrchaiemc.common.dal.repository.ModelDetailInfoDO;
import com.essa.mrchaiemc.common.util.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Component("MODELUPLOAD")
public class ModelUploadComponent implements BussComponent {
    @Autowired
    MinioUtil minioUtil;
    @Autowired
    private ModelDetailInfoDAO modelDetailInfoDAO;
    @Autowired
    private MinIOFileInfoDAO minIOFileInfoDAO;
    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
/*        if(request.getBussContext().getFile() == null ||request.getBussContext().getFile().length ==0 ){
            return false;
        }*/
        if(StringUtil.isEmpty(request.getUserContext().getUserId())){
            //todo:noly mocked for test
            request.getUserContext().setUserId("1111");
            // return false;
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {

        try {
            ModelDetailInfoDO modelDetailInfoDO = new ModelDetailInfoDO();
/*            String modelDetailInfoJson = request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode());
            System.out.println(modelDetailInfoJson);
            ModelDetailInfo modelDetailInfo = JSONObject.parseObject(modelDetailInfoJson, new TypeReference<ModelDetailInfo>() {
            });*/
            String modelDetailInfoJson = request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode());
            ModelDetailInfo modelDetailInfo = JSONObject.parseObject(modelDetailInfoJson, new TypeReference<ModelDetailInfo>() {
            });
      //     ModelDetailInfo modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
            modelDetailInfoDO.setModelId(modelDetailInfo.getModelId());
            modelDetailInfoDO.setVersion(modelDetailInfo.getVersion());
            //      modelDetailInfoDO.setEmcInvokeParam(JSONObject.toJSONString(modelDetailInfo.getEmcInvokeParam()));
            modelDetailInfoDO.setGuideLink(modelDetailInfo.getGuideLink());
            modelDetailInfoDO.setParamsGuideLink(modelDetailInfo.getParamsGuideLink());
            modelDetailInfoDO.setSampleCodeLink(modelDetailInfo.getSampleCodeLink());
            modelDetailInfoDO.setVersion(modelDetailInfo.getVersion());
            modelDetailInfoDO.setDownLoadLink(modelDetailInfo.getDownLoadLink());
            this.modelDetailInfoDAO.save(modelDetailInfoDO);

            response.setResExtInfo(new HashMap<String, String>());
            response.getResExtInfo().put("modelDetail", JSONObject.toJSONString(modelDetailInfoDO));
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
    }

    @Override
    public String getActionCode() {
        return "MODELUPLOAD";
    }
}