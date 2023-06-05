package com.essa.mrchaiemc.biz.models.rsp;

import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;

public class BaseRsp {

    private String resultCode;

    /**
     * 服务端时间戳
     */
    private long gmtDate;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public long getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(long gmtDate) {
        this.gmtDate = gmtDate;
    }
}
