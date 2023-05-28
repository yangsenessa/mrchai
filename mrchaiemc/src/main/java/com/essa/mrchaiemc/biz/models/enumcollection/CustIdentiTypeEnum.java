package com.essa.mrchaiemc.biz.models.enumcollection;

public enum CustIdentiTypeEnum {

    PASSWD(1,"PASSWD"),
    TWITTER(2,"TWITTER"),
    BUSSINFO(3,"BUSSINFO");//嵌入式能力供给


    private int code;

    private String msg;


    CustIdentiTypeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
