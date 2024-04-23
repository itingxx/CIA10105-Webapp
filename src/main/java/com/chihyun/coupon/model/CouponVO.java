package com.chihyun.coupon.model;


import com.chihyun.mycoupon.model.MyCouponVO;
import com.iting.productorder.model.ProductOrderVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Coupon")
public class CouponVO {
    @Id
    @Column(name = "coupNo")
    private Integer coupNo;
    @ManyToOne
    @JoinColumn(name = "coupNo", referencedColumnName = "coupNo", insertable = false, updatable = false)
    private MyCouponVO myCoupon;
    @Column(name = "coupName")
    private String coupName;
    @Column(name = "coupCond")
    private String coupCond;
    @Column(name = "coupDisc")
    private BigDecimal coupDisc;
    @Column(name = "coupAddDate")
    private Timestamp coupAddDate;
    @Column(name = "coupExpDate")
    private Timestamp coupExpDate;
    @Column(name = "coupRelDate")
    private Timestamp coupRelDate;
    @Column(name = "coupRelStat")
    private Byte coupRelStat;
    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL)
    private Set<ProductOrderVO> productOrders;

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public MyCouponVO getMyCoupon() {
        return myCoupon;
    }

    public void setMyCoupon(MyCouponVO myCoupon) {
        this.myCoupon = myCoupon;
    }

    public String getCoupName() {
        return coupName;
    }

    public void setCoupName(String coupName) {
        this.coupName = coupName;
    }

    public String getCoupCond() {
        return coupCond;
    }

    public void setCoupCond(String coupCond) {
        this.coupCond = coupCond;
    }

    public BigDecimal getCoupDisc() {
        return coupDisc;
    }

    public void setCoupDisc(BigDecimal coupDisc) {
        this.coupDisc = coupDisc;
    }

    public Timestamp getCoupAddDate() {
        return coupAddDate;
    }

    public void setCoupAddDate(Timestamp coupAddDate) {
        this.coupAddDate = coupAddDate;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }

    public Timestamp getCoupRelDate() {
        return coupRelDate;
    }

    public void setCoupRelDate(Timestamp coupRelDate) {
        this.coupRelDate = coupRelDate;
    }

    public Byte getCoupRelStat() {
        return coupRelStat;
    }

    public void setCoupRelStat(Byte coupRelStat) {
        this.coupRelStat = coupRelStat;
    }

    public Set<ProductOrderVO> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Set<ProductOrderVO> productOrders) {
        this.productOrders = productOrders;
    }
}
