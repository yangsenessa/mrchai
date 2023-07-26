package com.essa.mrchaiemc.biz.models.enumcollection;

public enum BussInfoKeyEnum {
    /** user login*/
    LOGINTYPE("identityType","identityType"),
    CUSTID("custId","custId"),
    WALLETTOKEN("walletToken","walletToken"),
    AUTHTOKEN("authToken","authToken"),
    APPLREGINFO("applRegInfo","applRegInfo"),
    APPLREGINFO_NICKNAME("nickName","nickName"),
    APPLREGINFO_LOGINID("loginId","loginId"),
    APPLREGINFO_CUST_PRINCIPLE("custPrinciple","custPrinciple"),
    APPLREGINFO_EMAIL("email","email"),
    APPLRREGINFO_MOBILEPHONENO("mobilePhoneNo","mobilePhoneNo"),
    APPLREGINFO_MOBILEPHONE("mobilePhone","mobilePhone"),
    MODEL_INFO("modelInfo","modelInfo"),
    MODEL_COVER("modelCover","modelCover"),
    MODEL_DETAIL("modelDetail","modelDetail"),
    MODEL_PRINCIPLE("modelPrinciple","modelPrinciple"),
    CATEGORY_1("category1","category1"),
    MODELID("modelId","modelId"),
    FILELINK("file_link","file_link"),
    /** ####### contorl    ##########*/
    PAGEINDEX("pageIndex","pageIndex"),
    PAGESIZE("pageSize", "pageSize"),
    /** ========================================== */
    MODELINFO_MODELNAME("modelName","modelName"),
    MODELINFO_MODELSUBNAME("modelSubName","modelSubName"),
    MODELINFO_CATEGORY1("category1","category1"),
    MODELINFO_CATEGORY2("category2","category2"),
    MODELINFO_CATEGORY3("category3","category3"),
    /** =================================================*/
    MODELDETAIL_VERSION("version","version"),
    MODELDETAIL_MODELFILELINKS("modelFileLinks","modelFileLinks"),
    MODELDETAIL_SAMPLEIMGLINKS("sampleImgFileLinks","sampleImgFileLinks"),
    MODELDETAIL_MODELFILEHASECODE("modelFileHashCodes","modelFileHashCodes"),
    MODELDETAIL_MODELFILENAMES("modelFileNames","modelFileNames"),
    MODELDETAIL_HASHCODE("modelHashCode","modelHashCode"),

    /** ============================================================ */
    MODELREVIEWISSUE("reviewIssue","reviewIssue"),
    MODELREVIEWRESCODE("reviewResCode","reviewResCode"),
    MODELOWNERCUSTID("ownerCustID","ownerCustId")
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
