package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("MODMODELDETAIL")
public class ModeldetailInfoModComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (request == null || StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode()))) {
            return false;
        }
        ModelContext modelContext = new ModelContext();
        ModelDetailInfo modelDetailInfo = null;
        ModelInfo modelInfo = null;
        request.getBussContext().setModelContext(new ModelContext());
        String modelDetailInfoJson = request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode());
        try {
            modelDetailInfo = JSONObject.parseObject(modelDetailInfoJson, new TypeReference<ModelDetailInfo>() {
            });
            request.getBussContext().getModelContext().setModelDetailInfo(modelDetailInfo);

            modelInfo = modelBizService.fetchModelInfoBase(request,response);
            request.getBussContext().getModelContext().setModelInfo(modelInfo);

        } catch (Exception e){
            LoggerUtil.errlog(e,"parse modelinfo or modelDetail fail" +
                    request.getBussExtInfo().get(BussInfoKeyEnum.MODEL_DETAIL.getCode()));
            modelDetailInfo = null;
        }
        if(modelDetailInfo == null || modelInfo == null ) {
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        modelContext.setModelInfo(modelInfo);
        modelContext.setModelDetailInfo(modelDetailInfo);
        request.getBussContext().setModelContext(modelContext);
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        try {
            modelBizService.modModelDetailInfo(request,response);
        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
        response.setResExtInfo(new HashMap<String, String>());
        response.getResExtInfo().put(BussInfoKeyEnum.MODELID.getCode(),modelDetailInfo.getModelId());
    }

    @Override
    public String getActionCode() {
        return "MODMODELDETAIL";
    }
}
