package com.essa.mrchaiemc.common.util;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.LoginStatusEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.rsp.CustomerCommonResponse;

import java.util.Date;

public class ResUtil {
    /**
     * The Success response when this case not related EMC caculation
     *
     * @param loginStatusEnum
     * @return
     */
    public static CustomerCommonResponse instanceOfSucWithOutEmc(LoginStatusEnum loginStatusEnum) {
        CustomerCommonResponse rsp = new CustomerCommonResponse();
        rsp.setResultCode(ResultCode.SUCCESS.getMsg());
        rsp.setLoginStatus(loginStatusEnum.getCode());

        return rsp;
    }


    /**
     * 通用错误返回
     *
     * @return
     */
    public static CustomerCommonResponse commonErrResponse() {
        CustomerCommonResponse rsp = new CustomerCommonResponse();
        rsp.setResultCode(ResultCode.SYSFAIL.getMsg());
        return rsp;
    }

    public static CustomerCommonResponse customerCommonResponseBuild(BussResponse response) {

        CustomerCommonResponse customerCommonResponse = new CustomerCommonResponse();
        if (response == null) {
            return commonErrResponse();
        }
        customerCommonResponse.setResultCode(response.getResCode());
        customerCommonResponse.setGmtDate(DateUtil.getGmtDateTime());
        customerCommonResponse.setLoginStatus(String.valueOf(LogInStatusUtil.isCustLogInSuccess(response)));
        return customerCommonResponse;
    }
}
