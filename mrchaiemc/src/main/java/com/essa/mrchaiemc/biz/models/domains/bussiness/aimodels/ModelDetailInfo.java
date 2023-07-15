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
    private String downLoadLink;

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
    private String commonParams;

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

    public String getDownLoadLink() {
        return downLoadLink;
    }

    public void setDownLoadLink(String downLoadLink) {
        this.downLoadLink = downLoadLink;
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

    public String getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(String commonParams) {
        this.commonParams = commonParams;
    }
}
