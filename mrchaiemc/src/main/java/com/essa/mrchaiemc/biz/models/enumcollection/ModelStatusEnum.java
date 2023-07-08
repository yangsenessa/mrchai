package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ModelStatusEnum {
    NORMAL("NORMAL", "NORMAL"),
    HIDDEN("HIDDEN","HIDDEN"),
    DROP("DROP","DROP")
    ;


    private String code;

    private String msg;

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

    ModelStatusEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
