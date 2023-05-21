package rpc.controller.view.models;

/**
 * 基础业务上下文，通过中心化节点分发到ems分布式算力
 * 运用redis+ob的方式进行存储和更新
 */
public class BussContext {
   private String actionCode;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
