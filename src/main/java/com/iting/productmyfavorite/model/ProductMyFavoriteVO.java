package com.iting.productmyfavorite.model;

import com.ren.admauthority.model.AdmAuthorityVO;
import com.ren.authorityfunction.model.AuthorityFunctionVO;
import com.ren.product.model.ProductVO;
import com.ren.title.model.TitleVO;
import com.roger.member.model.MemberVO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productmyfavorite")
public class ProductMyFavoriteVO {
    @EmbeddedId
    private CompositeProductMyFavorite compositeProductMyFavorite;
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo", insertable = false, updatable = false)
    private ProductVO product;
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo", insertable = false, updatable = false)
    private MemberVO member;
    @Embeddable
    public static class CompositeProductMyFavorite implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "pNo")
        private Integer pNo;
        @Column(name = "memNo")
        private Integer memNo;

        public Integer getpNo() {
            return pNo;
        }

        public void setpNo(Integer pNo) {
            this.pNo = pNo;
        }

        public Integer getMemNo() {
            return memNo;
        }

        public void setMemNo(Integer memNo) {
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

            if (this == obj) {
                return true;
            }

            if (obj != null && getClass() == obj.getClass()) {
                CompositeProductMyFavorite compositeProductMyFavorite = (CompositeProductMyFavorite) obj;
                if (pNo.equals(compositeProductMyFavorite.pNo) && memNo.equals(compositeProductMyFavorite.memNo)) {
                    return true;
                }
            }
            return false;
        }
    }

    public CompositeProductMyFavorite getCompositeProductMyFavorite() {
        return compositeProductMyFavorite;
    }

    public void setCompositeProductMyFavorite(CompositeProductMyFavorite compositeProductMyFavorite) {
        this.compositeProductMyFavorite = compositeProductMyFavorite;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }
}
