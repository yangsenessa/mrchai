/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * @author senyang
 * @version : AssetTypeEnum.java, v 0.1 2023年05月25日 9:11 PM senyang Exp $
 * The ENUM which can labled the filename/bulket-key involved file type
 */
public enum AssetTypeEnum {

    PICTURE("PICTURE","PICTURE"),
    AVATAR("AVATAR","AVATAR"),
    SOUND("SOUND","SOUND"),
    VIDEO("VIDEO","VIDEO");

    private String code;

    private String desc;

    AssetTypeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

}