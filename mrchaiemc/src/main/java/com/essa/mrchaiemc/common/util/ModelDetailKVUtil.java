/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.util;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelDetailInfoV2;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.common.dal.repository.v2.ModelDetailInfoKVDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author senyang
 * @version : ModelDetailKVUtil.java, v 0.1 2023年07月20日 12:43 AM senyang Exp $
 */
public class ModelDetailKVUtil {
    /** not have managemented version*/
    private static String DEFAULT_V = "NO_VERSION";

    /**
     * build grpup_key
     */
    public static String buldGroupKey(ModelDetailInfoV2 modelDetailInfoV2) {
        StringBuffer stb = new StringBuffer();
        stb.append(modelDetailInfoV2.getModelId());
        stb.append("#");

        stb.append(DEFAULT_V);
        stb.append("#");

        return stb.toString();

    }

    /**
     * build key
     */
    public static String buildKey(ModelDetailInfoV2 modelDetailInfoV2, String keyName) {
        StringBuffer stb = new StringBuffer();
        stb.append(buldGroupKey(modelDetailInfoV2));
        stb.append("#");
        stb.append(keyName);
        return stb.toString();
    }

    /**
     *
     * @param modelInfo
     * @return
     */
    public static String buldGroupKey(ModelInfo modelInfo) {
        StringBuffer stb = new StringBuffer();
        stb.append(modelInfo.getModelId());
        stb.append("#");

        stb.append(DEFAULT_V);
        stb.append("#");

        return stb.toString();
    }



    /**
     * build key
     */
    public static String buildKey(ModelInfo modelInfo, String keyName) {
        StringBuffer stb = new StringBuffer();
        stb.append(buldGroupKey(modelInfo));
        stb.append("#");
        stb.append(keyName);
        return stb.toString();
    }

    /**
     * build ModelDetailInfoKVFamily
     */
    public static List<ModelDetailInfoKVDO> buildModelDetailInfoKVFamily(ModelDetailInfoV2 modelDetailInfoV2) {
        List<ModelDetailInfoKVDO> modelDetailInfoKVDOList = new ArrayList<ModelDetailInfoKVDO>();
        //fix col
        modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, BussInfoKeyEnum.MODELID.getCode(), modelDetailInfoV2.getModelId()));
        modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, BussInfoKeyEnum.MODELDETAIL_VERSION.getCode(), modelDetailInfoV2.getVersion()));
        modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, BussInfoKeyEnum.MODELDETAIL_MODELFILELINKS.getCode(), modelDetailInfoV2.getModelFileLinks()));
        modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, BussInfoKeyEnum.MODELDETAIL_MODELFILEHASECODE.getCode(), modelDetailInfoV2.getModelFileHashCodes()));
        modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, BussInfoKeyEnum.MODELDETAIL_MODELFILENAMES.getCode(), modelDetailInfoV2.getModelFileNames()));

        //dynamic col
        for (String key : modelDetailInfoV2.getExtDetailInfo().keySet()) {
            modelDetailInfoKVDOList.add(buildDOByKey(modelDetailInfoV2, key, modelDetailInfoV2.getExtDetailInfo().get(key)));
        }
        return modelDetailInfoKVDOList;
    }

    /**
     *
     * @param modelDetailInfoKVDOList
     * @return
     */
    public static ModelDetailInfoV2 unpackColFamilyModelDetail(List<ModelDetailInfoKVDO> modelDetailInfoKVDOList) {
        ModelDetailInfoV2 modelDetailInfoV2 = new ModelDetailInfoV2();
        Map<String, String> extInfo = new HashMap<>();
        modelDetailInfoV2.setExtDetailInfo(extInfo);
        for (ModelDetailInfoKVDO modelDetailInfoKVDO : modelDetailInfoKVDOList) {
            if (StringUtil.equals(modelDetailInfoKVDO.getColName(), BussInfoKeyEnum.MODELID.getCode())) {
                modelDetailInfoV2.setModelId(modelDetailInfoKVDO.getValue());
            }
            if (StringUtil.equals(modelDetailInfoKVDO.getColName(), BussInfoKeyEnum.MODELDETAIL_VERSION.getCode())) {
                modelDetailInfoV2.setVersion(modelDetailInfoKVDO.getValue());
            }
            if (StringUtil.equals(modelDetailInfoKVDO.getColName(), BussInfoKeyEnum.MODELDETAIL_MODELFILELINKS.getCode()))
            {
                modelDetailInfoV2.setModelFileLinks(modelDetailInfoKVDO.getValue());
            }
            if (StringUtil.equals(modelDetailInfoKVDO.getColName(), BussInfoKeyEnum.MODELDETAIL_MODELFILEHASECODE.getCode()))
            {
                modelDetailInfoV2.setModelFileHashCodes(modelDetailInfoKVDO.getValue());
            }
            if (StringUtil.equals(modelDetailInfoKVDO.getColName(), BussInfoKeyEnum.MODELDETAIL_MODELFILENAMES.getCode()))
            {
                modelDetailInfoV2.setModelFileNames(modelDetailInfoKVDO.getValue());
            }
            extInfo.put(modelDetailInfoKVDO.getColName(),modelDetailInfoKVDO.getValue());
        }
        return modelDetailInfoV2;
    }


    /**
     *
     * @param modelDetailInfoV2
     * @param key
     * @param val
     * @return
     */
    private static ModelDetailInfoKVDO buildDOByKey(ModelDetailInfoV2 modelDetailInfoV2, String key, String val) {
        ModelDetailInfoKVDO modelDetailInfoKVDO = new ModelDetailInfoKVDO();
        modelDetailInfoKVDO.setGroupKey(buldGroupKey(modelDetailInfoV2));
        modelDetailInfoKVDO.setMainKey(buildKey(modelDetailInfoV2, key));
        modelDetailInfoKVDO.setColName(key);
        modelDetailInfoKVDO.setValue(val);
        return modelDetailInfoKVDO;
    }




}