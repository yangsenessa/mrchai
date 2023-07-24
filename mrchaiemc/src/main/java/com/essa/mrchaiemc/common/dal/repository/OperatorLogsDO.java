package com.essa.mrchaiemc.common.dal.repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operator_logs")
public class OperatorLogsDO {

    @Id
    @GenericGenerator(name = "snowFlakeIdGenerator", strategy = "com.essa.mrchaiemc.common.util.idgen.SnowFlakeIdGenerator")
    @GeneratedValue (generator = "snowFlakeIdGenerator")
    @Column(name = "id")
    private String Id;

    @Column(name = "trace_id", nullable = false, length = 128)
    private String traceId;

    @Column(name = "cust_id", nullable = false, length = 128)
    private String custId;

    @Column(name = "action_code", length = 128)
    private String actionCode;

    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;

    @Column(name = "gmt_finish", nullable = false)
    private Date gmtFinish;

    @Column(name = "gmt_accept_pay")
    private Date gmtAcceptPay;

    @Column(name = "gmt_finish_pay")
    private Date gmtFinishPay;

    @Column(name = "biz_status", length = 10)
    private String bizStatus;

    @Column(name = "emc_trace_id", length = 128)
    private String emcTraceId;

    @Column(name = "settle_status", length = 10)
    private String settleStatus;

    @Column(name = "settle_date")
    private Date settleDate;

    @Column(name = "biz_order_id", length = 128)
    private String bizOrderId;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
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
