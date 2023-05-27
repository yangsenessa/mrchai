package com.essa.mrchaiemc.biz.models.enumcollection;

public enum ActionTypeEnum {

    /** user unlogin*/
    USER_UNLOGIN("USER_UNLOGIN", "USER_UNLOGIN"),
    USER_REGIST("USER_REGIST", "USER_REGIST"),
    IMG_PROJ("IMG_PROJ","IMG_PROJ"),
    SOUND_PROJ("SOUND_PROJ","SOUND_PROJ"),
    VIDEO_PROJ("VIDEO_PROJ","VIDEO_PROJ"),
    ASSET_CHOOSE("ASSET_CHOOSE","ASSET_CHOOSE"),
    ASSET_PUB("ASSET_PUB","ASSET_PUB");

    /**
     * actionCode
     */
    private String actionCode;
    /**
     * actionName
     */
    private String actionName;

    ActionTypeEnum(String actionCode,String actionName){
        this.actionCode = actionCode;
        this.actionName = actionName;
    }
}
