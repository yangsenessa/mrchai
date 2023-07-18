package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.UUID;

@Component("MODELINFOGENER")
public class ModelinfoGennerComponent implements BussComponent {

    private static Logger logger = LoggerFactory.getLogger(ModelinfoGennerComponent.class);

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (request == null || CollectionUtils.isEmpty(request.getBussExtInfo())) {
            return false;
        }
        ModelContext modelContext = new ModelContext();

        ModelInfo modelInfo= new ModelInfo();
        //unpack modelInfo
        modelInfo.setModelName(request.getBussExtInfo().get(BussInfoKeyEnum.MODELINFO_MODELNAME.getCode()));
        modelInfo.setModelSubName(request.getBussExtInfo().get(BussInfoKeyEnum.MODELINFO_MODELSUBNAME.getCode()));
        modelInfo.setCateGory1(request.getBussExtInfo().get(BussInfoKeyEnum.MODELINFO_CATEGORY1.getCode()));
        modelInfo.setCateGory2(request.getBussExtInfo().get(BussInfoKeyEnum.MODELINFO_CATEGORY2.getCode()));
        modelInfo.setCateGory3(request.getBussExtInfo().get(BussInfoKeyEnum.MODELINFO_CATEGORY3.getCode()));

        modelContext.setModelInfo(modelInfo);

        request.getBussContext().setModelContext(modelContext);
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = request.getBussContext().getModelContext().getModelInfo();
        if(modelInfo.getModelId() ==null ||StringUtil.isEmpty(modelInfo.getModelId()) ){
            modelInfo.setModelId(UUID.randomUUID().toString());
        }
        try {
            modelBizService.addOrUpdateModelInfo(request,response);
            response.setResCode(ResultCode.SUCCESS.name());
            response.setResExtInfo(new HashMap<String, String>());
            response.getResExtInfo().put(BussInfoKeyEnum.MODELID.getCode(),modelInfo.getModelId());
        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }

    }


    @Override
    public String getActionCode() {
        return "MODELINFOGENER";
    }
}
