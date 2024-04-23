package com.ren.administrator.model;


import com.chihyun.servicerecord.model.ServiceRecordVO;
import com.firesnoopy.studioorder.model.StudioOrderVO;
import com.ren.title.model.TitleVO;
import com.roger.columnarticle.model.ColumnArticleVO;
import com.roger.report.model.ReportVO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Administrator")
public class AdministratorVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admNo")
    private Integer admNo;
    @Column(name = "admPwd")
    private String admPwd;
    @Column(name = "admName")
    private String admName;
    @Column(name = "admStat")
    private Byte admStat;
    @Column(name = "admEmail")
    private String admEmail;
    @ManyToOne
    @JoinColumn(name = "titleNo", referencedColumnName = "titleNo")
    private TitleVO title;
    @Column(name = "admHireDate")
    private Date admHireDate;
    @Column(name = "admPhoto", columnDefinition = "blob")
    private byte[] admPhoto;
    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Set<StudioOrderVO> studioOrders;
    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Set<ReportVO> reports;
    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Set<ServiceRecordVO> serviceRecords;
    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Set<ColumnArticleVO> columnArticles;

    public AdministratorVO() {
    }

    public AdministratorVO(Integer admNo, String admPwd, String admName, Byte admStat, String admEmail, TitleVO title, Date admHireDate, byte[] admPhoto, Set<StudioOrderVO> studioOrders, Set<ReportVO> reports, Set<ServiceRecordVO> serviceRecords, Set<ColumnArticleVO> columnArticles) {
        this.admNo = admNo;
        this.admPwd = admPwd;
        this.admName = admName;
        this.admStat = admStat;
        this.admEmail = admEmail;
        this.title = title;
        this.admHireDate = admHireDate;
        this.admPhoto = admPhoto;
        this.studioOrders = studioOrders;
        this.reports = reports;
        this.serviceRecords = serviceRecords;
        this.columnArticles = columnArticles;
    }

    public Integer getAdmNo() {
        return admNo;
    }

    public void setAdmNo(Integer admNo) {
        this.admNo = admNo;
    }

    public String getAdmPwd() {
        return admPwd;
    }

    public void setAdmPwd(String admPwd) {
        this.admPwd = admPwd;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public Byte getAdmStat() {
        return admStat;
    }

    public void setAdmStat(Byte admStat) {
        this.admStat = admStat;
    }

    public String getAdmEmail() {
        return admEmail;
    }

    public void setAdmEmail(String admEmail) {
        this.admEmail = admEmail;
    }

    public TitleVO getTitle() {
        return title;
    }

    public void setTitle(TitleVO title) {
        this.title = title;
    }

    public Date getAdmHireDate() {
        return admHireDate;
    }

    public void setAdmHireDate(Date admHireDate) {
        this.admHireDate = admHireDate;
    }

    public byte[] getAdmPhoto() {
        return admPhoto;
    }

    public void setAdmPhoto(byte[] admPhoto) {
        this.admPhoto = admPhoto;
    }

    public Set<StudioOrderVO> getStudioOrders() {
        return studioOrders;
    }

    public void setStudioOrders(Set<StudioOrderVO> studioOrders) {
        this.studioOrders = studioOrders;
    }

    public Set<ReportVO> getReports() {
        return reports;
    }

    public void setReports(Set<ReportVO> reports) {
        this.reports = reports;
    }

    public Set<ServiceRecordVO> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(Set<ServiceRecordVO> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }

    public Set<ColumnArticleVO> getColumnArticles() {
        return columnArticles;
    }

    public void setColumnArticles(Set<ColumnArticleVO> columnArticles) {
        this.columnArticles = columnArticles;
    }
}
