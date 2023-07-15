package com.essa.mrchaiemc.common.integration.sys;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.essa.mrchaiemc.biz.models.exceptions.SysInitException;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

        bussFlowMap = getBussFlowConfig();
        if (bussFlowMap != null) {
            for (String key : bussFlowMap.keySet()) {
                System.out.println(key + ":" + bussFlowMap.get(key));
            }
        }
    }

    public static Map<String, String> getSysConfig() {
        Map<String, String> configMap = null;
        try {
            ClassPathResource resource = new ClassPathResource("sysconfig.json");
            InputStream inputStream = resource.getInputStream();
            //File configFile = resource.getFile();
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (inputStream, StandardCharsets.UTF_8))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
           // String content = FileUtils.readFileToString(configFile, "UTF-8");
            String content = textBuilder.toString();
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
            InputStream inputStream = resource.getInputStream();

            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (inputStream, StandardCharsets.UTF_8))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            String content = textBuilder.toString();
            bussFlowMap = JSONObject.parseObject(content, new TypeReference<Map<String, String>>() {
            });

        } catch (Exception e) {
            LoggerUtil.errlog(e, "Read bussflow.json fail");
            throw new SysInitException();
        }
        return bussFlowMap;
    }
}
