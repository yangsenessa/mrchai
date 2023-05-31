package com.essa.mrchaiemc.biz.strategy;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;

public interface BussComponent {

    /**
     * @param request
     * @param response
     */
     void doProcess(BussRequest request, BussResponse response);

    /**
     * 返回组件ActionCode
     * @return
     */
    String getActionCode();


}
