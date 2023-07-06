package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;

@Entity
@Table(name = "model_params")
public class ModelParamsDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    /** version*/
    @Column(name = "version", nullable = true, length = 10)
    private String version;


    /** commonParams*/
    @Lob
    @Column(name = "common_params", nullable = true, length = 4000,columnDefinition = "text")
    private String commonParams;


    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }


    public String getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(String commonParams) {
        this.commonParams = commonParams;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
