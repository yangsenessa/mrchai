package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelCoverDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelCoverDAO extends JpaRepository<ModelCoverDO, String> {
    ModelCoverDO findByModelId(String modelID);
}
