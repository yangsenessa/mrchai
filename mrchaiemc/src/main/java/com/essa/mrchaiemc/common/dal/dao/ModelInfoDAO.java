package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelInfoDAO extends JpaRepository<ModelInfoDO, String> {

    ModelInfoDO findByModelId(String modelID);

    List<ModelInfoDO> findByCustIdAndModelId(String custId, String ModelId);

}
