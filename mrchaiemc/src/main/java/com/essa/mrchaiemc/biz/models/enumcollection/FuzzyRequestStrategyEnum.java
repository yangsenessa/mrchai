/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.models.enumcollection;

/**
 * @author senyang
 * @version : FuzzyRequestStrategyEnum.java, v 0.1 2023年08月13日 11:56 AM senyang Exp $
 */
public enum FuzzyRequestStrategyEnum {
    SEARCH_BY_MODELSTAT("SEARCH_BY_MODELSTAT","SEARCH_BY_MODELSTAT"),
    SEARCH_BY_TITILE("SEARCH_BY_TITILE","SEARCH_BY_TITILE"),
    SEARCH_BY_CATEGORY("SEARCH_BY_CATTEGORY","SEARCH_BY_CATTEGORY"),
    SEARCH_BY_TAG("SEARCH_BY_TAG","SEARCH_BY_TAG"),
    SEARCH_BY_FUZZYMIXTRUE("SEARCH_BY_FUZZYMIXTRUE","SEARCH_BY_FUZZYMIXTRUE");


    private String code;

    private String action;

    FuzzyRequestStrategyEnum(String code,String action){
        this.code = code;
        this.action = action;
    }
}