package com.essa.mrchaiemc.biz.services.usersrv;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.CustIdentiTypeEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.exceptions.DbOprException;
import com.essa.mrchaiemc.biz.models.exceptions.UserNeedRegistException;
import com.essa.mrchaiemc.common.dal.dao.CustIdentityInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.CustInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.CustIdentityInfoDO;
import com.essa.mrchaiemc.common.dal.repository.CustInfoDO;
import com.essa.mrchaiemc.common.util.DateUtil;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService{

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CustIdentityInfoDAO custIdentityInfoDAO;

    @Autowired
    private CustInfoDAO  custInfoDAO;

    @Override
    public void checkUserValid(BussRequest request, BussResponse response) {
        String userId = request.getUserContext().getUserId();
        String loginType = request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode());
        String token = request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode());
        if(StringUtil.isEmpty(loginType) || StringUtil.isEmpty(userId)){
            LoggerUtil.errlog("loginType is null");
            response.setResCode(ResultCode.NEEDREGISTER.name());
            return;
        }
        int loginTypeCode = CustIdentiTypeEnum.getCustIdentiTypeCodeByMsg(loginType);

        CustIdentityInfoDO custIdentityInfo =  custIdentityInfoDAO.findByCustIdAndIdentiType(userId,loginTypeCode);
        if(custIdentityInfo != null && StringUtil.equals(custIdentityInfo.getAuthCode(),token)){
            response.setResCode(ResultCode.SUCCESS.name());
        } else if(custIdentityInfo == null) {
            response.setResCode(ResultCode.NEEDREGISTER.name());
        } else{
            response.setResCode(ResultCode.AUTHERR.name());
        }
    }

    @Override
    public void doUserLogIn(BussRequest request, BussResponse response) {



    }

    @Override
    public String doUserRegister(BussRequest request, BussResponse response) {
        CustInfoDO custInfoDO = new CustInfoDO();
        this.constractCustInfoDO(request, custInfoDO);
        CustInfoDO custInfoDB = custInfoDAO.findByLoginId(custInfoDO.getLoginId());
        if(custInfoDB != null){
            response.setResCode(ResultCode.DUPLOGINID.name());
            return null;
        }
        custInfoDAO.save(custInfoDO);
        //获取custId并写入上下文
        custInfoDB = custInfoDAO.findByLoginId(custInfoDO.getLoginId());
        if(custInfoDB == null){
            LoggerUtil.errlog("DB operator err");
            throw new DbOprException();
        }
        return custInfoDB.getCustId();
    }


    private void constractCustInfoDO(BussRequest request, CustInfoDO custInfoDO){
        if(custInfoDO == null){
            custInfoDO = new CustInfoDO();
        }
        custInfoDO.setLoginId(request.getUserContext().getLoginId());
        custInfoDO.setNickName(request.getUserContext().getNickName());
        custInfoDO.setEmail(request.getUserContext().getEmail());
        custInfoDO.setProfile(request.getUserContext().getProfile());
        custInfoDO.setMobilePhoneNo(request.getUserContext().getMobilePhoneNo());
        this.generCustId(custInfoDO);
    }

    private void generCustId(CustInfoDO custInfoDO){
        String hasecode =  String.valueOf(DateUtil.getGmtDateTime()+ custInfoDO.toString().hashCode());
        custInfoDO.setCustId(hasecode);
    }
}
