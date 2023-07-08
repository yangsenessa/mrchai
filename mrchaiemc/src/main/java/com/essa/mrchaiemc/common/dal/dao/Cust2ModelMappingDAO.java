package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.Cust2ModelMappingDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Cust2ModelMappingDAO extends JpaRepository<Cust2ModelMappingDO, String> {
    Cust2ModelMappingDO findByCustIdAndModelId(String custId, String modelId);

    List<Cust2ModelMappingDO> findByCustId(String custId);
}
