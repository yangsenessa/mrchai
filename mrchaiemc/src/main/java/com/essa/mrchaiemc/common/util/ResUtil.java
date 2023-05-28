package com.essa.mrchaiemc.common.util;


import com.essa.mrchaiemc.biz.models.BussContext;
import com.essa.mrchaiemc.biz.models.UserContext;
import com.essa.mrchaiemc.biz.models.enumcollection.LoginStatusEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.rsp.CustomerLoginResponse;

public class ResUtil {
    /**
     * The Success response when this case not related EMC caculation
     * @param loginStatusEnum
     * @return
     */
    public static CustomerLoginResponse instanceOfSucWithOutEmc(LoginStatusEnum loginStatusEnum){
        CustomerLoginResponse rsp = new CustomerLoginResponse();
        rsp.setResultCode(ResultCode.SUCCESS);
        rsp.setLoginStatus(loginStatusEnum.getCode());

        return rsp;
    }


    public static CustomerLoginResponse commonErrResponse(){
        CustomerLoginResponse rsp = new CustomerLoginResponse();
        rsp.setResultCode(ResultCode.SYSFAIL);
        return rsp;
    }
}
