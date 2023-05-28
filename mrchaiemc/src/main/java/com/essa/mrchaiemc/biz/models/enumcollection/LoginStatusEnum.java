package com.essa.mrchaiemc.biz.models.enumcollection;

public enum LoginStatusEnum {

    HASLOGIN("HASLOGIN","HASLOGIN"),
    NOTLOGIN("NOTLOGIN","NOTLOGIN"),
    /** 登陆状态超时*/
    LOGIN_EXPIRED("LOGIN_EXPIRED","LOGIN_EXPIRED");

    private String code;

    private String msg;

    LoginStatusEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
