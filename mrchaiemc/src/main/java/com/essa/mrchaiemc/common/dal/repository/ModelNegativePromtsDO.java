package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;

@Entity
@Table(name = "model_negative_promts")
public class ModelNegativePromtsDO {

    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    @Column(name = "version", nullable = true, length = 128)
    private String version;

    /** negativeParams*/
    @Lob
    @Column(name = "negative_promts", nullable = true, length = 5120,columnDefinition = "text")
    private String negativePromts;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNegativePromts() {
        return negativePromts;
    }

    public void setNegativePromts(String negativePromts) {
        this.negativePromts = negativePromts;
    }
}
