package com.essa.mrchaiemc.biz.strategy.modelBuss;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
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

@Component("QUERYMODELBYCATEGORY1")
public class ModelInfoCategory1ListComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        //如果前端没有上传分页参数，赋值默认值
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
        List<ModelInfo> modelifoList =  null;
        try {
            modelifoList = modelBizService.findByCategory1(request, response);
            if(!CollectionUtils.isEmpty(modelifoList)){
                response.setResExtInfo(new HashMap<String,String>());
                response.getResExtInfo().put("modelList", JSONObject.toJSONString(modelifoList));
            }
        } catch (Exception e) {
            LoggerUtil.errlog(e,"Db err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
    }

    @Override
    public String getActionCode() {
        return "QUERYMODELBYCATEGORY1";
    }
}
