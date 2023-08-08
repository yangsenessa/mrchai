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
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senyang
 * @version : SubmitModelComponent.java, v 0.1 2023年08月09日 12:27 AM senyang Exp $
 */
@Component("SUBMITMODEL")
public class SubmitModelComponent implements BussComponent {
    @Autowired
    private ModelBizService modelBizService;
    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if(request.getUserContext() == null ||
                !StringUtil.equals(ResultCode.SUCCESS.getMsg(),response.getResCode())){
            return false;
        }
        if(StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode()))) {
            response.setResCode(ResultCode.INVAILDPARAMS.getMsg());
            return false;
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        this.modelBizService.submitModel(request,response);

    }

    @Override
    public String getActionCode() {
        return "SUBMITMODEL";
    }
}