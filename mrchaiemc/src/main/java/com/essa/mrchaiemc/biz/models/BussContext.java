package com.essa.mrchaiemc.biz.models;

/**
 * 基础业务上下文，通过中心化节点分发到ems分布式算力
 * 运用redis+ob的方式进行存储和更新
 */
public class BussContext {
    /**
     * 标识业务流
     */
    private String actionCode;

    /**
     * 当前业务节点
     */
    private String currNode;


    /**
     * 业务推进决策code
     */
    private String processCode;

    /**
     * 用户上下文
     */
    private UserContext userContext;

    /**
     * emc算力调度上下文
     */
    private EmcContext emcContext;


    public UserContext getUserContext() {
        return userContext;
    }

    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    public EmcContext getEmcContext() {
        return emcContext;
    }

    public void setEmcContext(EmcContext emcContext) {
        this.emcContext = emcContext;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }


    public String getCurrNode() {
        return currNode;
    }

    public void setCurrNode(String currNode) {
        this.currNode = currNode;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }
}
