/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;

/**
 * @author senyang
 * @version : LogInStatusUtil.java, v 0.1 2023年06月05日 9:43 PM senyang Exp $
 */
public class LogInStatusUtil {
    /**
     * 判断用户是否登录成功
     * @param response
     * @return
     */
    public static boolean isCustLogInSuccess(BussResponse response){
        if(response ==  null || StringUtil.equals(ResultCode.NEEDREGISTER.getMsg(), response.getResCode())
                || StringUtil.equals(ResultCode.AUTHERR.getMsg(),response.getResCode())
                || StringUtil.equals(ResultCode.NEEDLOGIN.getMsg(),response.getResCode())){
            return false;
        }
        return true;
    }
}