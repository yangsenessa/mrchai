package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "model_info_base",indexes = {@Index(name = "model_id_cust_idx",columnList = "cust_id,model_id", unique = true)})
public class ModelInfoDO implements Serializable {

    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    @Column(name = "cust_id", nullable = false, length = 128)
    private String custId;

    /** modelName*/
    @Column(name = "model_name", nullable = true, length = 1024)
    private String modelName;

    /** modelSubName*/
    @Column(name = "model_sub_name", nullable = true, length = 1024)
    private String modelSubName;


    /** modelkey*/
    @Column(name = "model_key", nullable = true, length = 512)
    private String modelKey;

    /** cateGory1*/
    @Column(name = "category_1", nullable = true, length = 50)
    private String cateGory1;

    /** cateGory2*/
    @Column(name = "category_2", nullable = true, length = 50)
    private String cateGory2;

    /** cateGory3*/
    @Column(name = "category_3", nullable = true, length = 50)
    private String cateGory3;

    /** modelCover*/
    @Column(name = "cover_imgs", nullable = true, length = 5120)
    private String coverImgs;

    @Column(name = "cover_videos", nullable = true, length = 5120)
    private String coverVideos;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelSubName() {
        return modelSubName;
    }

    public void setModelSubName(String modelSubName) {
        this.modelSubName = modelSubName;
    }

    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    public String getCateGory1() {
        return cateGory1;
    }

    public void setCateGory1(String cateGory1) {
        this.cateGory1 = cateGory1;
    }

    public String getCateGory2() {
        return cateGory2;
    }

    public void setCateGory2(String cateGory2) {
        this.cateGory2 = cateGory2;
    }

    public String getCateGory3() {
        return cateGory3;
    }

    public void setCateGory3(String cateGory3) {
        this.cateGory3 = cateGory3;
    }

    public String getCoverImgs() {
        return coverImgs;
    }

    public void setCoverImgs(String coverImgs) {
        this.coverImgs = coverImgs;
    }

    public String getCoverVideos() {
        return coverVideos;
    }

    public void setCoverVideos(String coverVideos) {
        this.coverVideos = coverVideos;
    }
}
