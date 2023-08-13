/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.req;

/**
 * @author senyang
 * @version : FuzzyReq.java, v 0.1 2023年08月13日 12:15 PM senyang Exp $
 */
public class FuzzyReq extends BaseReq{
    /** custId*/
    private String custId;

    /** loginId*/
    private String loginId;

    /** model_stat*/
    private String modelStat;

    /** fuzzy totile pattern*/
    private String titlePattern;

    /** mapper to category2*/
    private String categroyPattern;

    /** mapper to category1*/
    private String tagPattern;

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
     * Getter method for property <tt>loginId</tt>.
     *
     * @return property value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Setter method for property <tt>loginId</tt>.
     *
     * @param loginId value to be assigned to property loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Getter method for property <tt>titlePattern</tt>.
     *
     * @return property value of titlePattern
     */
    public String getTitlePattern() {
        return titlePattern;
    }

    /**
     * Setter method for property <tt>titlePattern</tt>.
     *
     * @param titlePattern value to be assigned to property titlePattern
     */
    public void setTitlePattern(String titlePattern) {
        this.titlePattern = titlePattern;
    }

    /**
     * Getter method for property <tt>categroyPattern</tt>.
     *
     * @return property value of categroyPattern
     */
    public String getCategroyPattern() {
        return categroyPattern;
    }

    /**
     * Setter method for property <tt>categroyPattern</tt>.
     *
     * @param categroyPattern value to be assigned to property categroyPattern
     */
    public void setCategroyPattern(String categroyPattern) {
        this.categroyPattern = categroyPattern;
    }

    /**
     * Getter method for property <tt>tagPattern</tt>.
     *
     * @return property value of tagPattern
     */
    public String getTagPattern() {
        return tagPattern;
    }

    /**
     * Setter method for property <tt>tagPattern</tt>.
     *
     * @param tagPattern value to be assigned to property tagPattern
     */
    public void setTagPattern(String tagPattern) {
        this.tagPattern = tagPattern;
    }

    /**
     * Getter method for property <tt>modelStat</tt>.
     *
     * @return property value of modelStat
     */
    public String getModelStat() {
        return modelStat;
    }

    /**
     * Setter method for property <tt>modelStat</tt>.
     *
     * @param modelStat value to be assigned to property modelStat
     */
    public void setModelStat(String modelStat) {
        this.modelStat = modelStat;
    }
}