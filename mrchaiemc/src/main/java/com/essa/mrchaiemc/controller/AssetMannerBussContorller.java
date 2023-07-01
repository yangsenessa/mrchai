/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.controller;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.rsp.CustomerCommonResponse;
import com.essa.mrchaiemc.biz.pipeline.BussPipeline;
import com.essa.mrchaiemc.common.util.BussContextUtil;
import com.essa.mrchaiemc.common.util.ResUtil;
import com.essa.mrchaiemc.common.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author senyang
 * @version : AssetMannerBussContorller.java, v 0.1 2023年06月08日 11:32 PM senyang Exp $
 */
@Controller
@RequestMapping(value = "/")
public class AssetMannerBussContorller {

    @Autowired
    BussPipeline bussPipeline;

    @PostMapping("/assetcommonupload.do")
    public CustomerCommonResponse assetCommonUpload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request, HttpSession session){
        CustomCommonReq req = new CustomCommonReq();
        req.setCustId(SessionUtil.getUserIdFromSession(session));
        req.setActionCode("ASSET_UPLOAD");

        BussRequest bussRequest = BussContextUtil.buildBussRequestForAssetOpr(request,req,"LOGIN");
        bussRequest.getBussContext().setFile(files);
        BussResponse bussResponse = new BussResponse();

        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

}