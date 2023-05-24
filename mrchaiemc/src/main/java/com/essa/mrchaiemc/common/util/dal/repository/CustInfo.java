package com.essa.mrchaiemc.common.util.dal.repository;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cfg_custinfo")
public class CustInfo implements Serializable {

    private static final long serialVersionUID = -8793347041807273011L;

    @Id
    @Column(name = "custid", nullable = false, length = 15)
    private String custId;

    /**
     * @see com.essa.mrchaiemc.biz.models.enumcollection.CustIdentiTypeEnum
     */
    @Column(name = "identitype", nullable = true, length = 10)
    private int identiType;

    @Column(name = "nickname", nullable = true, length = 255)
    private String nickName;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public int getIdentiType() {
        return identiType;
    }

    public void setIdentiType(int identiType) {
        this.identiType = identiType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
