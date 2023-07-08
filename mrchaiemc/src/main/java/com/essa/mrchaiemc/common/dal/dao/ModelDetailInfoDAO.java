package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelDetailInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelDetailInfoDAO extends JpaRepository<ModelDetailInfoDO, String> {
    ModelDetailInfoDO findByModelId(String modelId);
}
