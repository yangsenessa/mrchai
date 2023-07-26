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
import com.essa.mrchaiemc.common.integration.sys.BussConstant;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author senyang
 * @version : QueryModelInfoByOwnerCustId.java, v 0.1 2023年07月26日 11:41 AM senyang Exp $
 */
@Component("QUERYMODELBYCUSTIDH")
public class QueryModelInfoByOwnerCustId implements BussComponent {
    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()))
                || StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()))) {

            request.getBussExtInfo().put(BussInfoKeyEnum.PAGEINDEX.getCode(),
                    String.valueOf(BussConstant.PAGEINDEX));
            request.getBussExtInfo().put(BussInfoKeyEnum.PAGESIZE.getCode(),
                    String.valueOf(BussConstant.PAGESIZE));

        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        List<ModelInfo> modelifoList = null;
        try {
            modelifoList = modelBizService.fetchModelInfoBaseListByPages(request, response);
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
        return "QUERYMODELBYCUSTIDH";
    }
}