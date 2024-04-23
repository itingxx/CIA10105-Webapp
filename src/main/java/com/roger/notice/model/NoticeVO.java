package com.roger.notice.model;

import com.roger.member.model.MemberVO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notice")
public class NoticeVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "motNo")
    private Integer motNo;

    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member; // 定義多對一關係(現在表示:通知\(多)，會員(單))，該字段關聯到 MemberVO 實體類，使用 memNo 列作為外來鍵。 需要再生成getter and setter

    @Column(name = "notContent")
    private String notContent;

    @Column(name = "notTime")
    private Timestamp notTime;

    @Column(name = "notStat")
    private Byte notStat;

    public Integer getMotNo() {
        return motNo;
    }

    public void setMotNo(Integer motNo) {
        this.motNo = motNo;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public String getNotContent() {
        return notContent;
    }

    public void setNotContent(String notContent) {
        this.notContent = notContent;
    }

    public Timestamp getNotTime() {
        return notTime;
    }

    public void setNotTime(Timestamp notTime) {
        this.notTime = notTime;
    }

    public Byte getNotStat() {
        return notStat;
    }

    public void setNotStat(Byte notStat) {
        this.notStat = notStat;
    }
}
