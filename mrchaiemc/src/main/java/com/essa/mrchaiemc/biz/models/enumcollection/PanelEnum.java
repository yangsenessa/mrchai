package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * 前端访问后端时的工作区域id
 * @Author: Frank.yang
 */
public enum PanelEnum {

    MAIN_MENU("MAIN_MENU","MAIN_MENU"),
    ASSET_GRID("ASSET_GRID","ASSET_GRID"),
    WORK_STDIO("WORK_STDIO","WORK_STDIO"),
    TOOL_BAR("TOOL_BAR","TOOL_BAR");

    private String code;

    private String msg;

    PanelEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
