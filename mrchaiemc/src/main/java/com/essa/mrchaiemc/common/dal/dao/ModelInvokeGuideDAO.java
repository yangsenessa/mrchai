package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInvokeGuideDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelInvokeGuideDAO extends JpaRepository<ModelInvokeGuideDO, String> {
    List<ModelInvokeGuideDO> findByModelId(String modelId);
}
