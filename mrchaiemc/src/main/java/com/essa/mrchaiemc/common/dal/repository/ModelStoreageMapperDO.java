package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model_storeage_mapper")
public class ModelStoreageMapperDO {

    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    /** bucket*/
    @Column(name = "bucket", nullable = true, length = 1024)
    private String bucket;

    /** storeUrl ,降级为本地存储时候有值*/
    @Column(name = "store_url", nullable = false, length = 128)
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
