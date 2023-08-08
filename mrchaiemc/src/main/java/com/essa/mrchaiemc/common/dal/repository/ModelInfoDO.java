package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "model_info_base")
public class ModelInfoDO implements Serializable {

    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;

    @Column(name = "owner_custid", nullable = false, length = 50)
    private String ownerCustId;

    @Column(name = "manner_userid", nullable = true, length = 50)
    private String mannerUserId;

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

    @Column(name = "model_stat", nullable = true,length = 10)
    private String modelStat;

    @Column(name = "gmt_create", nullable = true,length = 10)
    private Long gmtCreate;

    @Column(name = "gmt_modify", nullable = true,length = 10)
    private Long gmtModify;

    @Column(name = "gmt_review", nullable = true,length = 10)
    private Long gmtReview;



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

    /**
     * Getter method for property <tt>ownerCustId</tt>.
     *
     * @return property value of ownerCustId
     */
    public String getOwnerCustId() {
        return ownerCustId;
    }

    /**
     * Setter method for property <tt>ownerCustId</tt>.
     *
     * @param ownerCustId value to be assigned to property ownerCustId
     */
    public void setOwnerCustId(String ownerCustId) {
        this.ownerCustId = ownerCustId;
    }

    /**
     * Getter method for property <tt>mannerUserId</tt>.
     *
     * @return property value of mannerUserId
     */
    public String getMannerUserId() {
        return mannerUserId;
    }

    /**
     * Setter method for property <tt>mannerUserId</tt>.
     *
     * @param mannerUserId value to be assigned to property mannerUserId
     */
    public void setMannerUserId(String mannerUserId) {
        this.mannerUserId = mannerUserId;
    }

    /**
     * Getter method for property <tt>modelStat</tt>.
     *
     * @return property value of modelStat
     */
    public String getModelStat() {
        return modelStat;
    }

    /**
     * Setter method for property <tt>modelStat</tt>.
     *
     * @param modelStat value to be assigned to property modelStat
     */
    public void setModelStat(String modelStat) {
        this.modelStat = modelStat;
    }


    /**
     * Getter method for property <tt>gmtCreate</tt>.
     *
     * @return property value of gmtCreate
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     *
     * @return property value of gmtModify
     */
    public Long getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     *
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * Getter method for property <tt>gmtReview</tt>.
     *
     * @return property value of gmtReview
     */
    public Long getGmtReview() {
        return gmtReview;
    }

    /**
     * Setter method for property <tt>gmtReview</tt>.
     *
     * @param gmtReview value to be assigned to property gmtReview
     */
    public void setGmtReview(Long gmtReview) {
        this.gmtReview = gmtReview;
    }
}
