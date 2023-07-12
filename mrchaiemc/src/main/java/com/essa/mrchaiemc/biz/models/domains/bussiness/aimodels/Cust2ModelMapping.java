package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import com.essa.mrchaiemc.biz.models.enumcollection.ModelCustVIewStatEnum;

import java.util.Date;

/**
 * 用户模型归属映射模型
 */
public class Cust2ModelMapping {
    /** userId*/
    private String userId;

    /** modelId 模型id*/
    private String modelId;

    /** gmtCreate 模型创建时间*/
    private Date gmtBizCreate;

    /** gmtBizModified 上一次模型修改时间*/
    private Date gmtBizModified;

    /** gmtDrop 模型删除/下架时间*/
    private Date gmtDrop;

    /** status 模型展示状态*/
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
