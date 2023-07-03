package com.essa.mrchaiemc.biz.services.usersrv;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.common.dal.dao.ModelInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("modelBizService")
public class ModelBizServiceImpl implements ModelBizService{
    @Autowired
    private ModelInfoDAO modelInfoDAO;

    @Override
    public void addOrUpdateModelInfo(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = this.getModelInfo(request);
        ModelInfoDO modelInfoDO = new ModelInfoDO();
        this.covertModelInfo2DO(modelInfo, modelInfoDO);
        modelInfoDAO.save(modelInfoDO);
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
     *
     * @param request
     */
    private ModelInfo getModelInfo(BussRequest request){
         return request.getBussContext().getModelContext().getModelInfo();
    }
}
