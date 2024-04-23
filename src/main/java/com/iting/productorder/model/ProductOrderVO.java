package com.iting.productorder.model;


import com.chihyun.coupon.model.CouponVO;
import com.iting.productorderdetail.model.ProductOrderDetailVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "productorder")
public class ProductOrderVO {
    @Id
    @Column(name = "pOrdNo", updatable = false)
    private Integer pOrdNo;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO member;
    @Column(name = "pByrName")
    private String pByrName;
    @Column(name = "pByrPhone")
    private Integer pByrPhone;
    @Column(name = "pByrEmail")
    private String pByrEmail;
    @Column(name = "pRcvName")
    private String pRcvName;
    @Column(name = "pRcvPhone")
    private String pRcvPhone;
    @Column(name = "pTakeMethod")
    private Byte pTakeMethod;
    @Column(name = "pAddr")
    private String pAddr;
    @Column(name = "pPayMethod")
    private Byte pPayMethod;
    @Column(name = "pAllPrice")
    private BigDecimal pAllPrice;
    @ManyToOne
    @JoinColumn(name = "coupNo", referencedColumnName = "coupNo")
    private CouponVO coupon;
    @Column(name = "pDisc")
    private BigDecimal pDisc;
    @Column(name = "pRealPrice")
    private BigDecimal pRealPrice;
    @Column(name = "pOrdTime")
    private Timestamp pOrdTime;
    @Column(name = "pOrdStat")
    private Byte pOrdStat;
    @Column(name = "pStat")
    private Byte pStat;
    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<ProductOrderDetailVO> productOrderDetails;

    public Integer getpOrdNo() {
        return pOrdNo;
    }

    public void setpOrdNo(Integer pOrdNo) {
        this.pOrdNo = pOrdNo;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public String getpByrName() {
        return pByrName;
    }

    public void setpByrName(String pByrName) {
        this.pByrName = pByrName;
    }

    public Integer getpByrPhone() {
        return pByrPhone;
    }

    public void setpByrPhone(Integer pByrPhone) {
        this.pByrPhone = pByrPhone;
    }

    public String getpByrEmail() {
        return pByrEmail;
    }

    public void setpByrEmail(String pByrEmail) {
        this.pByrEmail = pByrEmail;
    }

    public String getpRcvName() {
        return pRcvName;
    }

    public void setpRcvName(String pRcvName) {
        this.pRcvName = pRcvName;
    }

    public String getpRcvPhone() {
        return pRcvPhone;
    }

    public void setpRcvPhone(String pRcvPhone) {
        this.pRcvPhone = pRcvPhone;
    }

    public Byte getpTakeMethod() {
        return pTakeMethod;
    }

    public void setpTakeMethod(Byte pTakeMethod) {
        this.pTakeMethod = pTakeMethod;
    }

    public String getpAddr() {
        return pAddr;
    }

    public void setpAddr(String pAddr) {
        this.pAddr = pAddr;
    }

    public Byte getpPayMethod() {
        return pPayMethod;
    }

    public void setpPayMethod(Byte pPayMethod) {
        this.pPayMethod = pPayMethod;
    }

    public BigDecimal getpAllPrice() {
        return pAllPrice;
    }

    public void setpAllPrice(BigDecimal pAllPrice) {
        this.pAllPrice = pAllPrice;
    }

    public CouponVO getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponVO coupon) {
        this.coupon = coupon;
    }

    public BigDecimal getpDisc() {
        return pDisc;
    }

    public void setpDisc(BigDecimal pDisc) {
        this.pDisc = pDisc;
    }

    public BigDecimal getpRealPrice() {
        return pRealPrice;
    }

    public void setpRealPrice(BigDecimal pRealPrice) {
        this.pRealPrice = pRealPrice;
    }

    public Timestamp getpOrdTime() {
        return pOrdTime;
    }

    public void setpOrdTime(Timestamp pOrdTime) {
        this.pOrdTime = pOrdTime;
    }

    public Byte getpOrdStat() {
        return pOrdStat;
    }

    public void setpOrdStat(Byte pOrdStat) {
        this.pOrdStat = pOrdStat;
    }

    public Byte getpStat() {
        return pStat;
    }

    public void setpStat(Byte pStat) {
        this.pStat = pStat;
    }

    public Set<ProductOrderDetailVO> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductOrderDetailVO> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }
}
