package com.essa.mrchaiemc.biz.models.domains;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用业务返回
 */
public class BussResponse {

    private String resCode;

    private Map<String ,String> resExtInfo = new HashMap<>();

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public Map<String, String> getResExtInfo() {
        return resExtInfo;
    }

    public void setResExtInfo(Map<String, String> resExtInfo) {
        this.resExtInfo = resExtInfo;
    }
}
