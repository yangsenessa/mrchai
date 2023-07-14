package com.essa.mrchaiemc.biz.models.domains;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用业务返回
 */
public class BussResponse {

    private String resCode;

    private Map<String ,String> resExtInfo = new HashMap<>();

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
}
