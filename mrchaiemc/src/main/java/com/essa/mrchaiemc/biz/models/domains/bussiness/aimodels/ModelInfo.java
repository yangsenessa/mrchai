package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

public class ModelInfo {

    /** modelId  模型id uuid生成*/
    private String modelId;

    /** modelName 模型名称-主页模型列表(grid)展示的名称*/
    private String modelName;

    /** modelSubName 模型二级明细-详情页详细名称*/
    private String modelSubName;


    /** modelkey 模型对象存储key*/
    private String modelKey;

    /** cateGory1 模型分类:lora,checkpoint....*/
    private String cateGory1;

    /** cateGory2 模型tag，PERSON,WOMEN,WEDDING*/
    private String cateGory2;

    /** cateGory3 预留*/
    private String cateGory3;

    /** 模型封面*/
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


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelSubName() {
        return modelSubName;
    }

    public void setModelSubName(String modelSubName) {
        this.modelSubName = modelSubName;
    }

    public ModelCover getModelCover() {
        return modelCover;
    }

    public void setModelCover(ModelCover modelCover) {
        this.modelCover = modelCover;
    }
}
