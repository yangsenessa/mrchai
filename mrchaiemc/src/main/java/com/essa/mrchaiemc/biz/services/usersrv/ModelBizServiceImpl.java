package com.essa.mrchaiemc.biz.services.usersrv;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.params.ParamModel;
import com.essa.mrchaiemc.common.dal.dao.ModelDetailInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.ModelInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.ModelDetailInfoDO;
import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import com.essa.mrchaiemc.common.dal.repository.ModelParamsDO;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("modelBizService")
public class ModelBizServiceImpl implements ModelBizService{
    @Autowired
    private ModelInfoDAO modelInfoDAO;

    @Autowired
    private ModelDetailInfoDAO modelDetailInfoDAO;

    @Override
    public void addOrUpdateModelInfo(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = this.getModelInfo(request);
        ModelInfoDO modelInfoDO = new ModelInfoDO();
        this.covertModelInfo2DO(modelInfo, modelInfoDO);
        modelInfoDAO.save(modelInfoDO);
    }

    @Override
    public ModelInfo fetchModelInfoBase(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        ModelInfo modelInfo = new ModelInfo();
        ModelInfoDO modelInfoDO = modelInfoDAO.findByModelId(modelDetailInfo.getModelId());
        this.convertDO2ModelInfo(modelInfoDO,modelInfo);
        return modelInfo;
    }

    @Override
    public void addOrUpdateModelDetailInfo(BussRequest request, BussResponse response) {

    }

    @Override
    public void addOrUpdateModelCovers(BussRequest request, BussResponse response) {

    }

    @Override
    public void addOrUpdateModelFilesInfo(BussRequest request, BussResponse response) {

    }

    @Override
    public void modModelDetailInfo(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo =request.getBussContext().getModelContext().getModelDetailInfo();
        ModelDetailInfoDO modelDetailInfoDO = new ModelDetailInfoDO();
        ModelParamsDO modelParamsDO = new ModelParamsDO();

        this.convertModelDetailInfo2DO(modelDetailInfo, modelDetailInfoDO,modelParamsDO);
        try {
            this.modelDetailInfoDAO.save(modelDetailInfoDO);
            response.setResCode(ResultCode.SUCCESS.name());
            response.setResExtInfo(new HashMap<>());
            response.getResExtInfo().put("MODELINFO",
                    JSONObject.toJSONString(request.getBussContext().getModelContext().getModelInfo()));
            response.getResExtInfo().put("MODELDETAILINFO",
                    JSONObject.toJSONString(request.getBussContext().getModelContext().getModelDetailInfo()));

        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB opr err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }

    }

    /**
     *
     * @param request
     */
    private ModelInfo getModelInfo(BussRequest request){
        return request.getBussContext().getModelContext().getModelInfo();
    }
    /**
     * 2DO模型转换
     * @param modelInfo
     * @param modelInfoDO
     */
    private void covertModelInfo2DO(ModelInfo modelInfo, ModelInfoDO modelInfoDO){
        modelInfoDO.setModelId(modelInfo.getModelId());
        modelInfoDO.setModelName(modelInfo.getModelName());
        modelInfoDO.setModelSubName(modelInfo.getModelSubName());
        modelInfoDO.setCateGory1(modelInfo.getCateGory1());
        modelInfoDO.setCateGory2(modelInfo.getCateGory2());
        modelInfoDO.setCateGory3(modelInfo.getCateGory3());
    }

    /**
     * 2DO模型转换-modeldetailInfo
     * @param modelDetailInfo
     * @param modelDetailInfoDO
     */
    private void convertModelDetailInfo2DO(ModelDetailInfo modelDetailInfo,
                                           ModelDetailInfoDO modelDetailInfoDO,
                                           ModelParamsDO modelParamsDO){
        modelDetailInfoDO.setModelId(modelDetailInfo.getModelId());
        modelDetailInfoDO.setDownLoadLink(modelDetailInfo.getDownLoadLink());
        modelDetailInfoDO.setEmcInvokeParam(modelDetailInfoDO.getEmcInvokeParam());
        modelParamsDO.setInvokeGuide(modelDetailInfo.getInvokeGuide());
        modelDetailInfoDO.setGuideLink(modelDetailInfo.getGuideLink());
        //模型参数组装
        if(modelDetailInfo.getParamModel() != null){
            ParamModel paramModel = modelDetailInfo.getParamModel();
            modelParamsDO.setCommonParams(JSONObject.toJSONString(paramModel.getCommonParams()));
            modelDetailInfoDO.setParamsGuideLink(paramModel.getParamLink());
            modelParamsDO.setPromts(JSONObject.toJSONString(paramModel.getPromts()));
            modelParamsDO.setNegativePromts(JSONObject.toJSONString(paramModel.getNegativePromts()));
        }

    }

    /**
     * Domain 模型转换
     * @param modelInfoDO
     * @param modelInfo
     */
    private void convertDO2ModelInfo(ModelInfoDO modelInfoDO, ModelInfo modelInfo){
        if(modelInfo == null){
            modelInfo = new ModelInfo();
        }
        if(modelInfoDO == null){
            modelInfo = null;
        } else {
            modelInfo.setModelId(modelInfoDO.getModelId());
            modelInfo.setModelName(modelInfoDO.getModelName());
            modelInfo.setModelKey(modelInfoDO.getModelKey());
            modelInfo.setModelSubName(modelInfoDO.getModelSubName());
            modelInfo.setCateGory1(modelInfoDO.getCateGory1());
            modelInfo.setCateGory2(modelInfoDO.getCateGory2());
            modelInfo.setCateGory3(modelInfoDO.getCateGory3());
        }

    }



}
