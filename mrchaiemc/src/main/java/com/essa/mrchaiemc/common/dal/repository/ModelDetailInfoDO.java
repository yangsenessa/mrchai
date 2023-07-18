package com.essa.mrchaiemc.common.dal.repository;


import javax.persistence.*;

@Entity
@Table(name = "model_detail")
public class ModelDetailInfoDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;
    /** modelDesc*/
    @Column(name = "model_desc", nullable = true, length = 1024)
    private String modelDesc;

    @Column(name="version", nullable = true, length = 25)
    private String version;


    /** EmcInvokeParam */
    @Column(name = "emc_invoke_param", nullable = true, length = 128)
    private String emcInvokeParam;

    /** downLoadLink*/
    @Column(name = "model_file_link", nullable = true, length = 512)
    private String modelFileLink;

    /** params_guide_link*/
    @Column(name = "params_guide_link", nullable = true, length = 128)
    private String paramsGuideLink;

    /** guide_link*/
    @Column(name = "guide_link", nullable = true, length = 128)
    private String guideLink;

    /** sample_code_link*/
    @Column(name = "sample_code_link", nullable = true, length = 128)
    private String sampleCodeLink;
    /** num_inference_steps*/
    @Column(name = "num_inference_steps", nullable = true, length = 20)
    private int numInferenceSteps;
    /** seed */
    @Column(name = "seed", nullable = true, length = 20)
    private int seed;

    /** tags*/
    @Column(name = "tags", nullable = true, length = 500)
    private String tags;

    /**
     * Getter method for property <tt>modelFileLink</tt>.
     *
     * @return property value of modelFileLink
     */
    public String getModelFileLink() {
        return modelFileLink;
    }

    /**
     * Setter method for property <tt>modelFileLink</tt>.
     *
     * @param modelFileLink value to be assigned to property modelFileLink
     */
    public void setModelFileLink(String modelFileLink) {
        this.modelFileLink = modelFileLink;
    }

    /**
     * Getter method for property <tt>numInferenceSteps</tt>.
     *
     * @return property value of numInferenceSteps
     */
    public int getNumInferenceSteps() {
        return numInferenceSteps;
    }

    /**
     * Setter method for property <tt>numInferenceSteps</tt>.
     *
     * @param numInferenceSteps value to be assigned to property numInferenceSteps
     */
    public void setNumInferenceSteps(int numInferenceSteps) {
        this.numInferenceSteps = numInferenceSteps;
    }

    /**
     * Getter method for property <tt>seed</tt>.
     *
     * @return property value of seed
     */
    public int getSeed() {
        return seed;
    }

    /**
     * Setter method for property <tt>seed</tt>.
     *
     * @param seed value to be assigned to property seed
     */
    public void setSeed(int seed) {
        this.seed = seed;
    }

    /**
     * Getter method for property <tt>tags</tt>.
     *
     * @return property value of tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * Setter method for property <tt>tags</tt>.
     *
     * @param tags value to be assigned to property tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getParamsGuideLink() {
        return paramsGuideLink;
    }

    public void setParamsGuideLink(String paramsGuideLink) {
        this.paramsGuideLink = paramsGuideLink;
    }

    public String getGuideLink() {
        return guideLink;
    }

    public void setGuideLink(String guideLink) {
        this.guideLink = guideLink;
    }

    public String getSampleCodeLink() {
        return sampleCodeLink;
    }

    public void setSampleCodeLink(String sampleCodeLink) {
        this.sampleCodeLink = sampleCodeLink;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public String getEmcInvokeParam() {
        return emcInvokeParam;
    }

    public void setEmcInvokeParam(String emcInvokeParam) {
        this.emcInvokeParam = emcInvokeParam;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
