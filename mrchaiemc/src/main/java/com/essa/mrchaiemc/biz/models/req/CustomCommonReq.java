package com.essa.mrchaiemc.biz.models.req;

import java.util.Map;

public class CustomCommonReq extends BaseReq {

    private String custId;

    private String email;

    private String identiType;

    private String token;

    /**
     * 用户操作区域
     * @See com.essa.mrchaiemc.biz.models.enumcollection.PanelEnum
     */
    private String panelId;

    private Map<String, String > bussData;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentiType() {
        return identiType;
    }

    public void setIdentiType(String identiType) {
        this.identiType = identiType;
    }

    public String getPanelId() {
        return panelId;
    }

    public void setPanelId(String panelId) {
        this.panelId = panelId;
    }

    /**
     * Getter method for property <tt>token</tt>.
     *
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     *
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>bussData</tt>.
     *
     * @return property value of bussData
     */
    public Map<String, String> getBussData() {
        return bussData;
    }

    /**
     * Setter method for property <tt>bussData</tt>.
     *
     * @param bussData value to be assigned to property bussData
     */
    public void setBussData(Map<String, String> bussData) {
        this.bussData = bussData;
    }
}
