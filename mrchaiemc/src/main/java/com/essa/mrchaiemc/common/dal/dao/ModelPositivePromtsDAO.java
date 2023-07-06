package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelPositivePromtsDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelPositivePromtsDAO extends JpaRepository<ModelPositivePromtsDO,String> {
    ModelPositivePromtsDO findByModelIdAndVersion(String modelId,String version);
    List<ModelPositivePromtsDO> findByModelId(String modelId);
}
