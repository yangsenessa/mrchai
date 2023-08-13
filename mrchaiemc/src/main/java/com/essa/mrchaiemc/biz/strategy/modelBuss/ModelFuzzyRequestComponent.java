/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.modelBuss;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.FuzzyRequestStrategyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author senyang
 * @version : ModelFuzzyRequestComponent.java, v 0.1 2023年08月13日 1:22 PM senyang Exp $
 */
@Component("FUZZYREQUEST")
public class ModelFuzzyRequestComponent implements BussComponent {
    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if(request.getFuzzyRequest() == null || request.getFuzzyRequest().getFuzzyRequestStrategyAction() == null){
            return false;
        }
        //check pageable param
        if(!request.getBussExtInfo().containsKey(BussInfoKeyEnum.PAGEINDEX.getCode())
            || !request.getBussExtInfo().containsKey(BussInfoKeyEnum.PAGESIZE.getCode())) {
            request.getBussExtInfo().put(BussInfoKeyEnum.PAGEINDEX.getCode(),"0");
            request.getBussExtInfo().put(BussInfoKeyEnum.PAGESIZE.getCode(),"10");
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try{
           List<ModelInfo> resList =  modelBizService.searchModelInfoList(request,response);
           if(!CollectionUtils.isEmpty(resList)){
               response.setModelListArray(resList);
           }
        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB eer");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
    }

    @Override
    public String getActionCode() {
        return "FUZZYREQUEST";
    }
}