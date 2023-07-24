/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.common.integration.sys.BussConstant;

/**
 * @author senyang
 * @version : CanisterUtil.java, v 0.1 2023年07月22日 3:17 PM senyang Exp $
 */
public class CanisterUtil {

    public static String transferUrlPattern(String oriUrl) {
        String processUrl = StringUtil.EMPTY;
        String resUrl = StringUtil.EMPTY;
        //check it is a valid url
        if(!StringUtil.contains(oriUrl,"http")){
           return oriUrl;
        }
        // remove suffix
        if(StringUtil.contains(oriUrl,"?")){
            //contail "?" remove suffix
            String[] spiltOriUrl = StringUtil.split(oriUrl,"?");
            if(spiltOriUrl != null && StringUtil.isNotEmpty(spiltOriUrl[0])){
                processUrl = spiltOriUrl[0];

            } else {
                LoggerUtil.errlog("Split Url error");
                return resUrl;
            }

        }
        if(StringUtil.isNotEmpty(processUrl)){
            StringBuffer strb = new StringBuffer();
            strb.append(BussConstant.EMCAIURL);

            //remove "http://"
            processUrl = StringUtil.remove(processUrl,"http://");
            //splt by layer1 url
            String[] splitProcessUrl = StringUtil.split(processUrl,"/");
            if(splitProcessUrl == null && splitProcessUrl.length <= 0){
                LoggerUtil.errlog("Split Url error");
                return resUrl;
            }
            //ignore lay1,and joint the others to result
            for(int i=1; i< splitProcessUrl.length; i++){
                strb.append("/");
                strb.append(splitProcessUrl[i]);
            }
            resUrl = strb.toString();
        }
        return resUrl;
    }
}