package com.essa.mrchaiemc.biz.models.params;

import java.util.Map;
import java.util.Set;

public class ParamModel {
    /**
     * prompts Set
     * 正向提示词
     */
    private Set<String> promts;

    /**
     * negative promts
     * 反向提示此
     */
    private Set<String> negativePromts;

    /**
     * commonParams
     * 通用参数：step,Sampler,Model,CFG scale,Seed,Clip skip
     */
    private Map<String, String> commonParams;

    /**
     * paramLink
     * 模型上传者git链接
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
