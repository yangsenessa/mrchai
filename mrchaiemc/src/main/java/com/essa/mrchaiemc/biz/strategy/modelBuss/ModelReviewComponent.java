/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ModelStatusEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senyang
 * @version : ModelReviewComponent.java, v 0.1 2023年07月20日 10:14 PM senyang Exp $
 */
@Component("MODELREVIEW")
public class ModelReviewComponent implements BussComponent {

    private static Logger logger = LoggerFactory.getLogger(ModelReviewComponent.class);

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode()))
                || StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODELREVIEW.getCode()))) {
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        ModelInfo modelInfo = modelBizService.getCertailModelInfo(request, response);
        if (modelInfo == null) {
            LoggerUtil.errlog("model is not exsit!");
            response.setResCode(ResultCode.MODELNOTEXSIT.name());
            return false;
        }
        if (!StringUtil.equals(ModelStatusEnum.HIDDEN.getCode(), modelInfo.getModelStat())
                && StringUtil.isNotEmpty(modelInfo.getModelStat())) {
            LoggerUtil.errlog("model stat invalid!");
            response.setResCode(ResultCode.MODELSTATINV.name());
            return false;
        }
        request.getBussContext().setModelContext(new ModelContext());
        request.getBussContext().getModelContext().setModelInfo(modelInfo);
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try {
            this.modelBizService.mannerModelPublish(request, response);
        } catch (Exception e) {
            LoggerUtil.errlog(e, "Db err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }


    }

    @Override
    public String getActionCode() {
        return "MODELREVIEW";
    }
}