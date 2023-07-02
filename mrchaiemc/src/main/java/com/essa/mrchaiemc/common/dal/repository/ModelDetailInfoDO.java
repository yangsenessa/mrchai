package com.essa.mrchaiemc.common.dal.repository;

import com.essa.mrchaiemc.biz.models.params.EmcInvokeParam;

import javax.persistence.*;

@Entity
@Table(name = "model_detail")
public class ModelDetailInfoDO {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    /** paramModel*/
    @Column(name = "params", nullable = true, length = 5120)
    private String params;

    /** invoke guide*/
    @Column(name = "invoke_guide", nullable = true, length = 5120)
    private String invokeGuide;

    /** EmcInvokeParam */
    @Column(name = "emc_invoke_param", nullable = true, length = 5120)
    private String emcInvokeParam;

    /** downLoadLink*/
    @Column(name = "download_link", nullable = true, length = 5120)
    private String downLoadLink;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getInvokeGuide() {
        return invokeGuide;
    }

    public void setInvokeGuide(String invokeGuide) {
        this.invokeGuide = invokeGuide;
    }

    public String getEmcInvokeParam() {
        return emcInvokeParam;
    }

    public void setEmcInvokeParam(String emcInvokeParam) {
        this.emcInvokeParam = emcInvokeParam;
    }

    public String getDownLoadLink() {
        return downLoadLink;
    }

    public void setDownLoadLink(String downLoadLink) {
        this.downLoadLink = downLoadLink;
    }
}
