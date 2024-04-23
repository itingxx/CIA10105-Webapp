package com.chihyun.servicerecord.model;


import com.chihyun.servicepicture.model.ServicePictureVO;
import com.ren.administrator.model.AdministratorVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "ServiceRecord")
public class ServiceRecordVO {
	@Id
    @Column(name = "recordNo")
	private Integer recordNo;
    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private AdministratorVO administrator;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member;
    @Column(name = "recordTime")
    private Timestamp recordTime;
    @Column(name = "recordContent")
    private String recordContent;
    @Column(name = "speaker")
    private Byte speaker;
    @OneToMany(mappedBy = "serviceRecord", cascade = CascadeType.ALL)
    private Set<ServicePictureVO> ServicePictures;

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public AdministratorVO getAdministrator() {
        return administrator;
    }

    public void setAdministrator(AdministratorVO administrator) {
        this.administrator = administrator;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    public Byte getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Byte speaker) {
        this.speaker = speaker;
    }

    public Set<ServicePictureVO> getServicePictures() {
        return ServicePictures;
    }

    public void setServicePictures(Set<ServicePictureVO> servicePictures) {
        ServicePictures = servicePictures;
    }
}
