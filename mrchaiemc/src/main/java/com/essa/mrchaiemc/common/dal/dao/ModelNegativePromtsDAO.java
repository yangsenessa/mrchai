package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelNegativePromtsDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelNegativePromtsDAO extends JpaRepository<ModelNegativePromtsDO,String> {
    List<ModelNegativePromtsDO> findByModelId(String modelId);
}
