package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

/**
 * 模型映射分布式对象存储
 */
public class ModelStoreageMapper {
    /** modelId*/
    private String modelId;

    /** bucket 分布式对象存储 bucket*/
    private String bucket;

    /** storeUrl ,降级为本地存储时候有值*/
    private String storeUrl;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }
}
