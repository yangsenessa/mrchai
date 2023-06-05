package com.essa.mrchaiemc.biz.models;

public class UserContext {
    private String userId;

    private String loginId;

    private String nickName;

    private String profile;

    private int grandLevel;

    private String email;

    private String mobilePhoneNo;


    private boolean hasLogin;

    private String currEmcChainSeq;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public String getCurrEmcChainSeq() {
        return currEmcChainSeq;
    }

    public void setCurrEmcChainSeq(String currEmcChainSeq) {
        this.currEmcChainSeq = currEmcChainSeq;
    }

    /**
     * Getter method for property <tt>loginId</tt>.
     *
     * @return property value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Setter method for property <tt>loginId</tt>.
     *
     * @param loginId value to be assigned to property loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Getter method for property <tt>nickName</tt>.
     *
     * @return property value of nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Setter method for property <tt>nickName</tt>.
     *
     * @param nickName value to be assigned to property nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Getter method for property <tt>profile</tt>.
     *
     * @return property value of profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Setter method for property <tt>profile</tt>.
     *
     * @param profile value to be assigned to property profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Getter method for property <tt>grandLevel</tt>.
     *
     * @return property value of grandLevel
     */
    public int getGrandLevel() {
        return grandLevel;
    }

    /**
     * Setter method for property <tt>grandLevel</tt>.
     *
     * @param grandLevel value to be assigned to property grandLevel
     */
    public void setGrandLevel(int grandLevel) {
        this.grandLevel = grandLevel;
    }

    /**
     * Getter method for property <tt>email</tt>.
     *
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     *
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for property <tt>mobilePhoneNo</tt>.
     *
     * @return property value of mobilePhoneNo
     */
    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    /**
     * Setter method for property <tt>mobilePhoneNo</tt>.
     *
     * @param mobilePhoneNo value to be assigned to property mobilePhoneNo
     */
    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }
}
