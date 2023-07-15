package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model_invoke_guide")
public class ModelInvokeGuideDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    /** invoke guide*/
    @Column(name = "invoke_guide", nullable = true, length = 5120,columnDefinition = "text")
    private String invokeGuide;

    /** version*/
    @Column(name = "version", nullable = true, length = 128)
    private String version;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getInvokeGuide() {
        return invokeGuide;
    }

    public void setInvokeGuide(String invokeGuide) {
        this.invokeGuide = invokeGuide;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
