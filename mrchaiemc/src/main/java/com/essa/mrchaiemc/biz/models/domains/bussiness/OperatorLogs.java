package com.essa.mrchaiemc.biz.models.domains.bussiness;

import com.essa.mrchaiemc.biz.models.enumcollection.ActionTypeEnum;

import java.util.Date;

/**
 * 模型上传下载流水
 */
public class OperatorLogs {

    /** traceId*/
    private String traceId;

    /** userId*/
    private String userId;

    /** 动作类型 ASSET_DOWNLOAD - ASSET_PUB*/
    private ActionTypeEnum actionType;

    /** 创建时间*/
    private Date gmtCreate;

    /** 流程结束时间*/
    private Date gmtFinish;

    /** 发起支付*/
    private Date gmtAcceptPay;

    /** 支付完成时间*/
    private Date gmtFinishPay;

    /** 业务状态 */
    private String bizStatus;

    /** 链上序列号*/
    private String emcTraceId;

    /** 链上结算状态*/
    private String settleStatus;

    /** 链上结算时间*/
    private Date settleDate;

    /** 内部订单号*/
    private String bizOrderId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtFinish() {
        return gmtFinish;
    }

    public void setGmtFinish(Date gmtFinish) {
        this.gmtFinish = gmtFinish;
    }

    public Date getGmtAcceptPay() {
        return gmtAcceptPay;
    }

    public void setGmtAcceptPay(Date gmtAcceptPay) {
        this.gmtAcceptPay = gmtAcceptPay;
    }

    public Date getGmtFinishPay() {
        return gmtFinishPay;
    }

    public void setGmtFinishPay(Date gmtFinishPay) {
        this.gmtFinishPay = gmtFinishPay;
    }

    public String getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(String bizStatus) {
        this.bizStatus = bizStatus;
    }

    public String getEmcTraceId() {
        return emcTraceId;
    }

    public void setEmcTraceId(String emcTraceId) {
        this.emcTraceId = emcTraceId;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getBizOrderId() {
        return bizOrderId;
    }

    public void setBizOrderId(String bizOrderId) {
        this.bizOrderId = bizOrderId;
    }
}
