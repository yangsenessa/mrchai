/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.userBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author senyang
 * @version : CheckUserInfoComponent.java, v 0.1 2023年06月07日 11:09 PM senyang Exp $
 */
@Component("CHECKUSERINFO")
public class CheckUserInfoComponent implements BussComponent {
    private Logger logger = Logger.getLogger(CheckUserInfoComponent.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (StringUtil.isEmpty(request.getUserContext().getUserId())) {
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        return true;

    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        userService.fetchUserInfo(request,response);
    }

    @Override
    public String getActionCode() {
        return "CHECKUSERINFO";
    }
}