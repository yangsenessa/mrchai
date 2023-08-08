/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.services.usersrv;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfoV2;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.common.dal.dao.ModelInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.v2.ModelDetailInfoKVDAO;
import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import com.essa.mrchaiemc.common.dal.repository.v2.ModelDetailInfoKVDO;
import com.essa.mrchaiemc.common.util.DateUtil;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import com.essa.mrchaiemc.common.util.ModelDetailKVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author senyang
 * @version : ModelDetailBizServiceImpl.java, v 0.1 2023年07月20日 12:09 AM senyang Exp $
 */
@Service("modelDetailBizService")
public class ModelDetailBizServiceImpl extends ModelBizServiceImpl {
    @Autowired
    private ModelDetailInfoKVDAO modelDetailInfoKVDAO;

    @Autowired
    private ModelInfoDAO modelInfoDAO;

    @Override
    @Transactional
    public void modModelDetailInfo(BussRequest request, BussResponse response) {
        ModelDetailInfoV2 modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        List<ModelDetailInfoKVDO> modelDetailInfoKVDOList = ModelDetailKVUtil.buildModelDetailInfoKVFamily(modelDetailInfo);
        try {
            ModelInfoDO modelInfoDO = this.modelInfoDAO.findByModelId(modelDetailInfo.getModelId());
            modelInfoDO.setGmtModify(DateUtil.getGmtDateTime());
            this.modelInfoDAO.save(modelInfoDO);
            modelDetailInfoKVDAO.saveAllAndFlush(modelDetailInfoKVDOList);
            response.setResCode(ResultCode.SUCCESS.name());
            response.setResExtInfo(new HashMap<>());
        } catch (Exception e) {
            LoggerUtil.errlog(e, "DB opr err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }

    }

    @Override
    public ModelDetailInfoV2 getModelDetailInfoV2(BussRequest request, BussResponse response) {
        ModelDetailInfoV2 modelDetialInfo = new ModelDetailInfoV2();
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());
        String version = request.getBussExtInfo().get(BussInfoKeyEnum.MODELDETAIL_VERSION.getCode());
        modelDetialInfo.setModelId(modelId);
        modelDetialInfo.setVersion(version);

        String groupKey = ModelDetailKVUtil.buldGroupKey(modelDetialInfo);
        try {
            modelDetialInfo = ModelDetailKVUtil.unpackColFamilyModelDetail( modelDetailInfoKVDAO.findByGroupKey(groupKey));

        } catch (Exception e) {
            LoggerUtil.errlog(e, "DB opr err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        return modelDetialInfo;
    }


}