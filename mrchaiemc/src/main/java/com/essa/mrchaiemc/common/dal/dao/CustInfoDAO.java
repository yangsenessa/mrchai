package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.CustInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustInfoDAO extends JpaRepository<CustInfoDO, String> {

    /**
     * 通过logInId获取custInfo
     * @param loginId
     * @return
     */
    CustInfoDO findByLoginId(String loginId);


}
