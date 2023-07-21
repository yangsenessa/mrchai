/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author senyang
 * @version : ModelInfoLoadByHashCodeComponent.java, v 0.1 2023年07月21日 2:05 PM senyang Exp $
 */
@Component("QUERYBYMODELHASH")
public class ModelInfoLoadByHashCodeComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        String hashCode = request.getBussExtInfo().get(BussInfoKeyEnum.MODELDETAIL_HASHCODE.getCode());
        if(StringUtil.isEmpty(hashCode)){
            LoggerUtil.errlog("HashCode,can't be null.");
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        List<ModelInfo> modelInfoList = new ArrayList<>();
        try {
            modelInfoList = this.modelBizService.fetchModelInfosByHashCode(request, response);
        } catch (Exception e) {
            LoggerUtil.errlog("DB err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setModelListArray(modelInfoList);

    }

    @Override
    public String getActionCode() {
        return "QUERYBYMODELHASH";
    }
}