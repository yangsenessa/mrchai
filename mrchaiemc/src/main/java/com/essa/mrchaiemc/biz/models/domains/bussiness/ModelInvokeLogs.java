package com.essa.mrchaiemc.biz.models.domains.bussiness;

import java.util.Date;

/**
 * 模型算力节点调用流水
 */
public class ModelInvokeLogs {

    /** traceId*/
    private String traceId;

    /** modelId*/
    private String modelId;

    /** 调用开始时间*/
    private Date gmtStart;

    /** 调用结束时间*/
    private Date gmtFinished;

    /** 运行结果下载链接*/
    private String resultDataDownLink;

    /** 节点id*/
    private String peerId;

    /** emc算力调用链上序列号*/
    private String emcTraceId;

    /** 业务订单号*/
    private String bizOrderId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Date getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    public Date getGmtFinished() {
        return gmtFinished;
    }

    public void setGmtFinished(Date gmtFinished) {
        this.gmtFinished = gmtFinished;
    }

    public String getResultDataDownLink() {
        return resultDataDownLink;
    }

    public void setResultDataDownLink(String resultDataDownLink) {
        this.resultDataDownLink = resultDataDownLink;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getEmcTraceId() {
        return emcTraceId;
    }

    public void setEmcTraceId(String emcTraceId) {
        this.emcTraceId = emcTraceId;
    }

    public String getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(String bizOrderId) {
        this.bizOrderId = bizOrderId;
    }
}
