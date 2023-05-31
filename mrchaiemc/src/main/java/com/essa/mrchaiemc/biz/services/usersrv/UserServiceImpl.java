package com.essa.mrchaiemc.biz.services.usersrv;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.exceptions.UserNeedRegistException;
import com.essa.mrchaiemc.common.dal.dao.CustIdentityInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.CustIdentityInfoDO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService{

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private CustIdentityInfoDAO custIdentityInfoDAO;

    @Override
    public void checkUserValid(BussRequest request, BussResponse response) {
        String userId = request.getUserContext().getUserId();
        String loginType = request.getBussExtInfo().get(BussInfoKeyEnum.LOGINTYPE.getCode());
        String token = request.getBussExtInfo().get(BussInfoKeyEnum.AUTHTOKEN.getCode());
        CustIdentityInfoDO custIdentityInfo =  custIdentityInfoDAO.findByCustIdAndIdentiType(userId,loginType);
        if(StringUtil.equals(custIdentityInfo.getAuthCode(),token)){
            response.setResCode(ResultCode.SUCCESS.name());
        } else{
            response.setResCode(ResultCode.AUTHERR.name());
        }
    }

    @Override
    public void doUserLogIn(BussRequest request, BussResponse response) {


    }

    @Override
    public void doUserRegister(BussRequest request, BussResponse response) {

    }
}
