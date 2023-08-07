package com.essa.mrchaiemc.biz.services.usersrv;

import cn.minsin.core.tools.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.OperatorLogs;
import com.essa.mrchaiemc.biz.models.enumcollection.*;
import com.essa.mrchaiemc.biz.models.exceptions.DbOprException;
import com.essa.mrchaiemc.common.dal.dao.CustAcctBaseDAO;
import com.essa.mrchaiemc.common.dal.dao.CustIdentityInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.CustInfoDAO;
import com.essa.mrchaiemc.common.dal.dao.OperatorLogsDAO;
import com.essa.mrchaiemc.common.dal.repository.CustAcctBaseDO;
import com.essa.mrchaiemc.common.dal.repository.CustIdentityInfoDO;
import com.essa.mrchaiemc.common.dal.repository.CustInfoDO;
import com.essa.mrchaiemc.common.dal.repository.OperatorLogsDO;
import com.essa.mrchaiemc.common.util.DateUtil;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CustIdentityInfoDAO custIdentityInfoDAO;

    @Autowired
    private CustInfoDAO custInfoDAO;

    @Autowired
    private OperatorLogsDAO operatorLogsDAO;

    @Autowired
    private CustAcctBaseDAO custAcctBaseDAO;

    @Override
    public void checkUserValid(BussRequest request, BussResponse response) {
        String loginId = request.getUserContext().getLoginId();
        if(StringUtil.equals("PUBLIC", loginId)){
            this.dealAsPublicCust(request,response);
            return;
        }
        String loginType = request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode());
        String token = request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode());
        if (StringUtil.isEmpty(loginType) || StringUtil.isEmpty(loginId)) {
            LoggerUtil.errlog("loginType is null");
            response.setResCode(ResultCode.NEEDREGISTER.name());
            return;
        }
        int loginTypeCode = CustIdentiTypeEnum.getCustIdentiTypeCodeByMsg(loginType);


        CustInfoDO custInfoDO = custInfoDAO.findByLoginId(loginId);
        if(custInfoDO == null){
            LoggerUtil.errlog("None cust info");
            response.setResCode(ResultCode.NEEDREGISTER.name());
            return;
        }
        CustIdentityInfoDO custIdentityInfo =  custIdentityInfoDAO.findByCustIdAndIdentiType(custInfoDO.getCustId(),loginTypeCode);
        if(custIdentityInfo != null && StringUtil.equals(custIdentityInfo.getAuthCode(),token)){
            response.setResExtInfo(new HashMap<>());
            response.getResExtInfo().put(BussInfoKeyEnum.CUSTID.getCode(),custInfoDO.getCustId() );
            response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_MOBILEPHONE.getCode(), custInfoDO.getMobilePhoneNo());
            response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_LOGINID.getCode(), custInfoDO.getLoginId());
            response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_EMAIL.getCode(), custInfoDO.getEmail());
            response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_NICKNAME.getCode(), custInfoDO.getNickName());
            response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_CUST_PRINCIPLE.getCode(), custInfoDO.getProfile());
            response.setResCode(ResultCode.SUCCESS.name());
        } else if (custIdentityInfo == null) {
            response.setResCode(ResultCode.NEEDREGISTER.name());
        } else {
            response.setResCode(ResultCode.AUTHERR.name());
        }
    }

    private void dealAsPublicCust(BussRequest request, BussResponse response){
        request.getUserContext().setHasLogin(true);
        request.getUserContext().setNickName("SUPER");
        //request.getUserContext().setGrandLevel(8);
        request.getUserContext().setUserStatus(UserStatusEnum.NORMAL);
        response.setResCode(ResultCode.SUCCESS.name());
    }


    @Override
    public void doUserLogIn(BussRequest request, BussResponse response) {


    }

    @Override
    public void dealUserAcctOpen(BussRequest request, BussResponse response) {
        if(request.getUserContext() == null || StringUtil.isEmpty(request.getUserContext().getUserId())){
            LoggerUtil.errlog("CustId info is null");
            response.setResCode(ResultCode.INVAILDPARAMS.name());
        }
        CustAcctBaseDO custAcctBaseDO = new CustAcctBaseDO();
        custAcctBaseDO.setCustId(request.getUserContext().getUserId());
        custAcctBaseDO.setTokenType("EMC_IC");
        custAcctBaseDO.setTokenVal(request.getBussExtInfo().get(BussInfoKeyEnum.WALLETTOKEN.getCode()));
        custAcctBaseDAO.save(custAcctBaseDO);
        response.setResCode(ResultCode.SUCCESS.name());

    }

    @Override
    public String doUserRegister(BussRequest request, BussResponse response) {
        CustInfoDO custInfoDO = new CustInfoDO();
        this.constractCustInfoDO(request, custInfoDO);
        CustInfoDO custInfoDB = custInfoDAO.findByLoginId(custInfoDO.getLoginId());
        if (custInfoDB != null) {
            response.setResCode(ResultCode.DUPLOGINID.name());
            return custInfoDB.getCustId();
        }
        custInfoDO.setUserStatus(UserStatusEnum.UN_AUTHTOKEN.getCode());
        custInfoDAO.save(custInfoDO);
        //获取custId并写入上下文
        custInfoDB = custInfoDAO.findByLoginId(custInfoDO.getLoginId());
        if (custInfoDB == null) {
            LoggerUtil.errlog("DB operator err");
            throw new DbOprException();
        }
        response.setResExtInfo(new HashMap<>());
        response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_NICKNAME.getCode(),custInfoDB.getNickName());
        response.getResExtInfo().put(BussInfoKeyEnum.APPLREGINFO_LOGINID.getCode(),custInfoDB.getLoginId());

        return custInfoDB.getCustId();
    }

    @Override
    public void fetchUserInfo(BussRequest request, BussResponse response) {
        try {
            Optional<CustInfoDO> custInfoDOOpt = custInfoDAO.findById(request.getUserContext().getUserId());
            if (custInfoDOOpt == null || custInfoDOOpt.isEmpty()) {
                LoggerUtil.errlog("cfg_custinfo query fail");
                throw new DbOprException();
            }

            CustInfoDO custInfoDO = custInfoDOOpt.get();
            if (StringUtil.equals(custInfoDO.getUserStatus(), UserStatusEnum.FREEZE.getCode())) {
                response.setResCode(ResultCode.INVALIDUSER.name());
            }
            buildUserContext(request, custInfoDO);
            response.setResCode(ResultCode.SUCCESS.name());
        } catch (Exception e) {
            LoggerUtil.errlog(e, "System exception");
            response.setResCode(ResultCode.SYSFAIL.name());
        }

    }

    @Override
    public void setOrChangeAuthToken(BussRequest request, BussResponse response) {
        CustIdentityInfoDO custIdentityInfoDO = new CustIdentityInfoDO();
        custIdentityInfoDO.setCustId(request.getUserContext().getUserId());
        String  authToken = request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode());
        String  loginType = request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode());
        custIdentityInfoDO.setCustIdentyType(request.getUserContext().getUserId()+"-"+loginType);
        custIdentityInfoDO.setAuthCode(authToken);
        custIdentityInfoDO.setIdentiChannel("MAINAPP");
        custIdentityInfoDO.setIdentiType
                (CustIdentiTypeEnum.getCustIdentiTypeCodeByMsg(
                        request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode())));
        custIdentityInfoDO.setGmtTokenSet(DateUtil.getGmtDateTime());

        try {
            custIdentityInfoDAO.save(custIdentityInfoDO);
            if(StringUtil.equals(loginType, CustIdentiTypeEnum.PRINCIPLAL.getMsg())){
                //principleid can be considered as a information of a customer
                CustInfoDO custInfoDO = custInfoDAO.findByCustId(request.getUserContext().getUserId());
                custInfoDO.setProfile(authToken);
                custInfoDAO.save(custInfoDO);
            }

            response.setResCode(ResultCode.SUCCESS.name());
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }

    }

    @Override
    public void saveOperatorLog(BussRequest request, BussResponse response) {
        OperatorLogsDO operatorLogsDO = convertOperatorLogs2DO(request.getBussContext().getOperatorLogs());
        try {
            operatorLogsDAO.save(operatorLogsDO);
            response.setResCode(ResultCode.SUCCESS.name());
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
    }

    @Override
    public void addAuthorSuperToUser(BussRequest request,  BussResponse response) {
        CustInfoDO custInfoDO = new CustInfoDO();
        this.constractCustInfoDO(request,custInfoDO);
        custInfoDO.setGrandLevel(UserLevelEnum.SUPER.getCode());
        this.custInfoDAO.save(custInfoDO);

    }

    private void buildUserContext(BussRequest request, CustInfoDO custInfoDO) {
        request.getUserContext().setUserId(custInfoDO.getCustId());
        request.getUserContext().setEmail(custInfoDO.getEmail());
        request.getUserContext().setNickName(custInfoDO.getNickName());
     //   request.getUserContext().setProfile(JSONObject.parseObject(custInfoDO.getProfile(),new TypeReference<UserProfile>(){}) );
        request.getUserContext().setLoginId(custInfoDO.getLoginId());
        request.getUserContext().setGrandLevel(UserLevelEnum.getByCode(custInfoDO.getGrandLevel()));
        request.getUserContext().setMobilePhoneNo(custInfoDO.getMobilePhoneNo());

    }

    private void constractCustInfoDO(BussRequest request, CustInfoDO custInfoDO) {
        if (custInfoDO == null) {
            custInfoDO = new CustInfoDO();
        }
        custInfoDO.setLoginId(request.getUserContext().getLoginId());
        custInfoDO.setNickName(request.getUserContext().getNickName());
        custInfoDO.setEmail(request.getUserContext().getEmail());
        custInfoDO.setProfile(JSONObject.toJSONString(request.getUserContext().getProfile()));
        custInfoDO.setMobilePhoneNo(request.getUserContext().getMobilePhoneNo());
        this.generCustId(custInfoDO);
    }

    private void generCustId(CustInfoDO custInfoDO) {
        String hasecode = String.valueOf(DateUtil.getGmtDateTime() + custInfoDO.toString().hashCode());
        custInfoDO.setCustId(hasecode);
    }

    private OperatorLogsDO convertOperatorLogs2DO(OperatorLogs operatorLogs) {

        OperatorLogsDO operatorLogsDO = new OperatorLogsDO();

        if (operatorLogs == null) {
            return operatorLogsDO;
        }
        operatorLogsDO.setTraceId(operatorLogs.getTraceId());
        operatorLogsDO.setCustId(operatorLogs.getUserId());
        String actionCode = operatorLogs.getActionType() == null ? null : operatorLogs.getActionType().getActionCode();
        operatorLogsDO.setActionCode(actionCode);
        operatorLogsDO.setGmtCreate(operatorLogs.getGmtCreate());
        operatorLogsDO.setGmtFinish(operatorLogs.getGmtFinish());
        operatorLogsDO.setGmtAcceptPay(operatorLogs.getGmtAcceptPay());
        operatorLogsDO.setGmtFinishPay(operatorLogs.getGmtFinishPay());
        operatorLogsDO.setBizStatus(operatorLogs.getBizStatus());
        operatorLogsDO.setEmcTraceId(operatorLogs.getEmcTraceId());
        operatorLogsDO.setSettleStatus(operatorLogs.getSettleStatus());
        operatorLogsDO.setSettleDate(operatorLogs.getSettleDate());
        operatorLogsDO.setBizOrderId(operatorLogs.getBizOrderId());
        return operatorLogsDO;

    }
}
