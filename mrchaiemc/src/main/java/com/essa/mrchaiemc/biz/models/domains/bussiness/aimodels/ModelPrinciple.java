package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

public class ModelPrinciple {

    /** modelId*/
    private String modelId;

    /** downLoadPrice*/
    private long downLoadPrice;

    /** invokePrice*/
    private long invokePrice;

    /** enableDownLoad*/
    private boolean enableDownLoad;

    /** enableInvoke*/
    private boolean enableInvoke;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public long getDownLoadPrice() {
        return downLoadPrice;
    }

    public void setDownLoadPrice(long downLoadPrice) {
        this.downLoadPrice = downLoadPrice;
    }

    public long getInvokePrice() {
        return invokePrice;
    }

    public void setInvokePrice(long invokePrice) {
        this.invokePrice = invokePrice;
    }

    public boolean isEnableDownLoad() {
        return enableDownLoad;
    }

    public void setEnableDownLoad(boolean enableDownLoad) {
        this.enableDownLoad = enableDownLoad;
    }

    public boolean isEnableInvoke() {
        return enableInvoke;
    }

    public void setEnableInvoke(boolean enableInvoke) {
        this.enableInvoke = enableInvoke;
    }
}
