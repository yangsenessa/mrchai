/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author senyang
 * @version : CustAcctEntity.java, v 0.1 2023年07月17日 1:38 PM senyang Exp $
 */
@Entity
@Table(name = "cust_acct_base",indexes = {@Index(name = "cust_id_idx",columnList = "custid", unique = true)} )
public class CustAcctBaseDO implements Serializable {

    @Id
    @Column(name = "custid", nullable = false, length = 128)
    private String custId;

    @Column(name = "token_val", nullable = false, length = 128)
    private String tokenVal;

    @Column(name = "token_type", nullable = false, length = 128)
    private String tokenType;

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
     * Getter method for property <tt>tokenVal</tt>.
     *
     * @return property value of tokenVal
     */
    public String getTokenVal() {
        return tokenVal;
    }

    /**
     * Setter method for property <tt>tokenVal</tt>.
     *
     * @param tokenVal value to be assigned to property tokenVal
     */
    public void setTokenVal(String tokenVal) {
        this.tokenVal = tokenVal;
    }

    /**
     * Getter method for property <tt>tokenType</tt>.
     *
     * @return property value of tokenType
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Setter method for property <tt>tokenType</tt>.
     *
     * @param tokenType value to be assigned to property tokenType
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}