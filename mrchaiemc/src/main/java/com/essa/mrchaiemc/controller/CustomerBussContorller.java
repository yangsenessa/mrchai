package com.essa.mrchaiemc.controller;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.LoginStatusEnum;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.rsp.CustomerCommonResponse;
import com.essa.mrchaiemc.biz.services.BussPipeline;
import com.essa.mrchaiemc.common.util.BussContextUtil;
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

    @Autowired
    BussPipeline bussPipeline;

    @ResponseBody
    @RequestMapping(value = "/mainframeinit.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    public CustomerCommonResponse mainFrameInit(@RequestBody CustomCommonReq req){
        LoggerUtil.info(logger, req);

        SessionUtil.setSessionVal(request, "userId", req.getCustId());

        return ResUtil.instanceOfSucWithOutEmc(LoginStatusEnum.NOTLOGIN);
    }

    @ResponseBody
    @RequestMapping(value = "userLogin.do", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CustomerCommonResponse userLogin(@RequestBody CustomCommonReq req) {
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"LOGIN");
        BussResponse bussResponse = new BussResponse();
        bussRequest.setBussExtInfo(req.getBussData());
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }
    @ResponseBody
    @RequestMapping(value = "applyRegister.do", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CustomerCommonResponse applyRegister(@RequestBody CustomCommonReq req){
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"APPLYREGISTER");
        BussResponse bussResponse = new BussResponse();
        bussRequest.setBussExtInfo(req.getBussData());
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }
    @ResponseBody
    @RequestMapping(value = "setAutoration.do", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CustomerCommonResponse setAutoration(@RequestBody CustomCommonReq req){
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"SETAUTHOR");
        BussResponse bussResponse = new BussResponse();
        bussRequest.setBussExtInfo(req.getBussData());
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }




}
