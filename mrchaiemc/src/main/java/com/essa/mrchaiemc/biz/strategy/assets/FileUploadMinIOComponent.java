package com.essa.mrchaiemc.biz.strategy.assets;
import cn.minsin.core.tools.StringUtil;
import com.essa.mrchaiemc.biz.models.domains.BussRequest;
import com.essa.mrchaiemc.biz.models.domains.BussResponse;
import com.essa.mrchaiemc.biz.models.enumcollection.BussInfoKeyEnum;
import com.essa.mrchaiemc.biz.models.enumcollection.ResultCode;
import com.essa.mrchaiemc.biz.strategy.BussComponent;
import com.essa.mrchaiemc.common.dal.dao.MinIOFileInfoDAO;
import com.essa.mrchaiemc.common.dal.repository.MinIOFileInfoDO;
import com.essa.mrchaiemc.common.util.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.UUID;

@Component("FILEUPLOAD")
public class FileUploadMinIOComponent implements BussComponent {
    @Autowired
    MinioUtil minioUtil;
    @Autowired
    private MinIOFileInfoDAO minIOFileInfoDAO;
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


        MinIOFileInfoDO minIOFileInfoDO = new MinIOFileInfoDO();
        minIOFileInfoDO.setFileId(UUID.randomUUID().toString());
// String downLoadurl=minioUtil.getFileUrl(downLoadLink); //下载地址链接
        MultipartFile[] files = request.getBussContext().getFile();
        try {
            for (MultipartFile file : files) {
                String returns=minioUtil.uploadFile(file);
                minIOFileInfoDO.setMinIOurlk(returns);
                String downLoadurl=minioUtil.getFileUrl(returns);
                minIOFileInfoDO.setDownLoadLink(downLoadurl);
                this.minIOFileInfoDAO.save(minIOFileInfoDO);
            }
        } catch (Exception e) {
            response.setResCode(ResultCode.SYSFAIL.name());
        }
        response.setResCode(ResultCode.SUCCESS.name());
        response.setResExtInfo(new HashMap<String, String>());
        response.getResExtInfo().put(BussInfoKeyEnum.FILELINK.getCode(), minIOFileInfoDO.getDownLoadLink());
    }

    @Override
    public String getActionCode() {
        return "FILEUPLOAD";
    }
}