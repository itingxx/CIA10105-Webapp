package com.iting.cart.model;

import com.ren.product.model.ProductVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class CartVO {

    @EmbeddedId
    private CompositeDetail2 compositeKey2;
    @Column(name = "pBuyQty")
    private Integer pBuyQty;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo", insertable = false, updatable = false)
    private MemberVO  member;
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo", insertable = false, updatable = false)
    private ProductVO product;

    public CompositeDetail2 getCompositeKey2() {
        return compositeKey2;
    }

    public void setCompositeKey2(CompositeDetail2 compositeKey2) {
        this.compositeKey2 = compositeKey2;
    }

    public Integer getpBuyQty() {
        return pBuyQty;
    }

    public void setpBuyQty(Integer pBuyQty) {
        this.pBuyQty = pBuyQty;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    @Embeddable
    public static class CompositeDetail2 implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "pNo")
        private Integer pNo;
        @Column(name = "memNo")
        private Integer memNo;


        public CompositeDetail2(){
            super();
        }
        public CompositeDetail2(Integer pNo,Integer memNo){
            super();
            this.pNo = pNo;
            this.memNo = memNo;

        }

        public Integer getpNo() {
            return pNo;
        }
        public void setpNo(Integer pNo) {
            this.pNo = pNo;
        }
        public Integer getmemNo() {
            return memNo;
        }
        public void setmemNo(Integer memNo) {
            this.memNo = memNo;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((pNo == null) ? 0 : pNo.hashCode());
            result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj != null && getClass() == obj.getClass()) {
               CompositeDetail2 compositeKey2 = (CompositeDetail2) obj;
                if (pNo.equals(compositeKey2.pNo) && memNo.equals(compositeKey2.memNo)) {
                    return true;
                }
            }

            return false;
        }
    }

}


