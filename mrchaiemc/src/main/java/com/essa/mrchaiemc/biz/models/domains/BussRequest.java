package com.essa.mrchaiemc.biz.models.domains;

import com.essa.mrchaiemc.biz.models.BussContext;
import com.essa.mrchaiemc.biz.models.EmcContext;
import com.essa.mrchaiemc.biz.models.UserContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用业务对象请求
 */
public class BussRequest {


    private List<String> strategyConmpCodeList = new ArrayList<>();

    private BussContext bussContext;

    private EmcContext emcContext;

    private UserContext userContext;

    private Map<String, Object> bussExtInfo = new HashMap<>();

    public BussContext getBussContext() {
        return bussContext;
    }

    public void setBussContext(BussContext bussContext) {
        this.bussContext = bussContext;
    }

    public EmcContext getEmcContext() {
        return emcContext;
    }

    public void setEmcContext(EmcContext emcContext) {
        this.emcContext = emcContext;
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    public Map<String, Object> getBussExtInfo() {
        return bussExtInfo;
    }

    public void setBussExtInfo(Map<String, Object> bussExtInfo) {
        this.bussExtInfo = bussExtInfo;
    }

    public List<String> getStrategyConmpCodeList() {
        return strategyConmpCodeList;
    }

    public void setStrategyConmpCodeList(List<String> strategyConmpCodeList) {
        this.strategyConmpCodeList = strategyConmpCodeList;
    }
}
