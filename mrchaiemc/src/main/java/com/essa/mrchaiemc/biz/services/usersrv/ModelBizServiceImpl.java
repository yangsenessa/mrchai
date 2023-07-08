package com.essa.mrchaiemc.biz.services.usersrv;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.Cust2ModelMapping;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ModelStatusEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;

import com.essa.mrchaiemc.common.dal.dao.*;
import com.essa.mrchaiemc.common.dal.repository.*;
import com.essa.mrchaiemc.common.util.DateUtil;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("modelBizService")
public class ModelBizServiceImpl implements ModelBizService{
    @Autowired
    private ModelInfoDAO modelInfoDAO;
    @Autowired
    private ModelInvokeGuideDAO modelInvokeGuideDAO;
    @Autowired
    private ModelNegativePromtsDAO modelNegativePromtsDAO;
    @Autowired
    private ModelPositivePromtsDAO modelPositivePromtsDAO;
    @Autowired
    private ModelParamsDAO modelParamsDAO;
    @Autowired
    private Cust2ModelMappingDAO cust2ModelMappingDAO;


    @Autowired
    private ModelDetailInfoDAO modelDetailInfoDAO;

    @Override
    @Transactional
    public void addOrUpdateModelInfo(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = this.getModelInfo(request);
        ModelInfoDO modelInfoDO = new ModelInfoDO();
        this.covertModelInfo2DO(modelInfo, modelInfoDO);

        Cust2ModelMappingDO cust2ModelMappingDO = new Cust2ModelMappingDO();
        cust2ModelMappingDO.setCustId(request.getUserContext().getUserId());
        cust2ModelMappingDO.setGmtCreate(DateUtil.getGmtDateTime());
        cust2ModelMappingDO.setModelId(modelInfo.getModelId());
        cust2ModelMappingDO.setMapperId(cust2ModelMappingDO.getCustId()+"-"+modelInfo.getModelId());
        cust2ModelMappingDO.setStatus(ModelStatusEnum.NORMAL.getCode());
        modelInfoDAO.save(modelInfoDO);
        cust2ModelMappingDAO.save(cust2ModelMappingDO);
    }

    @Override
    public ModelInfo fetchModelInfoBase(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        ModelInfo modelInfo = new ModelInfo();
        ModelInfoDO modelInfoDO = modelInfoDAO.findByModelId(modelDetailInfo.getModelId());
        this.convertDO2ModelInfo(modelInfoDO,modelInfo);
        return modelInfo;
    }

