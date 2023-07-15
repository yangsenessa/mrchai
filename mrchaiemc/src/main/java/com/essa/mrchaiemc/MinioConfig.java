package com.essa.mrchaiemc;
import com.essa.mrchaiemc.common.util.LoggerUtil;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio文件系统初始化
 *
 * @author wliduo[i@dolyw.com]
 * @date 2020/2/5 14:36
 */
@Slf4j
@Configuration
public class MinioConfig {

    /**
     * logger
     */
    private final static Logger logger =  Logger.getLogger(MinioConfig.class);

    @Value("${minio.url}")
    private String url;

    @Value("${minio.access}")
    private String access;

    @Value("${minio.secret}")
    private String secret;

    @Value("${minio.bucket}")
    private String bucket;

    /**
     * Minio文件系统配置
     *
     * @param
     * @return io.minio.MinioClient
     * @throws
     * @author wliduo[i@dolyw.com]
     * @date 2020/2/5 16:10
     */


    @Bean(name = "minioClient")
    public MinioClient minioClient() throws Exception {
        LoggerUtil.info(logger,"---------- Minio文件系统初始化加载 ----------");
        MinioClient minioClient = new MinioClient(url, access, secret);
        // 判断Bucket是否存在
        boolean isExist = minioClient.bucketExists(bucket);
        if(isExist) {
            logger.info("---------- Minio文件系统Bucket已存在 ----------");
        } else {
            // 不存在创建一个新的Bucket
            minioClient.makeBucket(bucket);
            logger.info("---------- Minio文件系统Bucket已创建 ----------");
        }
        logger.info("---------- Minio文件系统初始化完成 ----------");
        return minioClient;
    }

}
