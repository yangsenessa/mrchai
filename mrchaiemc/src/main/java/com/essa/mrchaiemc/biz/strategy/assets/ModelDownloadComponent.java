package com.essa.mrchaiemc.biz.strategy.assets;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MODELDOWNLOAD")
public class ModelDownloadComponent implements BussComponent {
    @Autowired
    MinioUtil minioUtil;
    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {

        String modelDetailInfoJson = request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode());
        ModelDetailInfo modelDetailInfo = JSONObject.parseObject(modelDetailInfoJson, new TypeReference<ModelDetailInfo>() {
        });
        String downLoadLink=modelDetailInfo.getModelFileLink();
        String fileName = downLoadLink.substring(downLoadLink.lastIndexOf("]")+1);
        try {
            // String downLoadurl=minioUtil.getFileUrl(downLoadLink); //下载地址链接
            minioUtil.lookUploadFile(request.getHttpServletRequest(),response.getHttpServletResponse(),downLoadLink,fileName);
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());

    }

    @Override
    public String getActionCode() {
        return "MODELDOWNLOAD";
    }
}