    @Override
    public List<ModelInfo> fetchModelInfoBaseListByPages(BussRequest request, BussResponse response) {
        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));

        List<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();

        //设置分页参数
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
         //分页查询
        Page<ModelInfoDO> pageList = modelInfoDAO.findAll(pageable);
        if(pageList == null){
            return null;
        }
        for (ModelInfoDO modelInfoDO: pageList){
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO,modelInfoItem);
            modelInfoList.add(modelInfoItem);
        }
        return modelInfoList;

    }

    @Override
    public void addOrUpdateModelCovers(BussRequest request, BussResponse response) {

    }

    @Override
    public void addOrUpdateModelFilesInfo(BussRequest request, BussResponse response) {

    }

    @Override
    public void modModelDetailInfo(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo =request.getBussContext().getModelContext().getModelDetailInfo();
        ModelDetailInfoDO modelDetailInfoDO = new ModelDetailInfoDO();
        ModelParamsDO modelParamsDO = new ModelParamsDO();
        ModelPositivePromtsDO modelPositivePromtsDO = new ModelPositivePromtsDO();
        ModelNegativePromtsDO modelNegativePromtsDO = new ModelNegativePromtsDO();
        ModelInvokeGuideDO modelInvokeGuideDO = new ModelInvokeGuideDO();

        this.convertModelDetailInfo2DO(modelDetailInfo, modelDetailInfoDO);
        this.convertModelDetailInfo2ModelInvokeGuideDO(modelDetailInfo, modelInvokeGuideDO);
        this.convertModelDetailInfo2ModelNagativePromptsDO(modelDetailInfo, modelNegativePromtsDO);
        this.convertModelDetailInfo2ModelPositivePromptsDO(modelDetailInfo, modelPositivePromtsDO);
        this.convertModelDetailInfo2ModelParamsDO(modelDetailInfo,modelParamsDO);
        try {
            this.modelDetailInfoDAO.save(modelDetailInfoDO);
            this.modelInvokeGuideDAO.save(modelInvokeGuideDO);
            this.modelParamsDAO.save(modelParamsDO);
            this.modelNegativePromtsDAO.save(modelNegativePromtsDO);
            this.modelPositivePromtsDAO.save(modelPositivePromtsDO);
            response.setResCode(ResultCode.SUCCESS.name());
            response.setResExtInfo(new HashMap<>());
            response.getResExtInfo().put("MODELINFO",
                    JSONObject.toJSONString(request.getBussContext().getModelContext().getModelInfo()));
            response.getResExtInfo().put("MODELDETAILINFO",
                    JSONObject.toJSONString(request.getBussContext().getModelContext().getModelDetailInfo()));

        } catch (Exception e) {
            LoggerUtil.errlog(e,"DB opr err!");
            response.setResCode(ResultCode.DBEXCEPTION.name());
        }

    }

    @Override
    public ModelDetailInfo getModelDetailInfo(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo = new ModelDetailInfo();
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());
        ModelDetailInfoDO modelDetailInfoDO = modelDetailInfoDAO.findByModelId(modelId);
        ModelInvokeGuideDO modelInvokeGuideDO = modelInvokeGuideDAO.findByModelId(modelId);
        ModelNegativePromtsDO modelNegativePromtsDO = modelNegativePromtsDAO.findByModelId(modelId);
        ModelParamsDO modelParamsDO = modelParamsDAO.findByModelId(modelId);
        ModelPositivePromtsDO modelPositivePromtsDO = modelPositivePromtsDAO.findByModelId(modelId);


        convertDO2ModelDetailInfo(modelDetailInfoDO,modelInvokeGuideDO,
                modelNegativePromtsDO,modelPositivePromtsDO,modelParamsDO,modelDetailInfo);

        return modelDetailInfo;
    }

    @Override
    public List<String> getModelIdsByCustId(BussRequest request, BussResponse response) {
        String custId = request.getUserContext().getUserId();
        if(StringUtil.isEmpty(custId)){
            return null;
        }

        List<String> modelIdList = new ArrayList<String>();
        List<Cust2ModelMappingDO> cust2ModelMappingDOList = this.cust2ModelMappingDAO.findByCustId(custId);

        for(Cust2ModelMappingDO item : cust2ModelMappingDOList){
            modelIdList.add(item.getModelId());
        }

        return modelIdList;
    }

    /**
     *
     * @param request
     */
    private ModelInfo getModelInfo(BussRequest request){
        return request.getBussContext().getModelContext().getModelInfo();
    }
    /**
     * 2DO模型转换
     * @param modelInfo
     * @param modelInfoDO
     */
    private void covertModelInfo2DO(ModelInfo modelInfo, ModelInfoDO modelInfoDO){
        modelInfoDO.setModelId(modelInfo.getModelId());
        modelInfoDO.setModelName(modelInfo.getModelName());
        modelInfoDO.setModelSubName(modelInfo.getModelSubName());
        modelInfoDO.setCateGory1(modelInfo.getCateGory1());
        modelInfoDO.setCateGory2(modelInfo.getCateGory2());
        modelInfoDO.setCateGory3(modelInfo.getCateGory3());
    }


    /**
     * 2DO模型转换-modeldetailInfo
     * @param modelDetailInfo
     * @param modelDetailInfoDO
     */
    private void convertModelDetailInfo2DO(ModelDetailInfo modelDetailInfo,
                                           ModelDetailInfoDO modelDetailInfoDO){
        modelDetailInfoDO.setModelId(modelDetailInfo.getModelId());
        modelDetailInfoDO.setDownLoadLink(modelDetailInfo.getDownLoadLink());
        modelDetailInfoDO.setEmcInvokeParam(JSONObject.toJSONString(modelDetailInfo.getEmcInvokeParam()));
        modelDetailInfoDO.setGuideLink(modelDetailInfo.getGuideLink());
        modelDetailInfoDO.setParamsGuideLink(modelDetailInfo.getParamsGuideLink());
        modelDetailInfoDO.setSampleCodeLink(modelDetailInfo.getSampleCodeLink());
        modelDetailInfoDO.setVersion(modelDetailInfo.getVersion());
    }

    /**
     * DO 2 DOMAIN modelInfo 模型转换
     * @param modelInfoDO
     * @param modelInfo
     */
    private void convertModelInfoDO2Domain(ModelInfoDO modelInfoDO, ModelInfo modelInfo){
        modelInfo.setModelId(modelInfoDO.getModelId());
        modelInfo.setModelKey(modelInfoDO.getModelKey());
        modelInfo.setModelName(modelInfoDO.getModelName());
        modelInfo.setModelSubName(modelInfoDO.getModelSubName());
        modelInfo.setCateGory3(modelInfoDO.getCateGory3());
        modelInfo.setCateGory2(modelInfoDO.getCateGory2());
        modelInfo.setCateGory1(modelInfoDO.getCateGory1());
    }


    /**
     *
     * @param modelDetailInfo
     * @param modelInvokeGuideDO
     */
    private void convertModelDetailInfo2ModelInvokeGuideDO(ModelDetailInfo modelDetailInfo, ModelInvokeGuideDO modelInvokeGuideDO){
        modelInvokeGuideDO.setInvokeGuide(modelDetailInfo.getInvokeGuide());
        modelInvokeGuideDO.setModelId(modelDetailInfo.getModelId());
        modelInvokeGuideDO.setVersion(modelDetailInfo.getVersion());
    }


    private void convertDO2ModelDetailInfo(ModelDetailInfoDO modelDetailInfoDO,ModelInvokeGuideDO modelInvokeGuideDO,
                                           ModelNegativePromtsDO modelNegativePromtsDO,
                                           ModelPositivePromtsDO modelPositivePromtsDO,ModelParamsDO modelParamsDO,ModelDetailInfo modelDetailInfo){
        modelDetailInfo.setVersion(modelDetailInfoDO.getVersion());
        modelDetailInfo.setModelId(modelDetailInfoDO.getModelId());
        modelDetailInfo.setCommonParams(modelParamsDO.getCommonParams());
        modelDetailInfo.setNegativePromts(modelNegativePromtsDO.getNegativePromts());
        modelDetailInfo.setPositivePromts(modelPositivePromtsDO.getPromts());
        modelDetailInfo.setInvokeGuide(modelInvokeGuideDO.getInvokeGuide());
        modelDetailInfo.setDownLoadLink(modelDetailInfoDO.getDownLoadLink());
        //modelDetailInfo.setEmcInvokeParam(modelDetailInfoDO.getEmcInvokeParam());
        modelDetailInfo.setGuideLink(modelDetailInfoDO.getGuideLink());
        modelDetailInfo.setParamsGuideLink(modelDetailInfoDO.getParamsGuideLink());
        modelDetailInfo.setSampleCodeLink(modelDetailInfoDO.getSampleCodeLink());
    }


    /**
     *
     * @param modelDetailInfo
     * @param modelNegativePromtsDO
     */
    private void convertModelDetailInfo2ModelNagativePromptsDO(ModelDetailInfo modelDetailInfo, ModelNegativePromtsDO modelNegativePromtsDO){
        if(!StringUtil.isEmpty( modelDetailInfo.getNegativePromts())){
            modelNegativePromtsDO.setNegativePromts(JSONObject.toJSONString(modelDetailInfo.getNegativePromts()));
        }
        modelNegativePromtsDO.setModelId(modelDetailInfo.getModelId());
        modelNegativePromtsDO.setVersion(modelDetailInfo.getVersion());
    }

    /**
     *
     * @param modelDetailInfo
     * @param modelPositivePromtsDO
     */
    private void convertModelDetailInfo2ModelPositivePromptsDO(ModelDetailInfo modelDetailInfo, ModelPositivePromtsDO modelPositivePromtsDO){
        modelPositivePromtsDO.setModelId(modelDetailInfo.getModelId());
        modelPositivePromtsDO.setVersion(modelDetailInfo.getVersion());

        if(!StringUtil.isEmpty(modelDetailInfo.getPositivePromts()) ){
            modelPositivePromtsDO.setPromts(JSONObject.toJSONString(modelDetailInfo.getPositivePromts()));
        }
    }

    /**
     *
     * @param modelDetailInfo
     * @param modelParamsDO
     */
    private void convertModelDetailInfo2ModelParamsDO(ModelDetailInfo modelDetailInfo,ModelParamsDO modelParamsDO){

        modelParamsDO.setModelId(modelDetailInfo.getModelId());
        modelParamsDO.setVersion(modelDetailInfo.getVersion());
        if(!StringUtil.isEmpty(modelDetailInfo.getCommonParams())){
            modelParamsDO.setCommonParams(JSONObject.toJSONString(modelDetailInfo.getCommonParams()) );
        }
    }


    /**
     * Domain 模型转换
     * @param modelInfoDO
     * @param modelInfo
     */
    private void convertDO2ModelInfo(ModelInfoDO modelInfoDO, ModelInfo modelInfo){
        if(modelInfo == null){
            modelInfo = new ModelInfo();
        }
        if(modelInfoDO == null){
            modelInfo = null;
        } else {
            modelInfo.setModelId(modelInfoDO.getModelId());
            modelInfo.setModelName(modelInfoDO.getModelName());
            modelInfo.setModelKey(modelInfoDO.getModelKey());
            modelInfo.setModelSubName(modelInfoDO.getModelSubName());
            modelInfo.setCateGory1(modelInfoDO.getCateGory1());
            modelInfo.setCateGory2(modelInfoDO.getCateGory2());
            modelInfo.setCateGory3(modelInfoDO.getCateGory3());
        }

    }



}
