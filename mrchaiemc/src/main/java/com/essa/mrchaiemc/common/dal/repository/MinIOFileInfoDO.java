package com.essa.mrchaiemc.common.dal.repository;
 import javax.persistence.*;
 import java.io.Serializable;

@Entity
@Table(name = "minio_fileinfo")
public class MinIOFileInfoDO implements Serializable {

    private static final long serialVersionUID = -8793347041807273011L;

    @Id
    @Column(name = "file_id", nullable = false, length = 128)
    private String fileId;

    /*minIO文件路径*/
    @Column(name = "minIO_url", nullable = true, length = 255)
    private String minIOurl;

    /*文件下载地址*/
    @Column(name = "download_link", nullable = true, length =2048)
    private String downLoadLink;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getMinIOurl() {
        return minIOurl;
    }

    public void setMinIOurlk(String minIOurl) {
        this.minIOurl = minIOurl;
    }

    public String getDownLoadLink() {
        return downLoadLink;
    }

    public void setDownLoadLink(String downLoadLink) {
        this.downLoadLink = downLoadLink;
    }


}
