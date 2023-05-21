package com.essa.mrchaiemc.common.util;


import com.essa.mrchaiemc.biz.models.BussContext;
import com.essa.mrchaiemc.biz.models.UserContext;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.rsp.CustomerLoginResponse;

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
        CustomerLoginResponse rsp = new CustomerLoginResponse();
        rsp.setResultCode(ResultCode.SYSFAIL);
        return rsp;
    }
}
