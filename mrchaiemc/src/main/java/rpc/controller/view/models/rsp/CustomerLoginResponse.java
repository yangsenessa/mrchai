package rpc.controller.view.models.rsp;

import rpc.controller.view.models.BussContext;
import rpc.controller.view.models.EmcContext;
import rpc.controller.view.models.UserContext;
import rpc.controller.view.models.enumcollection.ResultCode;

public class CustomerLoginResponse {
    private ResultCode resultCode;

    private BussContext bussContext;

    private UserContext userContext;

    private EmcContext emcContext;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public BussContext getBussContext() {
        return bussContext;
    }

    public void setBussContext(BussContext bussContext) {
        this.bussContext = bussContext;
    }

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
}
