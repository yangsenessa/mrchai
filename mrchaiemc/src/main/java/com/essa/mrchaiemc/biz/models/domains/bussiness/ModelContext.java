package com.essa.mrchaiemc.biz.models.domains.bussiness;

import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfoV2;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelPrinciple;

/**
 * 模型业务上下文
 */
public class ModelContext {

    /** 基础信息*/
    private ModelInfo modelInfo;

    /** 模型详细信息*/
    private ModelDetailInfoV2 modelDetailInfo;


    /** 模型条款*/
    private ModelPrinciple modelPrinciple;

    public ModelInfo getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(ModelInfo modelInfo) {
        this.modelInfo = modelInfo;
    }

    public ModelDetailInfoV2 getModelDetailInfo() {
        return modelDetailInfo;
    }

    public void setModelDetailInfo(ModelDetailInfoV2 modelDetailInfo) {
        this.modelDetailInfo = modelDetailInfo;
    }


    public ModelPrinciple getModelPrinciple() {
        return modelPrinciple;
    }

    public void setModelPrinciple(ModelPrinciple modelPrinciple) {
        this.modelPrinciple = modelPrinciple;
    }
}
