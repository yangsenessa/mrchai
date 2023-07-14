package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.MinIOFileInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinIOFileInfoDAO  extends JpaRepository<MinIOFileInfoDO, String> {
    MinIOFileInfoDO findByFileId(String fileId);
}