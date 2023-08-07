/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * @author senyang
 * @version : UserLevelEnum.java, v 0.1 2023年08月07日 11:57 PM senyang Exp $
 */
public enum UserLevelEnum {

    NORMAL(1, "NORMAL"),
    SUPER(2,"SUPER");


    private int code;

    private String desc;

    UserLevelEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static UserLevelEnum getByCode(int code){
        for(UserLevelEnum userLevelEnum : UserLevelEnum.values()){
            if(userLevelEnum.getCode() == code){
                return userLevelEnum;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
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