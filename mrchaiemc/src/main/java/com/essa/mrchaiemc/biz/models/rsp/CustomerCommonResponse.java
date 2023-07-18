package com.essa.mrchaiemc.biz.models.rsp;


import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;

import java.util.List;
import java.util.Map;

public class CustomerCommonResponse extends BaseRsp {


    /**
     * 用户登录态
     */
    private String loginStatus;

    /**
     * totalNum
     */
    private long totalNum;

    /**
     * modelInfoList
     */
    private List<ModelInfo> modelInfoList;

    /**
     * Getter method for property <tt>totalNum</tt>.
     *
     * @return property value of totalNum
     */
    public long getTotalNum() {
        return totalNum;
    }

    /**
     * Setter method for property <tt>totalNum</tt>.
     *
     * @param totalNum value to be assigned to property totalNum
     */
    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * Getter method for property <tt>modelInfoList</tt>.
     *
     * @return property value of modelInfoList
     */
    public List<ModelInfo> getModelInfoList() {
        return modelInfoList;
    }

    /**
     * Setter method for property <tt>modelInfoList</tt>.
     *
     * @param modelInfoList value to be assigned to property modelInfoList
     */
    public void setModelInfoList(List<ModelInfo> modelInfoList) {
        this.modelInfoList = modelInfoList;
    }

    /**
     * 扩展业务返回
     * @return
     */
    private Map<String,String> bussData ;

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Map<String, String> getBussData() {
        return bussData;
    }

    public void setBussData(Map<String, String> bussData) {
        this.bussData = bussData;
    }
}
