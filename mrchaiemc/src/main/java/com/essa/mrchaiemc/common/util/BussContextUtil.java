/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import com.essa.mrchaiemc.biz.models.BussContext;
import com.essa.mrchaiemc.biz.models.UserContext;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.req.CustomCommonReq;
import com.essa.mrchaiemc.common.integration.sys.SysConfigInit;

import java.util.ArrayList;

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
        bussRequest.getUserContext().setHasLogin(false);

        //业务组件编排
        String actionArray = SysConfigInit.bussFlowMap.get(actionCode);
        bussRequest.setStrategyCommonCodeList(new ArrayList<>());
        for(String actionItem : actionArray.split(",")){
            bussRequest.getStrategyCommonCodeList().add(actionItem);
        }
        return bussRequest;

    }
}