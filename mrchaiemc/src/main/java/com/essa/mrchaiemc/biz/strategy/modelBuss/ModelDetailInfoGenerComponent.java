package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.services.usersrv.ModelBizService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component("QUERYMODELDEAILINFO")
public class ModelDetailInfoGenerComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;


    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        //chek custinfo
        if(request.getUserContext() == null || StringUtil.isEmpty(request.getUserContext().getUserId())){
            response.setResCode(ResultCode.NEEDLOGIN.name());
            return false;
        }
        //check params
        if(StringUtil.isEmpty(request.getBussExtInfo().get(BussInfoKeyEnum.MODELID))){
            response.setResCode(ResultCode.INVAILDPARAMS.name());
            return false;
        }
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID);
        List<String> modelIdList =  modelBizService.getModelIdsByCustId(request,response);
        if(CollectionUtils.isEmpty(modelIdList)){
            return false;
        }
        return modelIdList.contains(modelId);

    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        try {
            ModelDetailInfo modelDetailInfo =  modelBizService.getModelDetailInfo(request,response);
            response.setResCode(ResultCode.SUCCESS.name());
            response.setResExtInfo(new HashMap<String, String>());
            response.getResExtInfo().put(BussInfoKeyEnum.MODEL_DETAIL.getCode(), JSONObject.toJSONString(modelDetailInfo.getModelId()));
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
