package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;

@Entity
@Table(name = "model_positive_promts")
public class ModelPositivePromtsDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    @Column(name = "version", nullable = true, length = 128)
    private String version;

    /** paramModel*/
    @Lob
    @Column(name = "promts", nullable = true, length = 5120,columnDefinition = "text")
    private String promts;

    @Lob
    @Column(name = "enhance_promts", nullable = true, length = 1024,columnDefinition = "text")
    private String enhancePromts;

    public String getPromts() {
        return promts;
    }

    public void setPromts(String promts) {
        this.promts = promts;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * Getter method for property <tt>enhancePromts</tt>.
     *
     * @return property value of enhancePromts
     */
    public String getEnhancePromts() {
        return enhancePromts;
    }

    /**
     * Setter method for property <tt>enhancePromts</tt>.
     *
     * @param enhancePromts value to be assigned to property enhancePromts
     */
    public void setEnhancePromts(String enhancePromts) {
        this.enhancePromts = enhancePromts;
    }
}
