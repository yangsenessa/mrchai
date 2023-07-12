package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

/**
 * 模型定价
 */
public class ModelPrinciple {

    /** modelId*/
    private String modelId;

    /** downLoadPrice 下载价格/+定价  -激励 */
    private long downLoadPrice;

    /** invokePrice 调用算力节点价格， +定价  -激励*/
    private long invokePrice;

    /** enableDownLoad 是否允许下载*/
    private boolean enableDownLoad;

    /** enableInvoke 是否允许通过算力节点调度*/
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
