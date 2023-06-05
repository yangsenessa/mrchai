package com.essa.mrchaiemc.biz.models.enumcollection;

public enum BussInfoKeyEnum {
    /** user login*/
    LOGINTYPE("identityType","identityType"),
    AUTHTOKEN("authToken","authToken"),
    APPLREGINFO("applRegInfo","applRegInfo"),
    APPLREGINFO_NICKNAME("nickName","nickName"),
    APPLREGINFO_EMAIL("email","email"),
    APPLREGINFO_MOBILEPHONE("mobilePhone","mobilePhone"),
    APPLREGINFO_LOGINID("loginId","loginId")
    ;


    private String code;

    private String desc;

    BussInfoKeyEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
