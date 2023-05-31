package com.essa.mrchaiemc.biz.strategy.userBuss;

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
        userService.checkUserValid(request,response);
    }

    /**
     * preProcess
     * @param request
     * @param response
     * @return
     */
    private boolean preProcess(BussRequest request, BussResponse response){
        if(request == null || request.getUserContext() == null){
            LoggerUtil.errlog("request or request.getUserContext() is null");
            return false;
        }
        if(request.getBussExtInfo().containsKey(BussInfoKeyEnum.LOGINTYPE.getCode())
            && request.getBussExtInfo().containsKey(BussInfoKeyEnum.AUTHTOKEN.getCode())){
            return true;
        }
        return false;

    }


    @Override
    public String getActionCode() {
        return "CHECKIDENTITY";
    }
}
