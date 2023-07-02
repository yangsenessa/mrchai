package com.essa.mrchaiemc.biz.models.domains.bussiness;

import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelCover;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelPrinciple;

/**
 * 模型业务上下文
 */
public class ModelContext {

    /** 基础信息*/
    private ModelInfo modelInfo;

    /** 模型详细信息*/
    private ModelDetailInfo modelDetailInfo;

    /** 模型封面*/
    private ModelCover modelCover;

    /** 模型条款*/
    private ModelPrinciple modelPrinciple;

    public ModelInfo getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(ModelInfo modelInfo) {
        this.modelInfo = modelInfo;
    }

    public ModelDetailInfo getModelDetailInfo() {
        return modelDetailInfo;
    }

    public void setModelDetailInfo(ModelDetailInfo modelDetailInfo) {
        this.modelDetailInfo = modelDetailInfo;
    }

    public ModelCover getModelCover() {
        return modelCover;
    }

    public void setModelCover(ModelCover modelCover) {
        this.modelCover = modelCover;
    }

    public ModelPrinciple getModelPrinciple() {
        return modelPrinciple;
    }

    public void setModelPrinciple(ModelPrinciple modelPrinciple) {
        this.modelPrinciple = modelPrinciple;
    }
}
