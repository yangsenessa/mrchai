package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ModelCustVIewStatEnum {
    INIT("INIT","INIT"),
    SUCCESS("SUCCESS","SUCCESS"),
    INVALD("INVALD","INVALD"),
    DROPED("DROPED","DROPED")

    ;


    private String code;

    private String desc;

    ModelCustVIewStatEnum(String code, String desc){
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
