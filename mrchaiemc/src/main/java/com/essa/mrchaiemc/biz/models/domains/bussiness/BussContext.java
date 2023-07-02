package com.essa.mrchaiemc.biz.models.domains.bussiness;

import com.essa.mrchaiemc.common.util.BussContextUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 基础业务上下文，通过中心化节点分发到ems分布式算力
 * 运用redis+ob的方式进行存储和更新
 */
public class BussContext {

    /**
     * 应用trace
     */
    private String traceId;

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
     * emc算力调度上下文
     */
    private EmcContext emcContext;

    /**
     * Model Context
     */
    private ModelContext modelContext;


    /**
     * 资源上传
     */
    private MultipartFile[] file;


    /**
     * 构造方法，构造同时增加
     */
    public BussContext(){
        this.traceId = BussContextUtil.generBizTraceId();

    }


    public void initContext(){
        emcContext = new EmcContext();
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

    /**
     * Getter method for property <tt>file</tt>.
     *
     * @return property value of file
     */
    public MultipartFile[] getFile() {
        return file;
    }

    /**
     * Setter method for property <tt>file</tt>.
     *
     * @param file value to be assigned to property file
     */
    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
