package com.essa.mrchaiemc.biz.services.usersrv;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     *
     * @param request
     * @param response
     */
    void checkUserValid(BussRequest request, BussResponse response);

    /**
     *
     * @param request
     * @param response
     */
    void doUserLogIn(BussRequest request, BussResponse response);

    /**
     * del userAcct open
     */
    void dealUserAcctOpen(BussRequest request, BussResponse response);


    /**
     *
     * @param request
     * @param response
     */
    String doUserRegister(BussRequest request, BussResponse response);

    /**
     *
     * @param request
     * @param response
     */
    void fetchUserInfo(BussRequest request, BussResponse response);

    /**
     *
     * @param request
     * @param response
     */
    void setOrChangeAuthToken(BussRequest request, BussResponse response);

    /**
     *
     * @param request
     * @param response
     */
    void saveOperatorLog(BussRequest request, BussResponse response);

}
