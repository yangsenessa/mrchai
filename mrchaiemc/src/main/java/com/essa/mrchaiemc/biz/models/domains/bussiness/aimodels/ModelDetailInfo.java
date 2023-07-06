package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import com.essa.mrchaiemc.biz.models.params.EmcInvokeParam;
import com.essa.mrchaiemc.biz.models.params.ParamModel;

public class ModelDetailInfo {

    /** modelId*/
    private String modelId;


    /** vesion*/
    private String version;

    /** paramModel*/
    private ParamModel paramModel;

    /** invoke guide*/
    private String invokeGuide;

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

    public ParamModel getParamModel() {
        return paramModel;
    }

    public void setParamModel(ParamModel paramModel) {
        this.paramModel = paramModel;
    }

    public String getInvokeGuide() {
        return invokeGuide;
    }

    public void setInvokeGuide(String invokeGuide) {
        this.invokeGuide = invokeGuide;
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
}
