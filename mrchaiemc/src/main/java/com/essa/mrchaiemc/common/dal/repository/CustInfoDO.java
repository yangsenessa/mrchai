package com.essa.mrchaiemc.common.dal.repository;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cfg_custinfo",indexes = {@Index(name = "cust_id_idx",columnList = "custid", unique = true),
        @Index(name = "login_id_idx",columnList = "loginid", unique = true)})
public class CustInfoDO implements Serializable {

    private static final long serialVersionUID = -8793347041807273011L;

    @Id
    @Column(name = "custid", nullable = false, length = 128)
    private String custId;

    @Column(name = "nickname", nullable = true, length = 255)
    private String nickName;

    @Column(name = "profile", nullable = true, length =2048)
    private String profile;

    @Column(name = "grandlevel", nullable = true, length =10)
    private int grandLevel;

    @Column(name = "email", nullable = true, length =128)
    private String email;

    @Column(name = "mobilephoneno", nullable = true, length =128)
    private String mobilePhoneNo;

    @Column(name = "loginid", nullable = false, length =128)
    private String loginId;

    @Column(name = "user_status", nullable = true, length = 1024)
    private String userStatus;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getGrandLevel() {
        return grandLevel;
    }

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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
