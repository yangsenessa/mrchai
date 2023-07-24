package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface ModelInfoDAO extends JpaRepository<ModelInfoDO, String>, JpaSpecificationExecutor<ModelInfoDO> {

    ModelInfoDO findByModelId(String modelID);

    Page<ModelInfoDO> findByCateGory1(String cateGory1, Pageable pageable);


    @Query(value="select count(mb.model_id) from model_info_base mb", nativeQuery = true)
    int countValidModel();

}
