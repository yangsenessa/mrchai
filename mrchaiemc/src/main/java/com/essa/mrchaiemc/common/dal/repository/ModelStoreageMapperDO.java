package com.essa.mrchaiemc.common.dal.repository;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model_storeage_mapper")
public class ModelStoreageMapperDO {

    /** modelId*/
    @Id
    @Column(name="hash_code", nullable = false,length = 50)
    private String hashCode;

    @Column(name="hash_code_long", nullable = true, length = 512)
    private String hashCodeLong;
    
    /** bucket*/
    @Column(name = "bucket", nullable = true, length = 128)
    private String bucket;

    /** storeUrl ,降级为本地存储时候有值*/
    @Column(name = "store_url", nullable = false, length = 512)
    private String storeUrl;


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
