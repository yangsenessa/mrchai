package rpc.controller;

import common.util.ResUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rpc.controller.view.models.req.CustomCommonReq;
import rpc.controller.view.models.rsp.CustomerLoginResponse;

@Controller
public class CustomerBussContorller {
    @RequestMapping(value = "/mainframeinit.do", produces = { MediaType.APPLICATION_JSON_VALUE },method = RequestMethod.POST)
    public CustomerLoginResponse mainFreameInit(@RequestBody CustomCommonReq req){
       // System.out.println(req.getLanguage());
        return ResUtil.instanceOfSucWithOutEmc(null, null);
    }

    public CustomerLoginResponse commonErr(){
         return null;
    }


}
