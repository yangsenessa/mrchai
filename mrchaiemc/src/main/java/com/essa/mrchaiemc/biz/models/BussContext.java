package com.essa.mrchaiemc.biz.models;

import com.essa.mrchaiemc.biz.models.enumcollection.ActionTypeEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ProcessEnum;

/**
 * 基础业务上下文，通过中心化节点分发到ems分布式算力
 * 运用redis+ob的方式进行存储和更新
 */
public class BussContext {
   private String actionCode;

   private ActionTypeEnum actionType;

   private ProcessEnum process;

   private UserContext userContext;

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

    public ActionTypeEnum getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeEnum actionType) {
        this.actionType = actionType;
    }

    public ProcessEnum getProcess() {
        return process;
    }

    public void setProcess(ProcessEnum process) {
        this.process = process;
    }
}
