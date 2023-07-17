package com.essa.mrchaiemc.common.util;

import com.essa.mrchaiemc.biz.models.enumcollection.ActionTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class ActionEnumMappingUtil {

    private static Map<String, ActionTypeEnum> string2ActiontypeEnum = new HashMap<>();

    static {
        // AssetMannerBussContorller
        string2ActiontypeEnum.put("ASSETUPLOAD", ActionTypeEnum.ASSET_PUB);

        //CustomerBussContorller
        string2ActiontypeEnum.put("APPLYREGISTER", ActionTypeEnum.USER_REGIST);
        string2ActiontypeEnum.put("RELATOEWALLET", ActionTypeEnum.USER_REGIST);



        //ModelMannerBussConstorller
        string2ActiontypeEnum.put("MODELUPLOAD", ActionTypeEnum.MODEL_UPLOAD);
        string2ActiontypeEnum.put("MODELDOWNLOAD", ActionTypeEnum.MODEL_DOWNLOAD);
    }


    public static ActionTypeEnum getActionTypeEnumFromActionCode(String value) {
        return string2ActiontypeEnum.get(value);
    }
}
