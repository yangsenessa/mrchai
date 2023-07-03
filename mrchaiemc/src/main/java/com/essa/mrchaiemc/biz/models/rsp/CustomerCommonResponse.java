package com.essa.mrchaiemc.biz.models.rsp;


import java.util.Map;

public class CustomerCommonResponse extends BaseRsp {


    /**
     * 用户登录态
     */
    private String loginStatus;


    /**
     * 扩展业务返回
     * @return
     */
    private Map<String,String> bussData ;

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Map<String, String> getBussData() {
        return bussData;
    }

    public void setBussData(Map<String, String> bussData) {
        this.bussData = bussData;
    }
}
