package com.essa.mrchaiemc.biz.services.usersrv;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * 检查用户态是否合法
     * @param request
     * @param response
     */
    void checkUserValid(BussRequest request, BussResponse response);

    /**
     * 执行用户登录
     * @param request
     * @param response
     */
    void doUserLogIn(BussRequest request, BussResponse response);


    /**
     * 执行用户注册
     * @param request
     * @param response
     */
    String doUserRegister(BussRequest request, BussResponse response);

}
