/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.CustAcctBaseDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author senyang
 * @version : CustAcctBaseDAO.java, v 0.1 2023年07月17日 1:45 PM senyang Exp $
 */
public interface CustAcctBaseDAO extends JpaRepository<CustAcctBaseDO,String> {
    /**
     * load by custID
     * @param custId
     * @return
     */
    CustAcctBaseDO findByCustId(String custId);
}