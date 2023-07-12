package com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels;

import java.util.List;

public class ModelCover {

    /** img list 模型封面-图片组*/
    private List<String> coverImgList;
    /** video list 模型封面-视频组-预留*/
    private List<String> coverVideoList;
    /** tips 模型检索特征词，推荐算法预留*/
    private List<String> tips;

    public List<String> getCoverImgList() {
        return coverImgList;
    }

    public void setCoverImgList(List<String> coverImgList) {
        this.coverImgList = coverImgList;
    }

    public List<String> getCoverVideoList() {
        return coverVideoList;
    }

    public void setCoverVideoList(List<String> coverVideoList) {
        this.coverVideoList = coverVideoList;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }
}
