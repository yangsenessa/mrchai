package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ModelStatusEnum {
    PUBLIISH("PUBLIISH", "PUBLIISH"),
    INIT("INIT","INIT"),
    SUBMIT("SUBMIT","SUBMIT")
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
