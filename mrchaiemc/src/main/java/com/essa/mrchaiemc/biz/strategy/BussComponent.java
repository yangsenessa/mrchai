package com.essa.mrchaiemc.biz.strategy;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;

public interface BussComponent {

    /**
     * @param request
     * @param response
     */
    public void doProcess(BussRequest request, BussResponse response);

}
