package com.essa.mrchaiemc.common.dal.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "model_cover")
public class ModelCoverDO implements Serializable {
    /** modelId*/
    @Id
    @Column(name = "model_id", nullable = false, length = 128)
    private String modelId;


    @Column(name = "cover_img_list", nullable = true, length = 5120)
    private String coverImgList;


    @Column(name = "cover_video_list", nullable = true, length = 5120)
    private String coverVideoList;

    @Column(name = "tips", nullable = true, length = 5120)
    private String tips;


    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getCoverImgList() {
        return coverImgList;
    }

    public void setCoverImgList(String coverImgList) {
        this.coverImgList = coverImgList;
    }

    public String getCoverVideoList() {
        return coverVideoList;
    }

    public void setCoverVideoList(String coverVideoList) {
        this.coverVideoList = coverVideoList;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

}
