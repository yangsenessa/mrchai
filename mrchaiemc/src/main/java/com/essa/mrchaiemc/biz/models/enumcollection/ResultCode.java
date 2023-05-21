package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ResultCode {

    SUCCESS(0, "SUCCESS"),
    SYSFAIL(-1,"SYSFAIL"),
    NEEDLOGIN(1, "NEEDLOGIN");


    private int code;

    private String msg;

    ResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}


