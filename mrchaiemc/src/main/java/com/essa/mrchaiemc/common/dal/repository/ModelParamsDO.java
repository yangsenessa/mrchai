package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;

@Entity
@Table(name = "model_params")
public class ModelParamsDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    @Column(name="version", nullable = true, length = 25)
    private String version;

    /** paramModel*/
    @Lob
    @Column(name = "promts", nullable = true, length = 4000,columnDefinition = "text")
    private String promts;

    /** negativeParams*/
    @Lob
    @Column(name = "negative_promts", nullable = true, length = 4000,columnDefinition = "text")
    private String negativePromts;

    /** commonParams*/
    @Lob
    @Column(name = "common_params", nullable = true, length = 4000,columnDefinition = "text")
    private String commonParams;

    /** invoke guide*/
    @Column(name = "invoke_guide", nullable = true, length = 4000,columnDefinition = "text")
    private String invokeGuide;

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

    public String getPromts() {
        return promts;
    }

    public void setPromts(String promts) {
        this.promts = promts;
    }

    public String getNegativePromts() {
        return negativePromts;
    }

    public void setNegativePromts(String negativePromts) {
        this.negativePromts = negativePromts;
    }

    public String getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(String commonParams) {
        this.commonParams = commonParams;
    }

    public String getInvokeGuide() {
        return invokeGuide;
    }

    public void setInvokeGuide(String invokeGuide) {
        this.invokeGuide = invokeGuide;
    }
}
