/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.modelBuss;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.enumcollection.UserLevelEnum;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author senyang
 * @version : QUERYModelInfoListForReview.java, v 0.1 2023年08月08日 11:48 PM senyang Exp $
 */
@Component("QUERYMODELFORREVIEW")
public class QueryModelInfoListForReview implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;
    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        //Only super user can get review models
        if(request.getUserContext() != null &&
                UserLevelEnum.SUPER == request.getUserContext().getGrandLevel()){
            return true;
        }
        return false;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        List<ModelInfo> modelifoList = null;
        try {
            modelifoList = modelBizService.fetchModelInfosForReview(request, response);
            if (!CollectionUtils.isEmpty(modelifoList)) {
                response.setResExtInfo(new HashMap<String, String>());
                response.setModelListArray(modelifoList);
            }
        } catch (Exception e) {
            LoggerUtil.errlog(e, "Db err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setModelListArray(modelifoList);
        response.setResCode(ResultCode.SUCCESS.name());

    }

    @Override
    public String getActionCode() {
        return "QUERYMODELFORREVIEW";
    }
}