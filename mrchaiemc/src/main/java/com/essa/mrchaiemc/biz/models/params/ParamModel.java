package com.essa.mrchaiemc.biz.models.params;

import java.util.Map;
import java.util.Set;

public class ParamModel {
    /**
     * prompts Set
     */
    private Set<String> promts;

    /**
     * negative promts
     */
    private Set<String> negativePromts;

    /**
     * commonParams
     */
    private Map<String, String> commonParams;

    /**
     * paramLink
     */
    private String paramLink;




    public Set<String> getNegativePromts() {
        return negativePromts;
    }

    public void setNegativePromts(Set<String> negativePromts) {
        this.negativePromts = negativePromts;
    }

    public Set<String> getPromts() {
        return promts;
    }

    public void setPromts(Set<String> promts) {
        this.promts = promts;
    }

    public Map<String, String> getCommonParams() {
        return commonParams;
    }

    public void setCommonParams(Map<String, String> commonParams) {
        this.commonParams = commonParams;
    }

    public String getParamLink() {
        return paramLink;
    }

    public void setParamLink(String paramLink) {
        this.paramLink = paramLink;
    }
}
