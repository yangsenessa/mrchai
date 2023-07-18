package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import com.essa.mrchaiemc.biz.models.params.EmcInvokeParam;
import com.essa.mrchaiemc.biz.models.params.ParamModel;

public class ModelDetailInfo {

    /** modelId*/
    private String modelId;

    /** modelDesc*/
    private String modelDesc;

    /** vesion*/
    private String version;


    /** EmcInvokeParam */
    private EmcInvokeParam emcInvokeParam;

    /** downLoadLink*/
    private String modelFileLink;

    /** guide_link*/
    private String guideLink;

    /** paramsGuideLink*/
    private String paramsGuideLink;

    /** sample_code_link */
    private String sampleCodeLink;

    /** invoke_guide*/
    private String invokeGuide;

    /** negative promts*/
    private String negativePromts;

    /** positive_promts*/
    private String positivePromts;

    /** common_params*/
    private String enhancePromts;

    /** numInferenceSteps*/
    private int numInferenceSteps;

    /** seed*/
    private int seed;

    /** sampleImgFileLink*/
    private String sampleImgFileLink;

    /** tags*/
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
     * Getter method for property <tt>sampleImgFileLink</tt>.
     *
     * @return property value of sampleImgFileLink
     */
    public String getSampleImgFileLink() {
        return sampleImgFileLink;
    }

    /**
     * Setter method for property <tt>sampleImgFileLink</tt>.
     *
     * @param sampleImgFileLink value to be assigned to property sampleImgFileLink
     */
    public void setSampleImgFileLink(String sampleImgFileLink) {
        this.sampleImgFileLink = sampleImgFileLink;
    }

    public String getNegativePromts() {
        return negativePromts;
    }

    public void setNegativePromts(String negativePromts) {
        this.negativePromts = negativePromts;
    }

    public String getPositivePromts() {
        return positivePromts;
    }

    public void setPositivePromts(String positivePromts) {
        this.positivePromts = positivePromts;
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



    public EmcInvokeParam getEmcInvokeParam() {
        return emcInvokeParam;
    }

    public void setEmcInvokeParam(EmcInvokeParam emcInvokeParam) {
        this.emcInvokeParam = emcInvokeParam;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParamsGuideLink() {
        return paramsGuideLink;
    }

    public void setParamsGuideLink(String paramsGuideLink) {
        this.paramsGuideLink = paramsGuideLink;
    }

    public String getInvokeGuide() {
        return invokeGuide;
    }

    public void setInvokeGuide(String invokeGuide) {
        this.invokeGuide = invokeGuide;
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
