package com.essa.mrchaiemc.common.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request){

        return request.getSession();
    }

    /**
     * get session val
     * @param request
     * @param key
     * @return
     */
    public static String getSessionVal(HttpServletRequest request,String key){
        HttpSession session = getSession(request);
        if(session == null || session.getAttribute(key) == null){
            return "";
        }
        return session.getAttribute(key).toString();
    }


    /**
     * set session val
     * @param request
     * @param key
     * @param val
     */
    public static void setSessionVal(HttpServletRequest request,String key, String val){
        HttpSession session = getSession(request);
        if(session == null){
            throw new RuntimeException("None session hold");
        }
        session.setAttribute(key, val);
    }


    /**
     * session 中获取userId
     * @param request
     * @return
     */
    public static String getUserIdFromSession(HttpSession session){

        if(session == null) {
            throw new RuntimeException("None session hole");
        }
        if(session.getAttribute("userId") != null){
           return session.getAttribute("userId").toString();
        }
        return null;

    }
}
