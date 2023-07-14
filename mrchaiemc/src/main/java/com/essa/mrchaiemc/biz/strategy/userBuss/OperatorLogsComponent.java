package com.essa.mrchaiemc.biz.strategy.userBuss;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.domains.bussiness.OperatorLogs;
import com.essa.mrchaiemc.biz.services.usersrv.UserService;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("OPERATORLOGS")
public class OperatorLogsComponent implements BussComponent {

    @Autowired
    private UserService userService;

    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        OperatorLogs operatorLogs = request.getBussContext().getOperatorLogs();
        operatorLogs.setGmtFinish(DateUtil.getGmtDate());
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        userService.saveOperatorLog(request, response);
    }

    @Override
    public String getActionCode() {
        return "OPERATORLOGS";
    }
}
