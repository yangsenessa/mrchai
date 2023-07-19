/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.dao.v2;

import com.essa.mrchaiemc.common.dal.repository.v2.ModelDetailInfoKVDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author senyang
 * @version : ModelDetailInfoKVDAO.java, v 0.1 2023年07月19日 11:53 PM senyang Exp $
 */
public interface ModelDetailInfoKVDAO extends JpaRepository<ModelDetailInfoKVDO,String> {
    List<ModelDetailInfoKVDO> findByGroupKey(String groupKey);

    ModelDetailInfoKVDO findByMainKey(String key);
}