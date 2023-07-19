package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

public class ModelInfo {

    /** modelId  模型id uuid生成*/
    private String modelId;

    /** modelName 模型名称-主页模型列表(grid)展示的名称*/
    private String modelName;

    /** modelSubName 模型二级明细-详情页详细名称*/
    private String modelSubName;


    /** ownerCustId*/
    private String ownerCustId;

    /** review And public userid*/
    private String mannerUserId;


    /** modelkey 模型对象存储key*/
    private String modelKey;

    /** cateGory1 模型分类:lora,checkpoint....*/
    private String cateGory1;

    /** cateGory2 模型tag，PERSON,WOMEN,WEDDING*/
    private String cateGory2;

    /** cateGory3 预留*/
    private String cateGory3;

    /** modelCover1*/
    private String modelCover1;



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

    /**
     * Getter method for property <tt>modelCover1</tt>.
     *
     * @return property value of modelCover1
     */
    public String getModelCover1() {
        return modelCover1;
    }

    /**
     * Setter method for property <tt>modelCover1</tt>.
     *
     * @param modelCover1 value to be assigned to property modelCover1
     */
    public void setModelCover1(String modelCover1) {
        this.modelCover1 = modelCover1;
    }

    /**
     * Getter method for property <tt>ownerCustId</tt>.
     *
     * @return property value of ownerCustId
     */
    public String getOwnerCustId() {
        return ownerCustId;
    }

    /**
     * Setter method for property <tt>ownerCustId</tt>.
     *
     * @param ownerCustId value to be assigned to property ownerCustId
     */
    public void setOwnerCustId(String ownerCustId) {
        this.ownerCustId = ownerCustId;
    }

    /**
     * Getter method for property <tt>manerUserId</tt>.
     *
     * @return property value of manerUserId
     */
    public String getMannerUserId() {
        return mannerUserId;
    }

    /**
     * Setter method for property <tt>manerUserId</tt>.
     *
     * @param manerUserId value to be assigned to property manerUserId
     */
    public void setMannerUserId(String mannerUserId) {
        this.mannerUserId = mannerUserId;
    }
}
