package com.essa.mrchaiemc.controller;

import com.essa.mrchaiemc.biz.models.enumcollection.LoginStatusEnum;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.rsp.CustomerLoginResponse;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import com.essa.mrchaiemc.common.util.ResUtil;

import com.essa.mrchaiemc.common.util.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/")
public class CustomerBussContorller {
    private static Logger logger = Logger.getLogger(CustomerBussContorller.class);

    @Autowired
    HttpServletRequest request;

    @ResponseBody
    @RequestMapping(value = "/mainframeinit.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    public CustomerLoginResponse mainFrameInit(@RequestBody CustomCommonReq req){
        LoggerUtil.info(logger, req);

        SessionUtil.setSessionVal(request, "userId", req.getCustId());

        return ResUtil.instanceOfSucWithOutEmc(LoginStatusEnum.NOTLOGIN);
    }

}
