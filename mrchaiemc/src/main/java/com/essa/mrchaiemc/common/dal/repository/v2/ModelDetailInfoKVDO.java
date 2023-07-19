/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.repository.v2;

import javax.persistence.*;
import java.io.Serializable;

/**
 * kv-store
 * @author senyang
 * @version : ModelDetailInfoKVDO.java, v 0.1 2023年07月19日 11:54 PM senyang Exp $
 */
@Entity
@Table(name = "model_detail_kv")
public class ModelDetailInfoKVDO implements Serializable {
    /**
     * modelId#version#colName
     */
    @Id
    @Column(name = "main_key", nullable = false, length = 256)
    private String mainKey;

    /**
     * modelId#version
     */
    @Column(name = "group_key", nullable = false, length = 256)
    private String groupKey;

    @Column(name = "col_name", nullable = false, length = 256)
    private String colName;

    @Lob
    @Column(name = "value", nullable = true, length = 5120,columnDefinition = "text")
    private String value;

    /**
     * Getter method for property <tt>groupKey</tt>.
     *
     * @return property value of groupKey
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * Setter method for property <tt>groupKey</tt>.
     *
     * @param groupKey value to be assigned to property groupKey
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * Getter method for property <tt>colName</tt>.
     *
     * @return property value of colName
     */
    public String getColName() {
        return colName;
    }

    /**
     * Setter method for property <tt>colName</tt>.
     *
     * @param colName value to be assigned to property colName
     */
    public void setColName(String colName) {
        this.colName = colName;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter method for property <tt>value</tt>.
     *
     * @param value value to be assigned to property value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Getter method for property <tt>mainKey</tt>.
     *
     * @return property value of mainKey
     */
    public String getMainKey() {
        return mainKey;
    }

    /**
     * Setter method for property <tt>mainKey</tt>.
     *
     * @param mainKey value to be assigned to property mainKey
     */
    public void setMainKey(String mainKey) {
        this.mainKey = mainKey;
    }
}