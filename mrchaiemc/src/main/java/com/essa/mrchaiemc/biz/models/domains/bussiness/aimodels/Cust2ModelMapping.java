package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import com.essa.mrchaiemc.biz.models.enumcollection.ModelCustVIewStatEnum;

import java.util.Date;

public class Cust2ModelMapping {
    /** userId*/
    private String userId;

    /** modelId*/
    private String modelId;

    /** gmtCreate*/
    private Date gmtBizCreate;

    /** gmtBizModified*/
    private Date gmtBizModified;

    /** gmtDrop*/
    private Date gmtDrop;

    /** status*/
    private ModelCustVIewStatEnum status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Date getGmtBizCreate() {
        return gmtBizCreate;
    }

    public void setGmtBizCreate(Date gmtBizCreate) {
        this.gmtBizCreate = gmtBizCreate;
    }

    public Date getGmtBizModified() {
        return gmtBizModified;
    }

    public void setGmtBizModified(Date gmtBizModified) {
        this.gmtBizModified = gmtBizModified;
    }

    public Date getGmtDrop() {
        return gmtDrop;
    }

    public void setGmtDrop(Date gmtDrop) {
        this.gmtDrop = gmtDrop;
    }

    public ModelCustVIewStatEnum getStatus() {
        return status;
    }

    public void setStatus(ModelCustVIewStatEnum status) {
        this.status = status;
    }
}
