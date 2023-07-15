/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.essa.mrchaiemc.biz.strategy.assets;

import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.models.exceptions.SysInitException;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.util.assets.FileManagerUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author senyang
 * @version : FileUploadComponent.java, v 0.1 2023年06月10日 10:48 PM senyang Exp $
 */
@Component("UPLOADFILE")
public class FileUploadComponent implements BussComponent {
    @Override
    public boolean preProcess(BussRequest request, BussResponse response) {
        if(request.getBussContext().getFile() == null ||request.getBussContext().getFile().length ==0 ){
            return false;
        }
        if(StringUtil.isEmpty(request.getUserContext().getUserId())){
            //todo:noly mocked for test
            request.getUserContext().setUserId("1111");
           // return false;
        }
        return true;
    }

    @Override
    public void doProcess(BussRequest request, BussResponse response) {
        MultipartFile[] files = request.getBussContext().getFile();
        try {
            for (MultipartFile file : files) {
                // 文件大小
                long size = file.getSize();
                // 老文件名字
                String originalFilename = file.getOriginalFilename();
                // 文件类型 不是文件的扩展名
                String contentType = file.getContentType();
                // 获取文件后缀名
                String[] split = contentType.split("/");
                String ext = "." + split[1];
                //traceId作为文件名
                String newFileName = request.getBussContext().getTraceId()+ext;

                String filePath = null;
                //判断是视频还是图片
                if (file.getContentType().indexOf("image") != -1) {
                    filePath = FileManagerUtil.getCustImgPath(request.getHttpServletRequest(), request.getUserContext().getUserId());
                }
                if (file.getContentType().indexOf("video") != -1) {
                    filePath = FileManagerUtil.getCustVideoPath(request.getHttpServletRequest(), request.getUserContext().getUserId());
                }
                if (StringUtil.isEmpty(filePath)) {
                    throw new SysInitException();
                }

                // 创建用户路径
                File fileDir = new File(filePath);
                if (!fileDir.isDirectory()) {
                    fileDir.mkdirs();
                }
                File fileServer = new File(filePath, newFileName);
                file.transferTo(fileServer);

            }
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());

    }

    @Override
    public String getActionCode() {
        return "UPLOADFILE";
    }
}