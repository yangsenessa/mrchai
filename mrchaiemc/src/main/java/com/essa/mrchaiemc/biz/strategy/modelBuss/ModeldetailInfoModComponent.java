package com.essa.mrchaiemc.biz.strategy.modelBuss;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.ModelContext;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfoV2;
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
import java.util.Map;

@Component("MODMODELDETAIL")
public class ModeldetailInfoModComponent implements BussComponent {

    @Autowired
    private ModelBizService modelBizService;

    @Autowired
    private ModelBizService modelDetailBizService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if (request == null || CollectionUtils.isEmpty(request.getBussExtInfo())) {
            return false;
        }
        ModelContext modelContext = new ModelContext();
        request.getBussContext().setModelContext(modelContext);

        ModelDetailInfoV2 modelDetailInfo = new ModelDetailInfoV2();
        ModelInfo modelInfo = null;
        request.getBussContext().setModelContext(new ModelContext());
        Map<String,String> modelDetailMap =  request.getBussExtInfo() ;

        modelDetailInfo.setModelId(modelDetailMap.get(BussInfoKeyEnum.MODELID.getCode()));
        modelDetailMap.remove(BussInfoKeyEnum.MODELID.getCode());

        /*modelDetailInfo.setVersion(modelDetailMap.get(BussInfoKeyEnum.MODELDETAIL_VERSION.getCode()));
        modelDetailMap.remove(BussInfoKeyEnum.MODELDETAIL_VERSION.getCode());*/

        modelDetailInfo.setModelFileLinks(modelDetailMap.get(BussInfoKeyEnum.MODELDETAIL_MODELFILELINKS.getCode()));
        modelDetailMap.remove(BussInfoKeyEnum.MODELDETAIL_MODELFILELINKS.getCode());

        modelDetailInfo.setModelFileHashCodes(modelDetailMap.get(BussInfoKeyEnum.MODELDETAIL_MODELFILEHASECODE.getCode()));
        modelDetailMap.remove(BussInfoKeyEnum.MODELDETAIL_MODELFILEHASECODE.getCode());

        modelDetailInfo.setExtDetailInfo(modelDetailMap);
        try {
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
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        ModelDetailInfoV2 modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        try {
            modelDetailBizService.modModelDetailInfo(request,response);
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
