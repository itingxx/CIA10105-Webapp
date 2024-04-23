package com.chihyun.mycoupon.model;


import com.chihyun.coupon.model.CouponVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "MyCoupon")
public class MyCouponVO implements Serializable{
    @EmbeddedId
    private CompositeCouponMember compositeCouponMember;
    @Column(name = "coupNo", insertable = false, updatable = false)
    private  Integer coupNo;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo", insertable = false, updatable = false)
    private MemberVO member;
    @Column(name = "coupUsedStat")
    private Byte coupUsedStat;
    @Column(name = "coupInfo")
    private String coupInfo;
    @Column(name = "coupExpDate")
    private Timestamp coupExpDate;
    @OneToMany(mappedBy = "myCoupon", cascade = CascadeType.ALL)
    private Set<CouponVO> coupons;
    @Embeddable
    public static class CompositeCouponMember implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "coupNo")
        private Integer coupNo;
        @Column(name = "memNo")
        private Integer memNo;

        public Integer getTitleNo() {
            return coupNo;
        }

        public void setTitleNo(Integer coupNo) {
            this.coupNo = coupNo;
        }

        public Integer getAuthFuncNo() {
            return memNo;
        }

        public void setAuthFuncNo(Integer memNo) {
            this.memNo = memNo;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((coupNo == null) ? 0 : coupNo.hashCode());
            result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj != null && getClass() == obj.getClass()) {
                CompositeCouponMember compositeCouponMember = (CompositeCouponMember) obj;
                if (coupNo.equals(compositeCouponMember.coupNo) && memNo.equals(compositeCouponMember.memNo)) {
                    return true;
                }
            }
            return false;
        }
    }

    public CompositeCouponMember getCompositeCouponMember() {
        return compositeCouponMember;
    }

    public void setCompositeCouponMember(CompositeCouponMember compositeCouponMember) {
        this.compositeCouponMember = compositeCouponMember;
    }

    public Integer getCoupNo() {
        return coupNo;
    }

    public void setCoupNo(Integer coupNo) {
        this.coupNo = coupNo;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public Byte getCoupUsedStat() {
        return coupUsedStat;
    }

    public void setCoupUsedStat(Byte coupUsedStat) {
        this.coupUsedStat = coupUsedStat;
    }

    public String getCoupInfo() {
        return coupInfo;
    }

    public void setCoupInfo(String coupInfo) {
        this.coupInfo = coupInfo;
    }

    public Timestamp getCoupExpDate() {
        return coupExpDate;
    }

    public void setCoupExpDate(Timestamp coupExpDate) {
        this.coupExpDate = coupExpDate;
    }

    public Set<CouponVO> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<CouponVO> coupons) {
        this.coupons = coupons;
    }
}
