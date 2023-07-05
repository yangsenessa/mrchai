package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelParamsDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelParamsDAO extends JpaRepository<ModelParamsDO,String> {
    ModelParamsDO findByModelIdAndVersion();
}
