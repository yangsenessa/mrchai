package com.essa.mrchaiemc;

import com.essa.mrchaiemc.common.dal.dao.OperatorLogsDAO;
import com.essa.mrchaiemc.common.dal.repository.OperatorLogsDO;
import com.essa.mrchaiemc.common.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MrchaiemcApplication.class)
public class OperatorLogsTest {

    @Autowired
    private OperatorLogsDAO operatorLogsDAO;

    @Test
    public void testSave(){
        OperatorLogsDO operatorLogsDO = new OperatorLogsDO();
        operatorLogsDO.setCustId("1");
        operatorLogsDO.setTraceId("2");
        operatorLogsDO.setGmtCreate(DateUtil.getGmtDate());
        operatorLogsDO.setGmtFinish(DateUtil.getGmtDate());
        operatorLogsDAO.save(operatorLogsDO);
    }
}
