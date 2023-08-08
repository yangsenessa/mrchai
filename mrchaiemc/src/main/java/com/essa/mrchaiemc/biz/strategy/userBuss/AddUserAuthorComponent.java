/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.userBuss;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.dal.repository.CustInfoDO;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MOD user levels
 * @author senyang
 * @version : AddUserAuthorComponent.java, v 0.1 2023年08月07日 11:42 PM senyang Exp $
 */
@Component("ADDAUTHORTOUSER")
public class AddUserAuthorComponent implements BussComponent {
    private Logger logger = Logger.getLogger(AddUserAuthorComponent.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if(request.getUserContext() == null){
            return false;
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try {
            this.userService.addAuthorSuperToUser(request, response);
        } catch (Exception e) {
            LoggerUtil.errlog(e, "Db err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
    }

    @Override
    public String getActionCode() {
        return "ADDAUTHORTOUSER";
    }
}