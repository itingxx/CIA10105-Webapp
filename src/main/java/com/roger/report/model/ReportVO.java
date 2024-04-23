package com.roger.report.model;

import com.ren.administrator.model.AdministratorVO;
import com.roger.columnreply.model.ColumnReplyVO;
import com.roger.member.model.MemberVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "report")
public class ReportVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportNo")
    private Integer reportNo;

    @ManyToOne
    @JoinColumn(name = "artReplyNo", referencedColumnName = "columnReplyNo")
    private ColumnReplyVO columnReply;

    // private Integer artReplyNo;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member;

    // private Integer memNo;

    @ManyToOne
    @JoinColumn(name = "admNo", referencedColumnName = "admNo")
    private AdministratorVO administrator;

    // private Integer admNo;

    @Column(name = "reportTime")
    private Timestamp reportTime;

    @Column(name = "reportReason")
    private String reportReason;

    @Column(name = "reportType")
    private Byte reportType;

    public Integer getReportNo() {
        return reportNo;
    }

    public void setReportNo(Integer reportNo) {
        this.reportNo = reportNo;
    }

    public ColumnReplyVO getColumnReply() {
        return columnReply;
    }

    public void setColumnReply(ColumnReplyVO columnReply) {
        this.columnReply = columnReply;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public AdministratorVO getAdministrator() {
        return administrator;
    }

    public void setAdministrator(AdministratorVO administrator) {
        this.administrator = administrator;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public Byte getReportType() {
        return reportType;
    }

    public void setReportType(Byte reportType) {
        this.reportType = reportType;
    }
}
