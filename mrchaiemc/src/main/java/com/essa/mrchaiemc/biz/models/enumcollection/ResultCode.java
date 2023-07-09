package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ResultCode {

    SUCCESS(0, "SUCCESS"),
    SYSFAIL(-1,"SYSFAIL"),
    NEEDLOGIN(1, "NEEDLOGIN"),
    AUTHERR(2,"AUTHERR"),
    NEEDREGISTER(3,"NEEDREGISTER"),
    DUPLOGINID(4,"DUPLOGINID"),
    INVAILDPARAMS(5,"INVAILDPARAMS"),
    INVALIDUSER(6, "INVALIDUSER"),
    DBEXCEPTION(7,"DBEXCEPTION"),
    DATANOTCOMPLETED(8,"DATANOTCOMPLETED");



    private int code;

    private String msg;

    ResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


