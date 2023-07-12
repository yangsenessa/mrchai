
package com.essa.mrchaiemc;

import com.essa.mrchaiemc.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class  WebMvcConfig implements WebMvcConfigurer {

    Logger logger =  Logger.getLogger(WebMvcConfig.class);
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        LoggerUtil.info(logger,"Loading the multipart resolver");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024000000);
        return multipartResolver;
    }

}