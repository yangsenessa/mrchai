package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import com.essa.mrchaiemc.biz.models.params.EmcInvokeParam;
import com.essa.mrchaiemc.biz.models.params.ParamModel;

public class ModelDetailInfo {

    /** modelId*/
    private String modelId;

    /** paramModel*/
    private ParamModel paramModel;

    /** invoke guide*/
    private String invokeGuide;

    /** EmcInvokeParam */
    private EmcInvokeParam emcInvokeParam;

    /** downLoadLink*/
    private String downLoadLink;

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
}
