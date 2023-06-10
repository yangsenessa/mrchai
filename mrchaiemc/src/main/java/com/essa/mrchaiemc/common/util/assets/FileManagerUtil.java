/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util.assets;

import com.essa.mrchaiemc.common.integration.sys.SysConfigInit;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author senyang
 * @version : FileManagerUtil.java, v 0.1 2023年06月10日 11:15 PM senyang Exp $
 */
public class FileManagerUtil {

    /**
     * 获取图片默认路径
     * @return
     */
    public static String getImgPath(){
        Map<String,String> pathMap =  SysConfigInit.getSysConfig();
        if(pathMap != null){
            return pathMap.get("imgPath");
        }
        return null;
    }

    /**
     * 获取视频默认路径
     * @return
     */
    public static String getVideoPath(){
        Map<String, String> pathMap = SysConfigInit.getSysConfig();
        if(pathMap != null){
            return pathMap.get("videoPath");
        }
        return null;
    }

    /**
     * 获取用户图片路径
     * @param userId
     * @return
     */
    public static String getCustImgPath(HttpServletRequest request,String userId){
        return  request.getSession().getServletContext().getRealPath(getImgPath()) +"/"+userId;
    }

    /**
     * 获取用户视频路径
     * @param userId
     * @return
     */
    public static String getCustVideoPath(HttpServletRequest request,String userId){
        return  request.getSession().getServletContext().getRealPath(getVideoPath()) +"/"+userId;
    }
}