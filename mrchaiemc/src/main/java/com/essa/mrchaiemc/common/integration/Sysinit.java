package com.essa.mrchaiemc.common.integration;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.exceptions.SysInitException;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sysinit {

    static Map<String, String> configMap = new HashMap<>();
    public static void intiConfig(){
        configMap = getSysConfig();
        if(configMap != null){
            for(String key:configMap.keySet()){
                System.out.println(key+ ":" + configMap.get(key));
            }
        }
    }

    public static Map<String, String> getSysConfig() {
        Map<String, String> configMap = null;
        try {
            ClassPathResource resource = new ClassPathResource("sysconfig.json");
            File configFile = resource.getFile();
            String content = FileUtils.readFileToString(configFile, "UTF-8");
            configMap = JSONObject.parseObject(content, new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            LoggerUtil.errlog(e,"Read sysconfig.json fail");
            throw new SysInitException();
        }
        return configMap;
    }
}
