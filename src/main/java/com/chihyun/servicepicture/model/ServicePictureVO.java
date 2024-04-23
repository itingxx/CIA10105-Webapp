package com.chihyun.servicepicture.model;



import javax.persistence.*;

import com.chihyun.servicerecord.model.ServiceRecordVO;

@Entity
@Table(name = "ServicePicture")
public class ServicePictureVO {
    @Id
    @Column(name = "servicePicNo")
    private Integer servicePicNo;
    @ManyToOne
    @JoinColumn(name = "recordNo", referencedColumnName = "recordNo")
    private ServiceRecordVO serviceRecord;
    @Column(name = "servicePic", columnDefinition = "longblob")
    private byte[] servicePic;

    public Integer getServicePicNo() {
        return servicePicNo;
    }

    public void setServicePicNo(Integer servicePicNo) {
        this.servicePicNo = servicePicNo;
    }

    public ServiceRecordVO getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(ServiceRecordVO serviceRecord) {
        this.serviceRecord = serviceRecord;
    }

    public byte[] getServicePic() {
        return servicePic;
    }

    public void setServicePic(byte[] servicePic) {
        this.servicePic = servicePic;
    }
}
