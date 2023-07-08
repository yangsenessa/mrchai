package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelParamsDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelParamsDAO extends JpaRepository<ModelParamsDO,String> {
    ModelParamsDO findByModelIdAndVersion(String modelId,String version);
    ModelParamsDO findByModelId(String modelId);
}
