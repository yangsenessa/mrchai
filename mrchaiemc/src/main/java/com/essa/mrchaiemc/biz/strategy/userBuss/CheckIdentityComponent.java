package com.essa.mrchaiemc.biz.strategy.userBuss;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CHECKIDENTITY")
public class CheckIdentityComponent implements BussComponent {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        userService.checkUserValid(request, response);
    }

    /**
     * preProcess
     * @param request
     * @param response
     * @return
     */
    @Override
    public boolean preProcess(BussRequest request, BussResponse response){
        if(request == null || request.getUserContext() == null){
            LoggerUtil.errlog("request or request.getUserContext() is null");
            return false;
        }
        if(StringUtil.equals("PUBLIC", request.getUserContext().getUserId())){
            return true;
        }
        if(request.getBussExtInfo().containsKey(BussInfoKeyEnum.LOGINTYPE.getCode())
            && request.getBussExtInfo().containsKey(BussInfoKeyEnum.AUTHTOKEN.getCode())){
            return true;
        }
        //用户注册，需要检查用户现有的注册信息
        if(StringUtil.equals("APPLYREGISTER",request.getBussContext().getActionCode())){
            return true;
        }
        if( StringUtil.isNotEmpty(request.getUserContext().getUserId()) ){
            return true;
        }
        return false;

    }


    @Override
    public String getActionCode() {
        return "CHECKIDENTITY";
    }
}
