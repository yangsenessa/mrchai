package com.essa.mrchaiemc.biz.services.usersrv;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;

public interface ModelBizService {
    /**
     * 增加或修改模型基础信息
     * @param request
     * @param response
     */
    void addOrUpdateModelInfo(BussRequest request, BussResponse response);

    /**
     * 获取模型基础信息
     * @param request
     * @param response
     */
    ModelInfo fetchModelInfoBase(BussRequest request, BussResponse response);


    /**
     * 增加或修改模型详细信息
     * @param request
     * @param response
     */
    void addOrUpdateModelDetailInfo(BussRequest request, BussResponse response);

    /**
     * 增加或修改模型封面
     * @param request
     * @param response
     */
    void addOrUpdateModelCovers(BussRequest request, BussResponse response);

    /**
     * 增加或修改模型数据文件
     * @param request
     * @param response
     */
    void addOrUpdateModelFilesInfo(BussRequest request, BussResponse response);

    /**
     * 新增，修改模型详细信息
     * @param request
     * @param response
     */
    void modModelDetailInfo(BussRequest request, BussResponse response);
}
