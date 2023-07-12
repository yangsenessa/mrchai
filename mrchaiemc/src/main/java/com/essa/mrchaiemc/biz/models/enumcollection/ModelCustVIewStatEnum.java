package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ModelCustVIewStatEnum {
    /** 初始化-不展示*/
    INIT("INIT","INIT"),
    /** 正常展示*/
    SUCCESS("SUCCESS","SUCCESS"),
    /** 非法模型（因内容原因封禁）*/
    INVALD("INVALD","INVALD"),
    /** 模型删除 */
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
