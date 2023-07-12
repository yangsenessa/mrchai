package com.essa.mrchaiemc.biz.models.domains.usermanner;

import java.util.Date;

/**
 * 预留，目前没有token激励需求
 */
public class UserIdentifyLogs {
    /** userId*/
    private String userId;

    /** bizTraceId*/
    private String bizTraceId;

    /** loginChannel */
    private String loginChannel;

    /** gmtLogin*/
    private Date gmtLogin;

    /** gmtLgOut*/
    private Date gmtLogOut;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizTraceId() {
        return bizTraceId;
    }

    public void setBizTraceId(String bizTraceId) {
        this.bizTraceId = bizTraceId;
    }

    public String getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(String loginChannel) {
        this.loginChannel = loginChannel;
    }

    public Date getGmtLogin() {
        return gmtLogin;
    }

    public void setGmtLogin(Date gmtLogin) {
        this.gmtLogin = gmtLogin;
    }

    public Date getGmtLogOut() {
        return gmtLogOut;
    }

    public void setGmtLogOut(Date gmtLogOut) {
        this.gmtLogOut = gmtLogOut;
    }
}
