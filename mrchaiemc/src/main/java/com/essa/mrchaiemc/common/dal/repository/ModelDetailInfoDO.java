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
    @Column(name = "download_link", nullable = true, length = 128)
    private String downLoadLink;

    /** params_guide_link*/
    @Column(name = "params_guide_link", nullable = true, length = 128)
    private String paramsGuideLink;

    /** guide_link*/
    @Column(name = "guide_link", nullable = true, length = 128)
    private String guideLink;

    /** sample_code_link*/
    @Column(name = "sample_code_link", nullable = true, length = 128)
    private String sampleCodeLink;




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
}
