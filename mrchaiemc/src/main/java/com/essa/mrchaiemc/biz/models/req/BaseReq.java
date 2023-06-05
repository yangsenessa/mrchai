package com.essa.mrchaiemc.biz.models.req;

import java.util.Map;

public class BaseReq {



    protected String version;

    protected String language;

    protected String userProfile;

    private Map<String, String > bussData;

    /**
     * Getter method for property <tt>bussData</tt>.
     *
     * @return property value of bussData
     */
    public Map<String, String> getBussData() {
        return bussData;
    }

    /**
     * Setter method for property <tt>bussData</tt>.
     *
     * @param bussData value to be assigned to property bussData
     */
    public void setBussData(Map<String, String> bussData) {
        this.bussData = bussData;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }
}
