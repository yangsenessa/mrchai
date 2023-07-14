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
@CrossOrigin
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
    @PostMapping("/modelUpload.do")
    @ResponseBody
    public CustomerCommonResponse modelUpload(@RequestParam("file") MultipartFile[] files,
                                              @RequestParam(name = "userId") String userId,
                                              @RequestParam(name = "modelDetail") String modelDetail, HttpServletRequest request){
        BussResponse bussResponse = new BussResponse();
        CustomCommonReq req = new CustomCommonReq();
        req.setCustId(userId);
        BussRequest bussRequest = BussContextUtil.buildBussRequestByCustCommonReq(req,"MODELUPLOAD");

        ModelContext modelContext = new ModelContext();
        //       String modelDetail="{\"modelId\":\"b20db117-e130-413a-ae92-059e49839cb9\",\"version\":\"111\",\"guideLink\":\"guideLink\",\"paramsGuideLink\":\"paramsGuideLink\",\"sampleCodeLink\":\"sampleCodeLink\"}";
        //版本信息
        ModelDetailInfo modelDetailInfo= JSONObject.parseObject(modelDetail,new TypeReference<ModelDetailInfo>(){});
        modelContext.setModelDetailInfo(modelDetailInfo);

        bussRequest.getBussContext().setModelContext(modelContext);
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


}
