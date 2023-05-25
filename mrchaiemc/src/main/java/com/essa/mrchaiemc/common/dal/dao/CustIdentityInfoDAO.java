/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.CustIdentityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author senyang
 * @version : CustIdentityInfoDAO.java, v 0.1 2023年05月25日 9:07 PM senyang Exp $
 */
public interface CustIdentityInfoDAO extends JpaRepository<CustIdentityInfo, String> {
}