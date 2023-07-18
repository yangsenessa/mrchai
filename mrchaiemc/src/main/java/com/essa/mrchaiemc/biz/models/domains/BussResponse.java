package com.essa.mrchaiemc.biz.models.domains;

import com.alibaba.fastjson.JSONArray;
import com.essa.mrchaiemc.biz.models.domains.bussiness.aimodels.ModelInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用业务返回
 */
public class BussResponse {

    private String resCode;

    private Map<String ,String> resExtInfo = new HashMap<>();

    private List<ModelInfo> modelListArray = new ArrayList<ModelInfo>();

    private long totalNum;

    public String getResCode() {
        return resCode;
    }
    private HttpServletResponse httpServletResponse;

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public Map<String, String> getResExtInfo() {
        return resExtInfo;
    }

    public void setResExtInfo(Map<String, String> resExtInfo) {
        this.resExtInfo = resExtInfo;
    }

    /**
     * Getter method for property <tt>httpServletResponse</tt>.
     *
     * @return property value of httpServletResponse
     */
    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    /**
     * Setter method for property <tt>httpServletResponse</tt>.
     *
     * @param httpServletResponse value to be assigned to property httpServletResponse
     */
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    /**
     * Getter method for property <tt>modelListArray</tt>.
     *
     * @return property value of modelListArray
     */
    public List<ModelInfo> getModelListArray() {
        return modelListArray;
    }

    /**
     * Setter method for property <tt>modelListArray</tt>.
     *
     * @param modelListArray value to be assigned to property modelListArray
     */
    public void setModelListArray(List<ModelInfo> modelListArray) {
        this.modelListArray = modelListArray;
    }

    /**
     * Getter method for property <tt>totalNum</tt>.
     *
     * @return property value of totalNum
     */
    public long getTotalNum() {
        return totalNum;
    }

    /**
     * Setter method for property <tt>totalNum</tt>.
     *
     * @param totalNum value to be assigned to property totalNum
     */
    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }
}
