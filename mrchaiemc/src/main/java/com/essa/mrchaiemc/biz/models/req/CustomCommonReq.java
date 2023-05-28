package com.essa.mrchaiemc.biz.models.req;

public class CustomCommonReq extends BaseReq {

    private String custId;

    private String email;

    private String identiType;

    /**
     * 用户操作区域
     * @See com.essa.mrchaiemc.biz.models.enumcollection.PanelEnum
     */
    private String panelId;

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
}
