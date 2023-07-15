package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * 原本应该勇动态枚举的，但是就一个单应用，算了
 */
public enum ActionTypeEnum {

    /**
     * user unlogin
     */
    USER_UNLOGIN("USER_UNLOGIN", "USER_UNLOGIN"),
    /**
     * 用户注册
     */
    USER_REGIST("USER_REGIST", "USER_REGIST"),
    /**
     * 图片上传
     */
    IMG_PROJ("IMG_PROJ", "IMG_PROJ"),
    /**
     * 视频上传
     */
    VIDEO_PROJ("VIDEO_PROJ", "VIDEO_PROJ"),
    /**
     * 模型选择
     */
    ASSET_DOWNLOAD("ASSET_DOWNLOAD", "ASSET_DOWNLOAD"),
    /**
     * 模型发布
     */
    ASSET_PUB("ASSET_PUB", "ASSET_PUB");

    /**
     * actionCode
     */
    private String actionCode;
    /**
     * actionName
     */
    private String actionName;

    public String getActionCode() {
        return actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    ActionTypeEnum(String actionCode, String actionName) {
        this.actionCode = actionCode;
        this.actionName = actionName;
    }
}
