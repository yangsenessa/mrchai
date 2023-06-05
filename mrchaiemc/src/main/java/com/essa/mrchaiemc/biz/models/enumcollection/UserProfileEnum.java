/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * @author senyang
 * @version : UserProfileEnum.java, v 0.1 2023年06月06日 12:09 AM senyang Exp $
 */
public enum UserProfileEnum {
    /** 待激活*/
    UN_AUTHTOKEN("UN_AUTHTOKEN","UN_AUTHTOKEN"),
    /** 冻结*/
    FREEZE("FREEZE","FREEZE"),
    /** 正常*/
    NORMAL("NORMAL","NORMAL")
    ;


    private String code;

    private String desc;

    UserProfileEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     *
     * @param desc value to be assigned to property desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}