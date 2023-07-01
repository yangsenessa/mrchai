package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

public class ModelInfo {

    /** modelId*/
    private String modelId;

    /** modelkey*/
    private String modelKey;

    /** cateGory1*/
    private String cateGory1;

    /** cateGory2*/
    private String cateGory2;

    /** cateGory3*/
    private String cateGory3;

    /** modelCover*/
    private ModelCover modelCover;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    public String getCateGory1() {
        return cateGory1;
    }

    public void setCateGory1(String cateGory1) {
        this.cateGory1 = cateGory1;
    }

    public String getCateGory2() {
        return cateGory2;
    }

    public void setCateGory2(String cateGory2) {
        this.cateGory2 = cateGory2;
    }

    public String getCateGory3() {
        return cateGory3;
    }

    public void setCateGory3(String cateGory3) {
        this.cateGory3 = cateGory3;
    }

    public ModelCover getModelCover() {
        return modelCover;
    }

    public void setModelCover(ModelCover modelCover) {
        this.modelCover = modelCover;
    }
}
