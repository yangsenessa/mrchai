/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.userBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.CustIdentiTypeEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senyang
 * @version : SetUserAuthTokenComponent.java, v 0.1 2023年06月07日 11:22 PM senyang Exp $
 */
@Component("SETAUTHTOKEN")
public class SetUserAuthTokenComponent implements BussComponent {

    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (StringUtil.isNotEmpty(response.getResCode()) && !StringUtil.equals(response.getResCode(), ResultCode.SUCCESS.name())) {
            return false;
        }
        String loginType = request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode());
        if(StringUtil.equals(loginType, CustIdentiTypeEnum.PASSWD.getMsg())){
            if (StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode()))){
                return false;
            }
        }
        if(StringUtil.equals(loginType, CustIdentiTypeEnum.PRINCIPLAL.getMsg())){
            if (StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode()))){
                return false;
            }
        }

        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        userService.setOrChangeAuthToken(request,response);
    }

    @Override
    public String getActionCode() {
        return "SETAUTHTOKEN";
    }
}