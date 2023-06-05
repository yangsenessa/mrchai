package com.essa.mrchaiemc.biz.services;

import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class BussPipeline {

    @Autowired
    protected Map<String, BussComponent>  componentMap = new HashMap<>();

    public Map<String, BussComponent> getComponentMap() {
        return componentMap;
    }

    public void setComponentMap(Map<String, BussComponent> componentMap) {
        this.componentMap = componentMap;
    }


    public void execWithPipeLine(BussRequest request, BussResponse response){
        if(CollectionUtils.isEmpty(request.getStrategyCommonCodeList()) ){
            return;
        } else {
            for (String key: request.getStrategyCommonCodeList()){
                BussComponent bussComponent = componentMap.get(key);
                if(bussComponent != null && bussComponent.preProcess(request, response)){
                    bussComponent.doProcess(request,response);
                }
            }

        }


    }

}
