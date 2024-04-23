package com.howard.rentalorder.model;

import com.howard.rentalorderdetails.model.RentalOrderDetailsVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "rentalorder")
public class RentalOrderVO implements Serializable {

    public RentalOrderVO() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rOrdNo", updatable = false)
    private Integer rOrdNo; // -> 租借品訂單編號
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member;
    @Column(name = "rByrName")
    private String rByrName; // -> 訂購人姓名
    @Column(name = "rByrPhone")
    private String rByrPhone; // -> 訂購人手機號碼
    @Column(name = "rByrEmail")
    private String rByrEmail; // -> 訂購人Email
    @Column(name = "rRcvName")
    private String rRcvName; // -> 收件人姓名
    @Column(name = "rRcvPhone")
    private String rRcvPhone; // -> 收件人手機號碼
    @Column(name = "rTakeMethod")
    private byte rTakeMethod; // -> 取貨方式
    @Column(name = "rAddr")
    private String rAddr; // -> 宅配住址
    @Column(name = "rPayMethod")
    private byte rPayMethod; // -> 付款方式
    @Column(name = "rAllPrice")
    private BigDecimal rAllPrice; // -> 訂單總金額
    @Column(name = "rAllDepPrice")
    private BigDecimal rAllDepPrice; // -> 押金總金額
    @Column(name = "rOrdTime")
    private Timestamp rOrdTime; // -> 下單時間
    @Column(name = "rDate")
    private Timestamp rDate; // -> 預計租借日期
    @Column(name = "rBackDate")
    private Timestamp rBackDate; // -> 預計歸還日期
    @Column(name = "rRealBackDate")
    private Timestamp rRealBackDate; // -> 實際歸還日期
    @Column(name = "rPayStat")
    private byte rPayStat; // -> 付款狀態
    @Column(name = "rOrdStat")
    private byte rOrdStat; // -> 訂單狀態
    @Column(name = "rtnStat")
    private byte rtnStat; // -> 歸還狀態
    @Column(name = "rtnRemark")
    private String rtnRemark; // -> 歸還註記
    @Column(name = "rtnCompensation")
    private BigDecimal rtnCompensation; // -> 賠償金額
    @OneToMany(mappedBy = "rentalOrder", cascade = CascadeType.ALL)
    private Set<RentalOrderDetailsVO> rentalOrderDetailses;

/*----------------------getter、setter--------------------------*/

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public String getrByrName() {
        return rByrName;
    }

    public void setrByrName(String rByrName) {
        this.rByrName = rByrName;
    }

    public String getrByrPhone() {
        return rByrPhone;
    }

    public void setrByrPhone(String rByrPhone) {
        this.rByrPhone = rByrPhone;
    }

    public String getrByrEmail() {
        return rByrEmail;
    }

    public void setrByrEmail(String rByrEmail) {
        this.rByrEmail = rByrEmail;
    }

    public String getrRcvName() {
        return rRcvName;
    }

    public void setrRcvName(String rRcvName) {
        this.rRcvName = rRcvName;
    }

    public String getrRcvPhone() {
        return rRcvPhone;
    }

    public void setrRcvPhone(String rRcvPhone) {
        this.rRcvPhone = rRcvPhone;
    }

    public byte getrTakeMethod() {
        return rTakeMethod;
    }

    public void setrTakeMethod(byte rTakeMethod) {
        this.rTakeMethod = rTakeMethod;
    }

    public String getrAddr() {
        return rAddr;
    }

    public void setrAddr(String rAddr) {
        this.rAddr = rAddr;
    }

    public byte getrPayMethod() {
        return rPayMethod;
    }

    public void setrPayMethod(byte rPayMethod) {
        this.rPayMethod = rPayMethod;
    }

    public BigDecimal getrAllPrice() {
        return rAllPrice;
    }

    public void setrAllPrice(BigDecimal rAllPrice) {
        this.rAllPrice = rAllPrice;
    }

    public BigDecimal getrAllDepPrice() {
        return rAllDepPrice;
    }

    public void setrAllDepPrice(BigDecimal rAllDepPrice) {
        this.rAllDepPrice = rAllDepPrice;
    }

    public Timestamp getrOrdTime() {
        return rOrdTime;
    }

    public void setrOrdTime(Timestamp rOrdTime) {
        this.rOrdTime = rOrdTime;
    }

    public Timestamp getrDate() {
        return rDate;
    }

    public void setrDate(Timestamp rDate) {
        this.rDate = rDate;
    }

    public Timestamp getrBackDate() {
        return rBackDate;
    }

    public void setrBackDate(Timestamp rBackDate) {
        this.rBackDate = rBackDate;
    }

    public Timestamp getrRealBackDate() {
        return rRealBackDate;
    }

    public void setrRealBackDate(Timestamp rRealBackDate) {
        this.rRealBackDate = rRealBackDate;
    }

    public byte getrPayStat() {
        return rPayStat;
    }

    public void setrPayStat(byte rPayStat) {
        this.rPayStat = rPayStat;
    }

    public byte getrOrdStat() {
        return rOrdStat;
    }

    public void setrOrdStat(byte rOrdStat) {
        this.rOrdStat = rOrdStat;
    }

    public byte getRtnStat() {
        return rtnStat;
    }

    public void setRtnStat(byte rtnStat) {
        this.rtnStat = rtnStat;
    }

    public String getRtnRemark() {
        return rtnRemark;
    }

    public void setRtnRemark(String rtnRemark) {
        this.rtnRemark = rtnRemark;
    }

    public BigDecimal getRtnCompensation() {
        return rtnCompensation;
    }

    public void setRtnCompensation(BigDecimal rtnCompensation) {
        this.rtnCompensation = rtnCompensation;
    }

    /*--------------------------聯合映射用的 getter、setter( rentalorder 是主表)------------------------------*/
    public Set<RentalOrderDetailsVO> getRentalOrderDetailses() {
        return rentalOrderDetailses;
    }

    public void setRentalOrderDetailses(Set<RentalOrderDetailsVO> rentalOrderDetailses) {
        this.rentalOrderDetailses = rentalOrderDetailses;
    }

/*--------------------------聯合映射用的 getter、setter( member 是主表)------------------------------*/
    public MemberVO getMember() {
        return this.member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }


    @Override
    public String toString() {
        return "RentalOrderVo_ORM{" +
                "rOrdNo=" + rOrdNo +
                ", member=" + member +
                ", rByrName='" + rByrName + '\'' +
                ", rByrPhone='" + rByrPhone + '\'' +
                ", rByrEmail='" + rByrEmail + '\'' +
                ", rRcvName='" + rRcvName + '\'' +
                ", rRcvPhone='" + rRcvPhone + '\'' +
                ", rTakeMethod=" + rTakeMethod +
                ", rAddr='" + rAddr + '\'' +
                ", rPayMethod=" + rPayMethod +
                ", rAllPrice=" + rAllPrice +
                ", rAllDepPrice=" + rAllDepPrice +
                ", rOrdTime=" + rOrdTime +
                ", rDate=" + rDate +
                ", rBackDate=" + rBackDate +
                ", rRealBackDate=" + rRealBackDate +
                ", rPayStat=" + rPayStat +
                ", rOrdStat=" + rOrdStat +
                ", rtnStat=" + rtnStat +
                ", rtnRemark='" + rtnRemark + '\'' +
                ", rtnCompensation=" + rtnCompensation +
                ", rentalOrderDetailses=" + rentalOrderDetailses +
                '}';
    }

}
