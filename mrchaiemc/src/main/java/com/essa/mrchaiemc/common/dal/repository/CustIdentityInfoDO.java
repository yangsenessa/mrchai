/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author senyang
 * @version : CustIdentityInfo.java, v 0.1 2023年05月25日 8:57 PM senyang Exp $
 */
@Entity
@Table(name = "cfg_custindentity_info")
public class CustIdentityInfoDO implements Serializable {
    @Id
    @Column(name = "custid", nullable = false, length = 15)
    private String custId;

    @Column(name = "authCode", nullable = true, length = 512)
    private String authCode;

    @Column(name ="oauthcode",nullable = true, length = 512)
    private String oAuthCode;

    @Column(name ="identichannel",nullable = true, length = 50)
    private String identiChannel;

    @Column(name ="gmtlogin",nullable = true, length = 200)
    private long gmtLogin;

    @Column(name ="gmtlogout",nullable = true, length = 200)
    private long gmtLogOut;

    @Column(name ="identiType",nullable = true, length = 512)
    private long identiType;

    /**
     * Getter method for property <tt>custId</tt>.
     *
     * @return property value of custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * Setter method for property <tt>custId</tt>.
     *
     * @param custId value to be assigned to property custId
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * Getter method for property <tt>identiChannel</tt>.
     *
     * @return property value of identiChannel
     */
    public String getIdentiChannel() {
        return identiChannel;
    }

    /**
     * Setter method for property <tt>identiChannel</tt>.
     *
     * @param identiChannel value to be assigned to property identiChannel
     */
    public void setIdentiChannel(String identiChannel) {
        this.identiChannel = identiChannel;
    }

    /**
     * Getter method for property <tt>authCode</tt>.
     *
     * @return property value of authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Setter method for property <tt>authCode</tt>.
     *
     * @param authCode value to be assigned to property authCode
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * Getter method for property <tt>oAuthCode</tt>.
     *
     * @return property value of oAuthCode
     */
    public String getoAuthCode() {
        return oAuthCode;
    }

    /**
     * Setter method for property <tt>oAuthCode</tt>.
     *
     * @param oAuthCode value to be assigned to property oAuthCode
     */
    public void setoAuthCode(String oAuthCode) {
        this.oAuthCode = oAuthCode;
    }

    /**
     * Getter method for property <tt>gmtLogin</tt>.
     *
     * @return property value of gmtLogin
     */
    public long getGmtLogin() {
        return gmtLogin;
    }

    /**
     * Setter method for property <tt>gmtLogin</tt>.
     *
     * @param gmtLogin value to be assigned to property gmtLogin
     */
    public void setGmtLogin(long gmtLogin) {
        this.gmtLogin = gmtLogin;
    }

    /**
     * Getter method for property <tt>gmtLogOut</tt>.
     *
     * @return property value of gmtLogOut
     */
    public long getGmtLogOut() {
        return gmtLogOut;
    }

    /**
     * Setter method for property <tt>gmtLogOut</tt>.
     *
     * @param gmtLogOut value to be assigned to property gmtLogOut
     */
    public void setGmtLogOut(long gmtLogOut) {
        this.gmtLogOut = gmtLogOut;
    }

    /**
     * Getter method for property <tt>identiType</tt>.
     *
     * @return property value of identiType
     */
    public long getIdentiType() {
        return identiType;
    }

    /**
     * Setter method for property <tt>identiType</tt>.
     *
     * @param identiType value to be assigned to property identiType
     */
    public void setIdentiType(long identiType) {
        this.identiType = identiType;
    }
}