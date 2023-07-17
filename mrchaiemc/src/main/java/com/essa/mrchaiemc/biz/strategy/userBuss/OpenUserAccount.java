/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.userBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senyang
 * @version : OpenUserAccount.java, v 0.1 2023年07月17日 1:31 PM senyang Exp $
 */
@Component("OPENACCTCOUNT")
public class OpenUserAccount implements BussComponent {
    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        boolean res = false;
        if (response != null && request.getBussExtInfo() != null && StringUtil.isNotEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.WALLETTOKEN.getCode()))){
            res = true;
        } else {
            response.setResCode(ResultCode.INVAILDPARAMS.name());
        }
        return res;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try{
            userService.dealUserAcctOpen(request,response);
        } catch (Exception e) {
            LoggerUtil.errlog("DB opr ERR!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
    }

    @Override
    public String getActionCode() {
        return "OPENACCTCOUNT";
    }
}