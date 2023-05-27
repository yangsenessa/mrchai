package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ProcessEnum {

    INIT("INIT", "INIT"),
    PROCESSING("PROCESSING","PROCESSING"),
    SUCCESS_FINISH("SUCCESS_FINISH","SUCCESS_FINISH"),
    FAIL_RETRY("FAIL_RETRY","FAIL_RETRY"),
    FAIL_NOT_RETRY("FAIL_NOT_RETRY","FAIL_NOT_RETRY");

    private String processNode;
    private String des;

    ProcessEnum(String processNode, String des){
        this.processNode = processNode;
        this.des = des;
    }
}
