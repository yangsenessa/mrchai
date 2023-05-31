package com.essa.mrchaiemc.common.integration.sys;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.exceptions.SysInitException;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SysConfigInit {

    public static Map<String, String> configMap = new HashMap<>();
    public static Map<String, String> bussFlowMap = new HashMap<>();

    public static void intiConfig() {
        configMap = getSysConfig();
        if (configMap != null) {
            for (String key : configMap.keySet()) {
                System.out.println(key + ":" + configMap.get(key));
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
            LoggerUtil.errlog(e, "Read sysconfig.json fail");
            throw new SysInitException();
        }
        return configMap;
    }

    /**
     * 加载组件编排配置
     */
    public static Map<String, String> getBussFlowConfig() {
        Map<String, String> flowMap = null;
        try {
            ClassPathResource resource = new ClassPathResource("bussflow.json");
            File configFile = resource.getFile();
            String content = FileUtils.readFileToString(configFile, "UTF-8");
            bussFlowMap = JSONObject.parseObject(content, new TypeReference<Map<String, String>>() {
            });

        } catch (Exception e) {
            LoggerUtil.errlog(e, "Read bussflow.json fail");
            throw new SysInitException();
        }
        return bussFlowMap;
    }
}
