/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.FuzzyRequest;
import com.essa.mrchaiemc.biz.models.domains.bussiness.BussContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.OperatorLogs;
import com.essa.mrchaiemc.biz.models.domains.usermanner.UserContext;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.FuzzyRequestStrategyEnum;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.biz.models.req.FuzzyReq;
import com.essa.mrchaiemc.common.integration.sys.SysConfigInit;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author senyang
 * @version : BussContextUtil.java, v 0.1 2023年05月31日 7:35 PM senyang Exp $
 */
public class BussContextUtil {

    /**
     * 用户登录，构建业务buss上下文
     * @param request
     * @return
     */
    public static BussRequest buildBussRequestByCustCommonReq(CustomCommonReq request,String actionCode){
        BussRequest bussRequest = new BussRequest();
        bussRequest.setBussContext(new BussContext());
        bussRequest.setUserContext(new UserContext());

        bussRequest.getUserContext().setUserId(request.getCustId());
        bussRequest.getUserContext().setLoginId(request.getLoginId());
        bussRequest.getUserContext().setHasLogin(false);


        String traceId = generBizTraceId();
        bussRequest.setBussExtInfo(request.getBussData());
        bussRequest.getBussContext().setActionCode(actionCode);
        bussRequest.getBussContext().setTraceId(traceId);
        bussRequest.getBussContext().setOperatorLogs(new OperatorLogs());

        OperatorLogs operatorLogs = bussRequest.getBussContext().getOperatorLogs();
        operatorLogs.setUserId(request.getCustId());
        operatorLogs.setTraceId(traceId);
        operatorLogs.setGmtCreate(DateUtil.getGmtDate());
        operatorLogs.setActionType(ActionEnumMappingUtil.getActionTypeEnumFromActionCode(actionCode));

        //业务组件编排
        String actionArray = SysConfigInit.bussFlowMap.get(actionCode);
        bussRequest.setStrategyCommonCodeList(new ArrayList<>());
        for(String actionItem : actionArray.split(",")){
            bussRequest.getStrategyCommonCodeList().add(actionItem);
        }
        return bussRequest;
    }


    public static BussRequest buildBussRequestByFuzzyReq(FuzzyReq request, String actionCode){
        BussRequest bussRequest = new BussRequest();
        bussRequest.setBussContext(new BussContext());
        bussRequest.setUserContext(new UserContext());

        bussRequest.getUserContext().setUserId(request.getCustId());
        bussRequest.getUserContext().setLoginId(request.getLoginId());
        bussRequest.getUserContext().setHasLogin(true);


        String traceId = generBizTraceId();
        bussRequest.setBussExtInfo(request.getBussData());
        bussRequest.getBussContext().setActionCode(actionCode);
        bussRequest.getBussContext().setTraceId(traceId);
        bussRequest.getBussContext().setOperatorLogs(new OperatorLogs());

        OperatorLogs operatorLogs = bussRequest.getBussContext().getOperatorLogs();
        operatorLogs.setUserId(request.getCustId());
        operatorLogs.setTraceId(traceId);
        operatorLogs.setGmtCreate(DateUtil.getGmtDate());
        operatorLogs.setActionType(ActionEnumMappingUtil.getActionTypeEnumFromActionCode(actionCode));


        FuzzyRequest fuzzyRequest = new FuzzyRequest();
        bussRequest.setFuzzyRequest(fuzzyRequest);
        fuzzyRequest.setDesText(request.getTitlePattern());
        fuzzyRequest.setCateText(request.getCategroyPattern());
        fuzzyRequest.setTagText(request.getTagPattern());
        fuzzyRequest.setModelStat(request.getModelStat());
        fuzzyRequest.setFuzzyRequestStrategyAction(decideQuertStrategy(fuzzyRequest));


        //buss components constract
        String actionArray = SysConfigInit.bussFlowMap.get(actionCode);
        bussRequest.setStrategyCommonCodeList(new ArrayList<>());
        for(String actionItem : actionArray.split(",")){
            bussRequest.getStrategyCommonCodeList().add(actionItem);
        }
        return bussRequest;
    }

    /**
     * The decider of request strategy
     * @param fuzzyRequest
     * @return
     */
    private static FuzzyRequestStrategyEnum decideQuertStrategy(FuzzyRequest fuzzyRequest) {
        //Whole mixture
        if(StringUtil.isNotEmpty(fuzzyRequest.getDesText()) &&
                (StringUtil.isNotEmpty(fuzzyRequest.getCateText()) ||
               StringUtil.isNotEmpty(fuzzyRequest.getTagText()))){
            return FuzzyRequestStrategyEnum.SEARCH_BY_FUZZYMIXTRUE;
        }
        if(StringUtil.isNotEmpty(fuzzyRequest.getDesText())){
            return FuzzyRequestStrategyEnum.SEARCH_BY_TITILE;
        }
        if(StringUtil.isNotEmpty(fuzzyRequest.getCateText())){
            return FuzzyRequestStrategyEnum.SEARCH_BY_CATEGORY;
        }
        if(StringUtil.isNotEmpty(fuzzyRequest.getTagText())) {
            return FuzzyRequestStrategyEnum.SEARCH_BY_TAG;
        }
        if(StringUtil.isNotEmpty(fuzzyRequest.getModelStat())){
            return FuzzyRequestStrategyEnum.SEARCH_BY_MODELSTAT;
        }
        return null;

    }

    /**
     * 构建资源操作类通用业务请求
     * @param request
     * @param customCommonReq
     * @param actionCode
     * @return
     */
    public static BussRequest buildBussRequestForAssetOpr(HttpServletRequest request,CustomCommonReq customCommonReq,String actionCode){
        BussRequest bussRequest = buildBussRequestByCustCommonReq(customCommonReq,actionCode);
        bussRequest.setHttpServletRequest(request);
        return bussRequest;

    }

    /**
     * 判断用户是否为登录态
     * @param request
     * @return
     */
    private static boolean isContainUserId(CustomCommonReq request) {
        if(request != null && StringUtil.isNotEmpty(request.getCustId())){
            return true;
        }
        return false;
    }

    /**
     * 判断用户是否为登录/注册申请
      * @param request
     * @return
     */
    private static boolean isUserApplyLogin(CustomCommonReq request){

        if(request != null) {
            if(StringUtil.isNotEmpty(request.getBussData().get(BussInfoKeyEnum.LOGINTYPE.getCode()))){
                return true;
            }
            if(request.getBussData() != null &&  StringUtil.isNotEmpty(request.getBussData().get(BussInfoKeyEnum.APPLREGINFO.getCode())) ){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取trace号
     * @return
     */
    public static String generBizTraceId(){
        long threadL = Thread.currentThread().getId();
        threadL+= DateUtil.getGmtDateTime();
        return Long.toHexString(threadL);
    }

}