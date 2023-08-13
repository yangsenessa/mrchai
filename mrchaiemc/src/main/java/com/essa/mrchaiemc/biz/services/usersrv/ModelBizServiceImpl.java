package com.essa.mrchaiemc.biz.services.usersrv;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.FuzzyRequest;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfo;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfoV2;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.FuzzyRequestStrategyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ModelStatusEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.common.dal.dao.*;
import com.essa.mrchaiemc.common.dal.dao.v2.ModelDetailInfoKVDAO;
import com.essa.mrchaiemc.common.dal.repository.*;
import com.essa.mrchaiemc.common.dal.repository.v2.ModelDetailInfoKVDO;
import com.essa.mrchaiemc.common.integration.sys.BussConstant;
import com.essa.mrchaiemc.common.util.CanisterUtil;
import com.essa.mrchaiemc.common.util.DateUtil;
import com.essa.mrchaiemc.common.util.ModelDetailKVUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service("modelBizService")
public class ModelBizServiceImpl implements ModelBizService {
    @Autowired
    private ModelInfoDAO modelInfoDAO;
    @Autowired
    private ModelCoverDAO modelCoverDAO;
    @Autowired
    private ModelInvokeGuideDAO modelInvokeGuideDAO;
    @Autowired
    private ModelNegativePromtsDAO modelNegativePromtsDAO;
    @Autowired
    private ModelPositivePromtsDAO modelPositivePromtsDAO;

    @Autowired
    private Cust2ModelMappingDAO cust2ModelMappingDAO;

    @Autowired
    private ModelDetailInfoDAO modelDetailInfoDAO;

    @Autowired
    private ModelDetailInfoKVDAO modelDetailInfoKVDAO;

    @Override
    @Transactional
    public void addOrUpdateModelInfo(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = this.getModelInfo(request);


        ModelInfoDO modelInfoDO = null;
        if (StringUtils.isNoneBlank(modelInfo.getModelId())) {
            modelInfoDO = modelInfoDAO.findByModelId(modelInfo.getModelId());
        }
        if (modelInfoDO == null) {
            modelInfoDO = new ModelInfoDO();
            modelInfoDO.setGmtCreate(DateUtil.getGmtDateTime());
            // inti upload
            modelInfo.setModelStat(ModelStatusEnum.INIT.getCode());
        } else {
            modelInfoDO.setGmtModify(DateUtil.getGmtDateTime());
        }
        this.covertModelInfo2DO(modelInfo, modelInfoDO);
        Cust2ModelMappingDO cust2ModelMappingDO = new Cust2ModelMappingDO();
        cust2ModelMappingDO.setCustId(request.getUserContext().getUserId());
        cust2ModelMappingDO.setGmtCreate(DateUtil.getGmtDateTime());
        cust2ModelMappingDO.setModelId(modelInfo.getModelId());
        cust2ModelMappingDO.setMapperId(cust2ModelMappingDO.getCustId() + "-" + modelInfo.getModelId());
        cust2ModelMappingDO.setStatus(ModelStatusEnum.PUBLISH.getCode());
        modelInfoDAO.save(modelInfoDO);
        cust2ModelMappingDAO.save(cust2ModelMappingDO);
    }

    @Override
    public ModelInfo fetchModelInfoBase(BussRequest request, BussResponse response) {
        ModelDetailInfoV2 modelDetailInfo = request.getBussContext().getModelContext().getModelDetailInfo();
        ModelInfo modelInfo = new ModelInfo();
        ModelInfoDO modelInfoDO = modelInfoDAO.findByModelId(modelDetailInfo.getModelId());
        this.convertDO2ModelInfo(modelInfoDO, modelInfo);
        return modelInfo;
    }

