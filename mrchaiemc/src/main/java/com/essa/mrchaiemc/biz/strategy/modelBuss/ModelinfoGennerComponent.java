package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("MODELINFOGENER")
public class ModelinfoGennerComponent implements BussComponent {

    private static Logger logger = LoggerFactory.getLogger(ModelinfoGennerComponent.class);

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if(request == null || StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_INFO.getCode()))){
            return false;
        }
        ModelContext modelContext = new ModelContext();
        String modelInfoJson = request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_INFO.getCode());
        ModelInfo modelInfo=JSONObject.parseObject(modelInfoJson,new TypeReference<ModelInfo>(){});
        if(modelInfo == null) {
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        modelContext.setModelInfo(modelInfo);
        request.getBussContext().setModelContext(modelContext);
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = request.getBussContext().getModelContext().getModelInfo();
        modelInfo.setModelId(UUID.randomUUID().toString());
        try {
            modelBizService.addOrUpdateModelInfo(request,response);
        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
        response.setResExtInfo(new HashMap<String, String>());
        response.getResExtInfo().put(BussInfoKeyEnum.MODELID.getCode(),modelInfo.getModelId());
    }


    @Override
    public String getActionCode() {
        return "MODELINFOGENER";
    }
}
