package com.essa.mrchaiemc.biz.models.req;

import java.util.Map;

public class CustomCommonReq extends BaseReq {

    private String custId;


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

}
