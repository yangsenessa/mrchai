package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("QUERYMODELDEAILINFO")
public class ModelDetailInfoGenerComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;


    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        //chek custinfo
        if (request.getUserContext() == null || StringUtil.isEmpty(request.getUserContext().getUserId())) {
            response.setResCode(ResultCode.NEEDLOGIN.name());
            return false;
        }
        //check params
        if(StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode()))){
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());
        return StringUtil.isNotEmpty(modelId);

    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try {
            ModelDetailInfo modelDetailInfo =  modelBizService.getModelDetailInfo(request,response);
            ModelInfo modelInfo = modelBizService.getCertailModelInfo(request,response);
            response.setResCode(ResultCode.SUCCESS.name());
            String jsonExt = JSONObject.toJSONString(modelInfo);
            String jsonDetailExt = JSONObject.toJSONString(modelDetailInfo);
            Map<String,String> modelDetailMap = JSONObject.parseObject(jsonDetailExt,new TypeReference<Map<String,String>>(){});

            response.setResExtInfo(JSONObject.parseObject(jsonExt,new TypeReference<Map<String,String>>(){}));
            response.getResExtInfo().putAll(modelDetailMap);

        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }


    }

    @Override
    public String getActionCode() {
        return "QUERYMODELDEAILINFO";
    }
}
