package com.essa.mrchaiemc.biz.models.enumcollection;

public enum BussInfoKeyEnum {
    /** user login*/
    LOGINTYPE("identityType","identityType"),
    CUSTID("custId","custId"),
    AUTHTOKEN("authToken","authToken"),
    APPLREGINFO("applRegInfo","applRegInfo"),
    APPLREGINFO_NICKNAME("nickName","nickName"),
    APPLREGINFO_EMAIL("email","email"),
    APPLREGINFO_MOBILEPHONE("mobilePhone","mobilePhone"),
    APPLREGINFO_LOGINID("loginId","loginId"),
    MODEL_INFO("modelInfo","modelInfo"),
    MODEL_COVER("modelCover","modelCover"),
    MODEL_DETAIL("modelDetail","modelDetail"),
    MODEL_PRINCIPLE("modelPrinciple","modelPrinciple"),
    CATEGORY_1("category1","category1"),
    MODELID("model_id","model_id"),
    FILELINK("file_link","file_link"),
    /** ####### contorl    ##########*/
    PAGEINDEX("pageIndex","pageIndex"),
    PAGESIZE("pageSize", "pageSize")
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