    @Override
    public List<ModelInfo> fetchModelInfoBaseListByPages(BussRequest request, BussResponse response) {
        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));

        List<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();

        //设置分页参数
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        //封装条件查询对象Specification
        Specification<ModelInfoDO> specification = new Specification<ModelInfoDO>(){

            @Override
            public Specification<ModelInfoDO> and(Specification<ModelInfoDO> other) {
                return Specification.super.and(other);
            }

            @Override
            public Specification<ModelInfoDO> or(Specification<ModelInfoDO> other) {
                return Specification.super.or(other);
            }

            @Override
            public Predicate toPredicate(Root<ModelInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return query.where(criteriaBuilder.equal(root.get("modelStat"),"PUBLISH")).getRestriction();
            }
        };

            //分页查询
       // Page<ModelInfoDO> pageList = modelInfoDAO.findAll(specification,pageable);
        Page<ModelInfoDO> pageList = modelInfoDAO.findAll(specification,pageable);
        if (pageList == null) {
            return null;
        }
        for (ModelInfoDO modelInfoDO : pageList) {
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO, modelInfoItem);
            ModelDetailInfoKVDO modelDetailInfoKVDO  =
                    this.modelDetailInfoKVDAO.findByMainKey(
                            ModelDetailKVUtil.buildKey(modelInfoItem,BussInfoKeyEnum.MODELDETAIL_SAMPLEIMGLINKS.getCode())
                    );

            if(modelDetailInfoKVDO!= null){
                modelInfoItem.setSampleImgFileLinks(
                        CanisterUtil.transferUrlPattern(modelDetailInfoKVDO.getValue()));
            }

            modelInfoList.add(modelInfoItem);
        }
        //paged need send totalNum
        long total = modelInfoDAO.countValidModel();
        response.setTotalNum(total);
        return modelInfoList;

    }

    @Override
    public List<ModelInfo> fetchModelInfoBaseListByOwnerCustIdAndPages(BussRequest request, BussResponse response) {
        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));
        String ownerCustId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELOWNERCUSTID.getCode());

        List<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();

        //设置分页参数
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<ModelInfoDO> pageList = modelInfoDAO.findByOwnerCustId(ownerCustId,pageable);
        if (pageList == null) {
            return null;
        }
        for (ModelInfoDO modelInfoDO : pageList) {
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO, modelInfoItem);
            ModelDetailInfoKVDO modelDetailInfoKVDO  =
                    this.modelDetailInfoKVDAO.findByMainKey(
                            ModelDetailKVUtil.buildKey(modelInfoItem,BussInfoKeyEnum.MODELDETAIL_SAMPLEIMGLINKS.getCode())
                    );

            if(modelDetailInfoKVDO!= null){
                modelInfoItem.setSampleImgFileLinks(
                        CanisterUtil.transferUrlPattern(modelDetailInfoKVDO.getValue()));
            }
            modelInfoList.add(modelInfoItem);
        }
        return modelInfoList;
    }

    @Override
    public List<ModelInfo> findByCategory1(BussRequest request, BussResponse response) {
        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));
        String cateGory1 = request.getBussExtInfo().get(BussInfoKeyEnum.CATEGORY_1.getCode());
        List<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();

        //设置分页参数
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        //分页查询
        Page<ModelInfoDO> pageList = null;
        if (StringUtil.isEmpty(cateGory1)) {
            //无分类参数，降级查询全部
            pageList = modelInfoDAO.findAll(pageable);
        } else {
            pageList = modelInfoDAO.findByCateGory1(cateGory1, pageable);

        }
        if (pageList == null) {
            return null;
        }
        for (ModelInfoDO modelInfoDO : pageList) {
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO, modelInfoItem);
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
    }

    @Override
    public void modModelDetailInfoV2(BussRequest request, BussResponse response) {
    }

    @Override
    @Deprecated
    public ModelDetailInfo getModelDetailInfo(BussRequest request, BussResponse response) {
        ModelDetailInfo modelDetailInfo = new ModelDetailInfo();
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());


        ModelDetailInfoDO modelDetailInfoDO = modelDetailInfoDAO.findByModelId(modelId);
        ModelInvokeGuideDO modelInvokeGuideDO = modelInvokeGuideDAO.findByModelId(modelId);
        ModelNegativePromtsDO modelNegativePromtsDO = modelNegativePromtsDAO.findByModelId(modelId);
        ModelPositivePromtsDO modelPositivePromtsDO = modelPositivePromtsDAO.findByModelId(modelId);
        ModelCoverDO modelCoverDO = modelCoverDAO.findByModelId(modelId);

        if (modelDetailInfoDO == null) {
            response.setResCode(ResultCode.DATANOTCOMPLETED.name());
            return null;
        }
        if (modelInvokeGuideDO == null) {
            modelInvokeGuideDO = new ModelInvokeGuideDO();
        }
        if (modelNegativePromtsDO == null) {
            modelNegativePromtsDO = new ModelNegativePromtsDO();
        }
        if (modelPositivePromtsDO == null) {
            modelPositivePromtsDO = new ModelPositivePromtsDO();
        }

        convertDO2ModelDetailInfo(modelDetailInfoDO, modelInvokeGuideDO,
                modelNegativePromtsDO, modelCoverDO, modelPositivePromtsDO, modelDetailInfo);

        return modelDetailInfo;
    }

    @Override
    public ModelInfo getCertailModelInfo(BussRequest request, BussResponse response) {
        ModelInfo modelInfo = new ModelInfo();
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());

        ModelInfoDO modelInfoDO = modelInfoDAO.findByModelId(modelId);
        this.convertDO2ModelInfo(modelInfoDO, modelInfo);

        ModelDetailInfoKVDO modelDetailInfoKVDO  =
                this.modelDetailInfoKVDAO.findByMainKey(
                        ModelDetailKVUtil.buildKey(modelInfo,BussInfoKeyEnum.MODELDETAIL_SAMPLEIMGLINKS.getCode())
                );

        if(modelDetailInfoKVDO!= null){
            modelInfo.setSampleImgFileLinks(
                    CanisterUtil.transferUrlPattern(modelDetailInfoKVDO.getValue()));
        }
        return modelInfo;
    }

    /**
     *
     * @param modelId
     * @return
     */
    private ModelInfo getModelInfoByModelId(String modelId){
        ModelInfo modelInfo = new ModelInfo();
        ModelInfoDO modelInfoDO = modelInfoDAO.findByModelId(modelId);
        this.convertDO2ModelInfo(modelInfoDO, modelInfo);
        return modelInfo;

    }

    @Override
    public List<String> getModelIdsByCustId(BussRequest request, BussResponse response) {
        String custId = request.getUserContext().getUserId();
        if (StringUtil.isEmpty(custId)) {
            return null;
        }

        List<String> modelIdList = new ArrayList<String>();
        List<Cust2ModelMappingDO> cust2ModelMappingDOList = this.cust2ModelMappingDAO.findByCustId(custId);

        for (Cust2ModelMappingDO item : cust2ModelMappingDOList) {
            modelIdList.add(item.getModelId());
        }

        return modelIdList;
    }

    @Override
    public  ModelDetailInfoV2 getModelDetailInfoV2(BussRequest request, BussResponse response){
        return null;
    }

    @Override
    public void mannerModelPublish(BussRequest request, BussResponse response) {
        String custId =  request.getUserContext().getUserId();
        String reviewIssue = request.getBussExtInfo().get(BussInfoKeyEnum.MODELREVIEWISSUE.getCode());
        String reviewResCode =  request.getBussExtInfo().get(BussInfoKeyEnum.MODELREVIEWRESCODE.getCode());
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());

        ModelInfoDO modelInfoDO =this.modelInfoDAO.findByModelId(modelId);
        modelInfoDO.setMannerUserId(custId);
        if(StringUtil.equals(BussConstant.ACCEPT_MODEL, reviewResCode)){
            modelInfoDO.setModelStat(ModelStatusEnum.PUBLISH.getCode());
            modelInfoDO.setGmtReview(DateUtil.getGmtDateTime());
        }

        if(StringUtil.equals(BussConstant.REFUSE_MODEL, reviewResCode)) {
            modelInfoDO.setModelStat(ModelStatusEnum.INIT.getCode());
        }
        modelInfoDO.setMannerUserId(request.getUserContext().getUserId());
        modelInfoDO.setGmtModify(DateUtil.getGmtDateTime());
        this.modelInfoDAO.save(modelInfoDO);

        ModelDetailInfoKVDO modelDetailInfoKVDO =  ModelDetailKVUtil.buildColSingle(modelId,BussInfoKeyEnum.MODELREVIEWISSUE.getCode(), reviewIssue);
        this.modelDetailInfoKVDAO.save(modelDetailInfoKVDO);
    }

    @Override
    public List<ModelInfo> fetchModelInfosByHashCode(BussRequest request, BussResponse response) {
        //The value of hashCode has been checked by the prior component
        String hashCode = request.getBussExtInfo().get(BussInfoKeyEnum.MODELDETAIL_HASHCODE.getCode());
        List<ModelDetailInfoKVDO> modelDetailInfoKVDOList =  this.modelDetailInfoKVDAO.findByValue(hashCode);
        List<ModelInfo> modelInfoList = new ArrayList<>();
        if(modelDetailInfoKVDOList == null){
            return null;
        }
        for(ModelDetailInfoKVDO modelDetailInfoKVDO: modelDetailInfoKVDOList){
            String mainKey = modelDetailInfoKVDO.getMainKey();
            String modelId = StringUtil.EMPTY;

            if(StringUtil.endsWithIgnoreCase(mainKey,BussInfoKeyEnum.MODELDETAIL_HASHCODE.getCode())){
                String[] keySplit = StringUtil.split(mainKey,"#");
                if(keySplit != null){
                    modelId = keySplit[0];
                    if(StringUtil.isNotEmpty(modelId)){
                        ModelInfo modelInfo = this.getModelInfoByModelId(modelId);
                        modelInfoList.add(modelInfo);
                    }
                }
            }
        }

        return modelInfoList;
    }

    @Override
    public List<ModelInfo> fetchModelInfosForReview(BussRequest request, BussResponse response) {

        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));

        List<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();

        //设置分页参数
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        //封装条件查询对象Specification
        Specification<ModelInfoDO> specification = new Specification<ModelInfoDO>(){

            @Override
            public Specification<ModelInfoDO> and(Specification<ModelInfoDO> other) {
                return Specification.super.and(other);
            }

            @Override
            public Specification<ModelInfoDO> or(Specification<ModelInfoDO> other) {
                return Specification.super.or(other);
            }

            @Override
            public Predicate toPredicate(Root<ModelInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return query.where(criteriaBuilder.equal(root.get("modelStat"),"SUBMIT")).getRestriction();
            }
        };

        //分页查询
        // Page<ModelInfoDO> pageList = modelInfoDAO.findAll(specification,pageable);
        Page<ModelInfoDO> pageList = modelInfoDAO.findAll(specification,pageable);
        if (pageList == null) {
            return null;
        }
        for (ModelInfoDO modelInfoDO : pageList) {
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO, modelInfoItem);
            ModelDetailInfoKVDO modelDetailInfoKVDO  =
                    this.modelDetailInfoKVDAO.findByMainKey(
                            ModelDetailKVUtil.buildKey(modelInfoItem,BussInfoKeyEnum.MODELDETAIL_SAMPLEIMGLINKS.getCode())
                    );

            if(modelDetailInfoKVDO!= null){
                modelInfoItem.setSampleImgFileLinks(
                        CanisterUtil.transferUrlPattern(modelDetailInfoKVDO.getValue()));
            }

            modelInfoList.add(modelInfoItem);
        }
        //paged need send totalNum
        long total = modelInfoDAO.countValidModel();
        response.setTotalNum(total);
        return modelInfoList;
    }

    @Override
    public void submitModel(BussRequest request, BussResponse response) {
        String modelId = request.getBussExtInfo().get(BussInfoKeyEnum.MODELID.getCode());
        String custId = request.getUserContext().getUserId();
        ModelInfoDO modelInfoDO = this.modelInfoDAO.findByModelIdAndOwnerCustId(modelId, custId);
        if(modelInfoDO == null){
            response.setResCode(ResultCode.MODELNOTEXSIT.getMsg());
            return;
        }
        modelInfoDO.setModelStat(ModelStatusEnum.SUBMIT.getCode());
        modelInfoDO.setGmtModify(DateUtil.getGmtDateTime());
        this.modelInfoDAO.save(modelInfoDO);
        response.setResCode(ResultCode.SUCCESS.getMsg());
    }

    @Override
    public List<ModelInfo> searchModelInfoList(BussRequest request, BussResponse response) {
        FuzzyRequestStrategyEnum fuzzyRequestStrategyAction =
                request.getFuzzyRequest().getFuzzyRequestStrategyAction();
        FuzzyRequest fuzzyRequest = request.getFuzzyRequest();
        List<ModelInfoDO> resListDO = null;
        Page<ModelInfoDO> pageList =  null;

        int pageIndex = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGEINDEX.getCode()));
        int pageSize = Integer.parseInt(request.getBussExtInfo().get(BussInfoKeyEnum.PAGESIZE.getCode()));
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        if(FuzzyRequestStrategyEnum.SEARCH_BY_TITILE == fuzzyRequestStrategyAction){
            pageList = modelInfoDAO.findModelByTitleLike(fuzzyRequest.getDesText(),pageable);
        }
        if(FuzzyRequestStrategyEnum.SEARCH_BY_TAG == fuzzyRequestStrategyAction){
            pageList = modelInfoDAO.findModelByTagLike(fuzzyRequest.getTagText(),pageable);
        }
        if(FuzzyRequestStrategyEnum.SEARCH_BY_CATEGORY == fuzzyRequestStrategyAction ){
            pageList = modelInfoDAO.findModelByCateGoryLike(fuzzyRequest.getTagText(),pageable);
        }
        if(FuzzyRequestStrategyEnum.SEARCH_BY_MODELSTAT ==  fuzzyRequestStrategyAction){
            pageList = modelInfoDAO.findByModelStat(fuzzyRequest.getModelStat(), pageable);
        }
        if(FuzzyRequestStrategyEnum.SEARCH_BY_FUZZYMIXTRUE == fuzzyRequestStrategyAction ){
            pageList = modelInfoDAO.findModelByTextFuzzy(fuzzyRequest.getDesText(),fuzzyRequest.getTagText(),fuzzyRequest.getCateText(), pageable);
        }
        if (pageList == null) {
            return null;
        }

        List<ModelInfo> resList = new ArrayList<>();
        for(ModelInfoDO modelInfoDO: pageList){
            ModelInfo modelInfoItem = new ModelInfo();
            this.convertDO2ModelInfo(modelInfoDO, modelInfoItem);
            resList.add(modelInfoItem);
        }

        response.setTotalNum(pageList.getTotalElements());

        return resList;
    }

    /**
     * @param request
     */
    private ModelInfo getModelInfo(BussRequest request) {
        return request.getBussContext().getModelContext().getModelInfo();
    }

    /**
     * 2DO模型转换
     *
     * @param modelInfo
     * @param modelInfoDO
     */
    private void covertModelInfo2DO(ModelInfo modelInfo, ModelInfoDO modelInfoDO) {
        if (StringUtils.isNotBlank(modelInfo.getModelId())) {
            modelInfoDO.setModelId(modelInfo.getModelId());
        }
        if (StringUtils.isNotBlank(modelInfo.getOwnerCustId())){
            modelInfoDO.setOwnerCustId(modelInfo.getOwnerCustId());
        }
        if (StringUtils.isNotBlank(modelInfo.getMannerUserId())){
            modelInfoDO.setMannerUserId(modelInfo.getMannerUserId());
        }
        if (StringUtils.isNotBlank(modelInfo.getModelName())) {
            modelInfoDO.setModelName(modelInfo.getModelName());
        }
        if (StringUtils.isNotBlank(modelInfo.getModelSubName())) {
            modelInfoDO.setModelSubName(modelInfo.getModelSubName());
        }
        if (StringUtils.isNotBlank(modelInfo.getCateGory1())) {
            modelInfoDO.setCateGory1(modelInfo.getCateGory1());
        }
        if (StringUtils.isNotBlank(modelInfo.getCateGory2())) {
            modelInfoDO.setCateGory2(modelInfo.getCateGory2());
        }
        if (StringUtils.isNotBlank(modelInfo.getCateGory3())) {
            modelInfoDO.setCateGory3(modelInfo.getCateGory3());
        }
        if(StringUtil.isNotBlank(modelInfo.getModelStat())){
            modelInfoDO.setModelStat(modelInfo.getModelStat());
        }
    }


    /**
     * 2DO模型转换-modeldetailInfo
     *
     * @param modelDetailInfo
     * @param modelDetailInfoDO
     */
    private void convertModelDetailInfo2DO(ModelDetailInfo modelDetailInfo,
                                           ModelDetailInfoDO modelDetailInfoDO) {
        modelDetailInfoDO.setModelId(modelDetailInfo.getModelId());
        modelDetailInfoDO.setModelFileLink(modelDetailInfo.getModelFileLink());
        modelDetailInfoDO.setEmcInvokeParam(JSONObject.toJSONString(modelDetailInfo.getEmcInvokeParam()));
        modelDetailInfoDO.setGuideLink(modelDetailInfo.getGuideLink());
        modelDetailInfoDO.setParamsGuideLink(modelDetailInfo.getParamsGuideLink());
        modelDetailInfoDO.setSampleCodeLink(modelDetailInfo.getSampleCodeLink());
        modelDetailInfoDO.setVersion(modelDetailInfo.getVersion());
        modelDetailInfoDO.setModelDesc(modelDetailInfo.getModelDesc());
        modelDetailInfoDO.setSeed(modelDetailInfo.getSeed());
        modelDetailInfoDO.setNumInferenceSteps(modelDetailInfo.getNumInferenceSteps());
        modelDetailInfoDO.setTags(modelDetailInfo.getTags());

    }

    /**
     * DO 2 DOMAIN modelInfo 模型转换
     *
     * @param modelInfoDO
     * @param modelInfo
     */
    private void convertModelInfoDO2Domain(ModelInfoDO modelInfoDO, ModelInfo modelInfo) {
        modelInfo.setModelId(modelInfoDO.getModelId());
        modelInfo.setModelKey(modelInfoDO.getModelKey());
        modelInfo.setModelName(modelInfoDO.getModelName());
        modelInfo.setModelSubName(modelInfoDO.getModelSubName());
        modelInfo.setCateGory3(modelInfoDO.getCateGory3());
        modelInfo.setCateGory2(modelInfoDO.getCateGory2());
        modelInfo.setCateGory1(modelInfoDO.getCateGory1());
    }


    /**
     * @param modelDetailInfo
     * @param modelInvokeGuideDO
     */
    private void convertModelDetailInfo2ModelInvokeGuideDO(ModelDetailInfo modelDetailInfo, ModelInvokeGuideDO modelInvokeGuideDO) {
        modelInvokeGuideDO.setInvokeGuide(modelDetailInfo.getInvokeGuide());
        modelInvokeGuideDO.setModelId(modelDetailInfo.getModelId());
        modelInvokeGuideDO.setVersion(modelDetailInfo.getVersion());
    }


    private void convertDO2ModelDetailInfo(ModelDetailInfoDO modelDetailInfoDO, ModelInvokeGuideDO modelInvokeGuideDO,
                                           ModelNegativePromtsDO modelNegativePromtsDO, ModelCoverDO modelCoverDO,
                                           ModelPositivePromtsDO modelPositivePromtsDO, ModelDetailInfo modelDetailInfo) {


        modelDetailInfo.setVersion(modelDetailInfoDO.getVersion());
        modelDetailInfo.setModelId(modelDetailInfoDO.getModelId());
        modelDetailInfo.setModelFileLink(modelDetailInfoDO.getModelFileLink());
        modelDetailInfo.setNegativePromts(modelNegativePromtsDO.getNegativePromts());
        modelDetailInfo.setPositivePromts(modelPositivePromtsDO.getPromts());
        modelDetailInfo.setInvokeGuide(modelInvokeGuideDO.getInvokeGuide());
        modelDetailInfo.setEnhancePromts(modelPositivePromtsDO.getEnhancePromts());
        //modelDetailInfo.setEmcInvokeParam(modelDetailInfoDO.getEmcInvokeParam());
        modelDetailInfo.setGuideLink(modelDetailInfoDO.getGuideLink());
        modelDetailInfo.setParamsGuideLink(modelDetailInfoDO.getParamsGuideLink());
        modelDetailInfo.setSampleCodeLink(modelDetailInfoDO.getSampleCodeLink());
        modelDetailInfo.setNumInferenceSteps(modelDetailInfoDO.getNumInferenceSteps());
        modelDetailInfo.setSampleImgFileLink(modelCoverDO.getCoverImgList());
        modelDetailInfo.setSeed(modelDetailInfoDO.getSeed());
        modelDetailInfo.setTags(modelDetailInfoDO.getTags());
        modelDetailInfo.setModelDesc(modelDetailInfoDO.getModelDesc());
        modelDetailInfo.setNumInferenceSteps(modelDetailInfoDO.getNumInferenceSteps());
    }

    /**
     * parse List into String which is separated by ','
     *
     * @param params
     * @return
     */
    private String parseListToString(List<String> params) {
        StringBuffer sb = new StringBuffer();
        for (String s : params) {
            if (StringUtil.isEmpty(s)) {
                continue;
            }
            sb.append(s);
            sb.append(",");
        }
        return sb.toString();

    }


    /**
     * @param modelDetailInfo
     * @param modelNegativePromtsDO
     */
    private void convertModelDetailInfo2ModelNagativePromptsDO(ModelDetailInfo modelDetailInfo, ModelNegativePromtsDO modelNegativePromtsDO) {
        if (!StringUtil.isEmpty(modelDetailInfo.getNegativePromts())) {
            modelNegativePromtsDO.setNegativePromts(JSONObject.toJSONString(modelDetailInfo.getNegativePromts()));
        }
        modelNegativePromtsDO.setModelId(modelDetailInfo.getModelId());
        modelNegativePromtsDO.setVersion(modelDetailInfo.getVersion());
    }

    /**
     * @param modelDetailInfo
     * @param modelPositivePromtsDO
     */
    private void convertModelDetailInfo2ModelPositivePromptsDO(ModelDetailInfo modelDetailInfo, ModelPositivePromtsDO modelPositivePromtsDO) {
        modelPositivePromtsDO.setModelId(modelDetailInfo.getModelId());
        modelPositivePromtsDO.setVersion(modelDetailInfo.getVersion());
        modelPositivePromtsDO.setEnhancePromts(modelDetailInfo.getEnhancePromts());

        if (!StringUtil.isEmpty(modelDetailInfo.getPositivePromts())) {
            modelPositivePromtsDO.setPromts(JSONObject.toJSONString(modelDetailInfo.getPositivePromts()));
        }
    }

    /**
     * Domain 模型转换
     *
     * @param modelInfoDO
     * @param modelInfo
     */
    private void convertDO2ModelInfo(ModelInfoDO modelInfoDO, ModelInfo modelInfo) {
        if (modelInfo == null) {
            modelInfo = new ModelInfo();
        }
        if (modelInfoDO == null) {
            modelInfo = null;
        } else {
            modelInfo.setModelId(modelInfoDO.getModelId());
            modelInfo.setModelName(modelInfoDO.getModelName());
            modelInfo.setModelKey(modelInfoDO.getModelKey());
            modelInfo.setModelSubName(modelInfoDO.getModelSubName());
            modelInfo.setOwnerCustId(modelInfoDO.getOwnerCustId());
            modelInfo.setMannerUserId(modelInfoDO.getMannerUserId());
            modelInfo.setCateGory1(modelInfoDO.getCateGory1());
            modelInfo.setCateGory2(modelInfoDO.getCateGory2());
            modelInfo.setCateGory3(modelInfoDO.getCateGory3());
            modelInfo.setModelStat(modelInfoDO.getModelStat());
        }
    }


}
