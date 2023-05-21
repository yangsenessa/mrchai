package common.util;

import rpc.controller.view.models.BussContext;
import rpc.controller.view.models.UserContext;
import rpc.controller.view.models.enumcollection.ResultCode;
import rpc.controller.view.models.rsp.CustomerLoginResponse;

public class ResUtil {
    /**
     * The Success response when this case not related EMC caculation
     * @param bussContext
     * @param userContext
     * @return
     */
    public static CustomerLoginResponse instanceOfSucWithOutEmc(BussContext bussContext, UserContext userContext){
        CustomerLoginResponse rsp = new CustomerLoginResponse();
        rsp.setResultCode(ResultCode.SUCCESS);
        rsp.setBussContext(bussContext);
        rsp.setUserContext(userContext);
        return rsp;
    }


    public static CustomerLoginResponse commonErrResponse(){
        CustomerLoginResponse rep = new CustomerLoginResponse();
        return
    }
}
