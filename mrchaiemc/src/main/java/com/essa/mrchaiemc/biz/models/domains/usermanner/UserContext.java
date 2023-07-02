package com.essa.mrchaiemc.biz.models.domains.usermanner;

import com.essa.mrchaiemc.biz.models.enumcollection.UserStatusEnum;

public class UserContext {

    /** userId - custId*/
    private String userId;

    /** loginId */
    private String loginId;

    /** loginName */
    private String loginName;

    /** nickName*/
    private String nickName;

    /** userProfile */
    private UserProfile profile;

    /** grandLevel*/
    private int grandLevel;

    /** email */
    private String email;

    /** mobilePhoneNo*/
    private String mobilePhoneNo;

    /** hasLogin*/
    private boolean hasLogin;

    /** userStatusEnum*/
    private UserStatusEnum userStatus;


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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatusEnum userStatus) {
        this.userStatus = userStatus;
    }
}
