package com.essa.mrchaiemc.biz.models.enumcollection;

import cn.minsin.core.tools.StringUtil;

public enum CustIdentiTypeEnum {

    PASSWD(1,"PASSWD"),
    TWITTER(2,"TWITTER"),
    BUSSINFO(3,"BUSSINFO");//嵌入式能力供给


    private int code;

    private String msg;

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     *
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property <tt>msg</tt>.
     *
     * @param msg value to be assigned to property msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    CustIdentiTypeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据msg返回指定code
     * @param msg
     * @return
     */
    public static int getCustIdentiTypeCodeByMsg(String msg){
         for (CustIdentiTypeEnum enumItem: CustIdentiTypeEnum.values()){
             if(StringUtil.equals(msg,enumItem.getMsg())){
                 return enumItem.getCode();
             }
         }
         return -1;
    }

}
