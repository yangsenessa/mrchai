package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelInfoDAO extends JpaRepository<ModelInfoDO, String> {

    ModelInfoDO findByModelId(String modelID);

    Page<ModelInfoDO> findByCateGory1(String cateGory1, Pageable pageable);

}
