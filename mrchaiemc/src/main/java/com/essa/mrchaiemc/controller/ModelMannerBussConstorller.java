package com.essa.mrchaiemc.controller;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.rsp.CustomerCommonResponse;
import com.essa.mrchaiemc.biz.pipeline.BussPipeline;
import com.essa.mrchaiemc.common.util.BussContextUtil;
import com.essa.mrchaiemc.common.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class ModelMannerBussConstorller {
    @Autowired
    BussPipeline bussPipeline;

    @RequestMapping(value = "/addNewModel.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse addNewModel(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"ADDNEWMODEL");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }
}
