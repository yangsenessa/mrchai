package com.essa.mrchaiemc.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.rsp.CustomerCommonResponse;
import com.essa.mrchaiemc.biz.pipeline.BussPipeline;
import com.essa.mrchaiemc.common.util.BussContextUtil;
import com.essa.mrchaiemc.common.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class ModelMannerBussConstorller {
    @Autowired
    BussPipeline bussPipeline;

    /**
     * 新增模型
     * @param req
     * @return
     */
    @RequestMapping(value = "/addNewModel.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse addNewModel(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"ADDNEWMODEL");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }


    @RequestMapping(value = "/modModelDetailInfo.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse modModelDetailInfo(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"MODMODELDETAIL");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);

    }

    /**
     * 首页模型展示数据
     * @param req
     * @return
     */
    @CrossOrigin( origins="*", allowCredentials = "false")
    @RequestMapping(value = "/queryModelInfoForMainView.do", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse queryModelInfoForMainView(@RequestBody CustomCommonReq req) {
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req, "QUERYMODELMAINVIEW");
        bussPipeline.execWithPipeLine(bussRequest, bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    /**
     * 首页模型分类展示数据
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/queryModelInfoByCategory1.do", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse querModelInfoByCategory(@RequestBody CustomCommonReq req) {
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req, "QUERYMODELBYCATEGORY1");
        bussPipeline.execWithPipeLine(bussRequest, bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    /**
     * 首页模型展示数据
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/queryModelDetailInfo.do", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse queryModelDetailInfo(@RequestBody CustomCommonReq req) {
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"QUERYMODELDEAILINFO");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    /**
     * 上传模型
     * @param
     * @return
     */
    @RequestMapping(value = "/modelUpload.do", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse modelUpload(@RequestBody CustomCommonReq req){

        BussResponse bussResponse = new BussResponse();

        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"MODELUPLOAD");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    /**
     * 上传图片
     * @param
     * @return
     */
    @PostMapping("/fileUpload.do")
    @ResponseBody
    public CustomerCommonResponse imgsUpload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request){
        BussResponse bussResponse = new BussResponse();
        CustomCommonReq req = new CustomCommonReq();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"FILEUPLOAD");
        bussRequest.getBussContext().setFile(files);

        bussPipeline.execWithPipeLine(bussRequest,bussResponse);

        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    @RequestMapping(value = "/modelDownload.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public  CustomerCommonResponse modelDownload(@RequestBody CustomCommonReq req, HttpServletRequest request, HttpServletResponse res){

        BussResponse bussResponse = new BussResponse();
        bussResponse.setHttpServletResponse(res);
        BussRequest bussRequest = BussContextUtil.buildBussRequestForAssetOpr(request,req,"MODELDOWNLOAD");
        bussRequest.setBussExtInfo(req.getBussData());
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

    @RequestMapping(value = "/mannerModelPublish.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse mannerModelPublish(@RequestBody CustomCommonReq req) {
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"MODELREVIEW");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }
    @RequestMapping(value = "/queryModelInfoByModelFileHashCode.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse queryModelInfoByModelFileHashCode(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"QUERYBYMODELHASH");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);

    }

    @RequestMapping(value = "/queryModelInfoByCustId.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse queryModelInfoByCustId(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"QUERYMODELBYCUSTIDH");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);

    }

    @RequestMapping(value = "/authoriseUserToSuper.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    @ResponseBody
    public CustomerCommonResponse authoriseUserToSuper(@RequestBody CustomCommonReq req){
        BussResponse bussResponse = new BussResponse();
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"ADDAUTHORTOUSER");
        bussPipeline.execWithPipeLine(bussRequest,bussResponse);
        return ResUtil.customerCommonResponseBuild(bussResponse);
    }

}
