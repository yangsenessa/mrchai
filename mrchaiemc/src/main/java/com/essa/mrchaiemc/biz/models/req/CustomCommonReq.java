package com.essa.mrchaiemc.biz.models.req;

public class CustomCommonReq extends BaseReq {

    private String custId;

    private String loginId;


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


    public String getPanelId() {
        return panelId;
    }

    public void setPanelId(String panelId) {
        this.panelId = panelId;
    }

    /**
     * Getter method for property <tt>loginId</tt>.
     *
     * @return property value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Setter method for property <tt>loginId</tt>.
     *
     * @param loginId value to be assigned to property loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
