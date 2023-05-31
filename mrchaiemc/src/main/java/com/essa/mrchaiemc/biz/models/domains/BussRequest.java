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


    private List<String> strategyCommonCodeList = new ArrayList<>();

    private BussContext bussContext;

    private EmcContext emcContext;

    private UserContext userContext;

    private Map<String, String> bussExtInfo = new HashMap<>();

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

    public Map<String, String> getBussExtInfo() {
        return bussExtInfo;
    }

    public void setBussExtInfo(Map<String, String> bussExtInfo) {
        this.bussExtInfo = bussExtInfo;
    }

    /**
     * Getter method for property <tt>strategyCommonCodeList</tt>.
     *
     * @return property value of strategyCommonCodeList
     */
    public List<String> getStrategyCommonCodeList() {
        return strategyCommonCodeList;
    }

    /**
     * Setter method for property <tt>strategyCommonCodeList</tt>.
     *
     * @param strategyCommonCodeList value to be assigned to property strategyCommonCodeList
     */
    public void setStrategyCommonCodeList(List<String> strategyCommonCodeList) {
        this.strategyCommonCodeList = strategyCommonCodeList;
    }
}
