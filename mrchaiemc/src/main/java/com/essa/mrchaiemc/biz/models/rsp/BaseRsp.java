package com.essa.mrchaiemc.biz.models.rsp;

import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;

public class BaseRsp {

    private ResultCode resultCode;

    /**
     * 服务端时间戳
     */
    private long gmtDate;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public long getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(long gmtDate) {
        this.gmtDate = gmtDate;
    }
}
