package com.essa.mrchaiemc.biz.models.enumcollection;

public enum BussInfoKeyEnum {
    /** user login*/
    LOGINTYPE("identityType","identityType"),
    AUTHTOKEN("authToken","authToken"),
    APPLREGINFO("applRegInfo","applRegInfo"),
    APPLREGINFO_NICKNAME("nickName","nickName"),
    APPLREGINFO_EMAIL("email","email"),
    APPLREGINFO_MOBILEPHONE("mobilePhone","mobilePhone"),
    APPLREGINFO_LOGINID("loginId","loginId"),
    MODEL_INFO("modelInfo","modelInfo"),
    MODEL_DETAIL("modelDetail","modelDetail"),
    PARAM_MODEL("paramModel","paramModel"),
    INVOKE_GUIDE("invoke_guide","invoke_guide"),
    POSITIVE_PROMTS("positive_promts","positive_promts"),
    NEGATIVE_PROMTS("negative_promts","negative_promts"),
    MODEL_COMMON_PARAMS("common_promts", "common_promts"),
    MODEL_PRINCIPLE("modelPrinciple","modelPrinciple"),
    CATEGORY_1("category1","category1"),
    MODELID("model_id","model_id")
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
