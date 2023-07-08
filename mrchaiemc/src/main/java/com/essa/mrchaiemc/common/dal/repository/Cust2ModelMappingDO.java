package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cust_model_mapping",indexes = {@Index(name = "cust_id_idx",columnList = "cust_id,model_id", unique = true)})
public class Cust2ModelMappingDO implements Serializable {
    @Id
    @Column(name = "mapper_id", nullable = false, length = 128)
    private String mapperId;

    @Column(name = "cust_id", nullable = false, length = 128)
    private String custId;

    @Column(name ="model_id", nullable = false,length = 120)
    private String modelId;

    @Column(name = "gmt_create", nullable = false, length = 20)
    private long gmtCreate;

    @Column(name = "status", nullable = false ,length = 10)
    private String status;

    public String getMapperId() {
        return mapperId;
    }

    public void setMapperId(String mapperId) {
        this.mapperId = mapperId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
