/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import java.util.Date;

/**
 * @author senyang
 * @version : DateUtil.java, v 0.1 2023年06月05日 9:40 PM senyang Exp $
 */
public class DateUtil {
    /**
     * 返回当前系统时间戳
     * @return
     */
    public static long getGmtDateTime(){
        Date date = new Date();
        return date.getTime();
    }

    /**
     * 返回系统当前的date
     * @return
     */
    public static Date getGmtDate() {
        return new Date();
    }
}