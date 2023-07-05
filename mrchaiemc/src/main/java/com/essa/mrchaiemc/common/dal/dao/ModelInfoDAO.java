package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelInfoDAO extends JpaRepository<ModelInfoDO, String> {

    ModelInfoDO findByModelId(String modelID);

}
