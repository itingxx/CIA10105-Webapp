package com.roger.columnreply.model;

import com.roger.columnarticle.model.ColumnArticleVO;
import com.roger.member.model.MemberVO;
import com.roger.report.model.ReportVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "columnReply")
public class ColumnReplyVO implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "columnReplyNo")
    private Integer columnReplyNo;
    @ManyToOne
    @JoinColumn(name = "artNo", referencedColumnName = "artNo")
    private ColumnArticleVO columnArticle;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member;
    @Column(name = "comContent")
    private String comContent;
    @Column(name = "comTime")
    private Timestamp comTime;
    @Column(name = "comStat")
    private Byte comStat;
    @OneToMany(mappedBy = "columnReply", cascade = CascadeType.ALL)
    private Set<ReportVO> reports;

    public Integer getColumnReplyNo() {
        return columnReplyNo;
    }

    public void setColumnReplyNo(Integer columnReplyNo) {
        this.columnReplyNo = columnReplyNo;
    }

    public ColumnArticleVO getColumnArticle() {
        return columnArticle;
    }

    public void setColumnArticle(ColumnArticleVO columnArticle) {
        this.columnArticle = columnArticle;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Timestamp getComTime() {
        return comTime;
    }

    public void setComTime(Timestamp comTime) {
        this.comTime = comTime;
    }

    public Byte getComStat() {
        return comStat;
    }

    public void setComStat(Byte comStat) {
        this.comStat = comStat;
    }

    public Set<ReportVO> getReports() {
        return reports;
    }

    public void setReports(Set<ReportVO> reports) {
        this.reports = reports;
    }
}
