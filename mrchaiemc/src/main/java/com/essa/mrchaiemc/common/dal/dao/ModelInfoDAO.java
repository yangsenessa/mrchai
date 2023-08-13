package com.essa.mrchaiemc.common.dal.dao;

import com.essa.mrchaiemc.common.dal.repository.ModelInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;



public interface ModelInfoDAO extends JpaRepository<ModelInfoDO, String>, JpaSpecificationExecutor<ModelInfoDO> {

    ModelInfoDO findByModelId(String modelID);

    ModelInfoDO findByModelIdAndOwnerCustId(String modelId, String custId);

    Page<ModelInfoDO> findByCateGory1(String cateGory1, Pageable pageable);

    Page<ModelInfoDO> findByOwnerCustId(String custId, Pageable pageable);

    Page<ModelInfoDO> findByModelStat(String modelStat,Pageable pageable);




    @Query(value="select count(mb.model_id) from model_info_base mb", nativeQuery = true)
    int countValidModel();

    //TEXT Search
    @Query("select m" +
            " from ModelInfoDO m where m.modelName like %?1% or m.modelSubName like %?1%")
    Page<ModelInfoDO> findModelByTitleLike(String text,Pageable pageable);

    @Query("select m" +
            " from ModelInfoDO m where m.cateGory1 like %?1%")
    Page<ModelInfoDO> findModelByTagLike(String text,Pageable pageable);

    @Query("select m" +
            " from ModelInfoDO m where m.cateGory2 like %?1%")
    Page<ModelInfoDO> findModelByCateGoryLike(String text,Pageable pageable);

    @Query("select m" +
            " from ModelInfoDO m where m.modelName like %?1% or m.modelSubName like %?1% " +
            "or  m.cateGory1 like %?2% or  m.cateGory2 like %?3%")
    Page<ModelInfoDO> findModelByTextFuzzy(String text1,String text2, String text3 ,Pageable pageable);


}
