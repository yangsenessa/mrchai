/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import java.util.Map;

/**
 * @author senyang
 * @version : ModelDetailInfoV2.java, v 0.1 2023年07月20日 12:11 AM senyang Exp $
 */
public class ModelDetailInfoV2 {
    /** modelId*/
    private String modelId;

    /** vesion*/
    private String version;

    /** modelFileNames*/
    private String modelFileNames;

    /** modelFileLink*/
    private String modelFileLinks;

    /** modelFileHashCodes */
    private String modelFileHashCodes;

    /** extDetailInfo*/
    private Map<String,String> extDetailInfo;

    /**
     * Getter method for property <tt>modelId</tt>.
     *
     * @return property value of modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * Setter method for property <tt>modelId</tt>.
     *
     * @param modelId value to be assigned to property modelId
     */
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * Getter method for property <tt>version</tt>.
     *
     * @return property value of version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter method for property <tt>version</tt>.
     *
     * @param version value to be assigned to property version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Getter method for property <tt>modelFileLinks</tt>.
     *
     * @return property value of modelFileLinks
     */
    public String getModelFileLinks() {
        return modelFileLinks;
    }

    /**
     * Setter method for property <tt>modelFileLinks</tt>.
     *
     * @param modelFileLinks value to be assigned to property modelFileLinks
     */
    public void setModelFileLinks(String modelFileLinks) {
        this.modelFileLinks = modelFileLinks;
    }

    /**
     * Getter method for property <tt>modelFileHashCodes</tt>.
     *
     * @return property value of modelFileHashCodes
     */
    public String getModelFileHashCodes() {
        return modelFileHashCodes;
    }

    /**
     * Setter method for property <tt>modelFileHashCodes</tt>.
     *
     * @param modelFileHashCodes value to be assigned to property modelFileHashCodes
     */
    public void setModelFileHashCodes(String modelFileHashCodes) {
        this.modelFileHashCodes = modelFileHashCodes;
    }

    /**
     * Getter method for property <tt>extDetailInfo</tt>.
     *
     * @return property value of extDetailInfo
     */
    public Map<String, String> getExtDetailInfo() {
        return extDetailInfo;
    }

    /**
     * Setter method for property <tt>extDetailInfo</tt>.
     *
     * @param extDetailInfo value to be assigned to property extDetailInfo
     */
    public void setExtDetailInfo(Map<String, String> extDetailInfo) {
        this.extDetailInfo = extDetailInfo;
    }

    /**
     * Getter method for property <tt>modelFileNames</tt>.
     *
     * @return property value of modelFileNames
     */
    public String getModelFileNames() {
        return modelFileNames;
    }

    /**
     * Setter method for property <tt>modelFileNames</tt>.
     *
     * @param modelFileNames value to be assigned to property modelFileNames
     */
    public void setModelFileNames(String modelFileNames) {
        this.modelFileNames = modelFileNames;
    }
}