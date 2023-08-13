/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.domains;

import com.essa.mrchaiemc.biz.models.enumcollection.FuzzyRequestStrategyEnum;

/**
 * @author senyang
 * @version : FuzzyRequest.java, v 0.1 2023年08月10日 10:34 PM senyang Exp $
 */
public class FuzzyRequest {

    /**
     * modelStat
     */
    private String modelStat;

    /**
     * describeText
     */
    private String desText;

    /**
     * cateGorytext
     */
    private String cateText;

    /**
     * tagText
     */
    private String tagText;

    /**
     * rrquest strategy
     */
    private FuzzyRequestStrategyEnum fuzzyRequestStrategyAction;

    /**
     * Getter method for property <tt>desText</tt>.
     *
     * @return property value of desText
     */
    public String getDesText() {
        return desText;
    }

    /**
     * Setter method for property <tt>desText</tt>.
     *
     * @param desText value to be assigned to property desText
     */
    public void setDesText(String desText) {
        this.desText = desText;
    }

    /**
     * Getter method for property <tt>cateText</tt>.
     *
     * @return property value of cateText
     */
    public String getCateText() {
        return cateText;
    }

    /**
     * Setter method for property <tt>cateText</tt>.
     *
     * @param cateText value to be assigned to property cateText
     */
    public void setCateText(String cateText) {
        this.cateText = cateText;
    }

    /**
     * Getter method for property <tt>tagText</tt>.
     *
     * @return property value of tagText
     */
    public String getTagText() {
        return tagText;
    }

    /**
     * Setter method for property <tt>tagText</tt>.
     *
     * @param tagText value to be assigned to property tagText
     */
    public void setTagText(String tagText) {
        this.tagText = tagText;
    }

    /**
     * Getter method for property <tt>fuzzyRequestStrategyAction</tt>.
     *
     * @return property value of fuzzyRequestStrategyAction
     */
    public FuzzyRequestStrategyEnum getFuzzyRequestStrategyAction() {
        return fuzzyRequestStrategyAction;
    }

    /**
     * Setter method for property <tt>fuzzyRequestStrategyAction</tt>.
     *
     * @param fuzzyRequestStrategyAction value to be assigned to property fuzzyRequestStrategyAction
     */
    public void setFuzzyRequestStrategyAction(FuzzyRequestStrategyEnum fuzzyRequestStrategyAction) {
        this.fuzzyRequestStrategyAction = fuzzyRequestStrategyAction;
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