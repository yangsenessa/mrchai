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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author senyang
 * @version : AssetMannerBussContorller.java, v 0.1 2023年06月08日 11:32 PM senyang Exp $
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/")
public class AssetMannerBussContorller {

    @Autowired
    BussPipeline bussPipeline;


    @GetMapping("/upload.do")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/assetcommonupload.do")
    @ResponseBody
    public CustomerCommonResponse assetCommonUpload(@RequestParam("file") MultipartFile[] files,
                                                    @RequestParam(name = "userId") String userId,@RequestParam(name = "modelId") String modelId,HttpServletRequest request){
        CustomCommonReq req = new CustomCommonReq();
        req.setCustId(userId);


        BussRequest bussRequest = BussContextUtil.buildBussRequestForAssetOpr(request,req,"ASSETUPLOAD");
        bussRequest.getBussContext().setFile(files);
        BussResponse bussResponse = new BussResponse();

        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }



}