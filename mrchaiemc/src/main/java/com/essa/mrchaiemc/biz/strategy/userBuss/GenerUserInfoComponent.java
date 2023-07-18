/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.userBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.usermanner.UserContext;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.enumcollection.UserStatusEnum;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author senyang
 * @version : GenerUserInfoComponent.java, v 0.1 2023年06月05日 8:50 PM senyang Exp $
 */
@Component("GERNERUSERINFO")
public class GenerUserInfoComponent implements BussComponent {
    private static Logger logger = Logger.getLogger(GenerUserInfoComponent.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        boolean res = false;
        if (response != null && request.getBussExtInfo() != null) {
            //check and unpack userContext
            request.getUserContext().setLoginId(request.getBussExtInfo().get(BussInfoKeyEnum.APPLREGINFO_LOGINID.getCode()));
            request.getUserContext().setEmail(request.getBussExtInfo().get(BussInfoKeyEnum.APPLREGINFO_EMAIL.getCode()));
            request.getUserContext().setMobilePhoneNo(request.getBussExtInfo().get(BussInfoKeyEnum.APPLRREGINFO_MOBILEPHONENO.getCode()));
            request.getUserContext().setNickName(request.getBussExtInfo().get(BussInfoKeyEnum.APPLREGINFO_NICKNAME.getCode()));
            request.getUserContext().setUserStatus(UserStatusEnum.UN_AUTHTOKEN);
            res = true;
        }
        return res;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        String userId = null;
        try {
            userId = userService.doUserRegister(request, response);
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
        request.getUserContext().setUserId(userId);
        response.setResCode(ResultCode.SUCCESS.name());
        if (response.getResExtInfo() == null) {
            response.setResExtInfo(new HashMap<>());
        }
        Map<String, String> extInfo = response.getResExtInfo();
        extInfo.put(BussInfoKeyEnum.CUSTID.getCode(), userId);
    }

    @Override
    public String getActionCode() {
        return "GERNERUSERINFO";
    }
}