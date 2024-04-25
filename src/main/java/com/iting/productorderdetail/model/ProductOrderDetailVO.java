package com.iting.productorderdetail.model;

import com.iting.productorder.model.ProductOrderVO;
import com.ren.product.model.ProductVO;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "productorderdetail")
public class ProductOrderDetailVO implements java.io.Serializable{
    @EmbeddedId
    private CompositeDetail compositeKey;
    @Column(name = "pPrice")
    private BigDecimal pPrice;
    @Column(name = "pOrdQty")
    private Integer pOrdQty;
    @Column(name = "pRealPrice")
    private BigDecimal pRealPrice;
    @Column(name = "pComContent")
    private String pComContent;
    @Column(name = "pScore")
    private Integer pScore;
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo", insertable = false, updatable = false)
    private ProductVO product;
    @ManyToOne
    @JoinColumn(name = "pOrdNo", referencedColumnName = "pOrdNo", insertable = false, updatable = false)
    private ProductOrderVO productOrder;

    // 需要声明一个包含复合主键属性的类，并实现 java.io.Serializable 接口
    @Embeddable
    public static class CompositeDetail implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "pOrdNo", updatable = false)
        private Integer pOrdNo;
        @Column(name = "pNo", updatable = false)
        private Integer pNo;

        public CompositeDetail() {
            super();
        }

        public CompositeDetail(Integer pOrdNo, Integer pNo) {
            super();
            this.pOrdNo = pOrdNo;
            this.pNo = pNo;
        }

        public Integer getpOrdNo() {
            return pOrdNo;
        }

        public void setpOrdNo(Integer pOrdNo) {
            this.pOrdNo = pOrdNo;
        }

        public Integer getpNo() {
            return pNo;
        }

        public void setpNo(Integer pNo) {
            this.pNo = pNo;
        }

        // 必须重写此类的 hashCode() 和 equals() 方法！
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((pOrdNo == null) ? 0 : pOrdNo.hashCode());
            result = prime * result + ((pNo == null) ? 0 : pNo.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            CompositeDetail other = (CompositeDetail) obj;
            if (pOrdNo == null) {
                if (other.pOrdNo != null)
                    return false;
            } else if (!pOrdNo.equals(other.pOrdNo))
                return false;
            if (pNo == null) {
                if (other.pNo != null)
                    return false;
            } else if (!pNo.equals(other.pNo))
                return false;
            return true;
        }
    }

    public CompositeDetail getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeDetail compositeKey) {
        this.compositeKey = compositeKey;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpOrdQty() {
        return pOrdQty;
    }

    public void setpOrdQty(Integer pOrdQty) {
        this.pOrdQty = pOrdQty;
    }

    public BigDecimal getpRealPrice() {
        return pRealPrice;
    }

    public void setpRealPrice(BigDecimal pRealPrice) {
        this.pRealPrice = pRealPrice;
    }

    public String getpComContent() {
        return pComContent;
    }

    public void setpComContent(String pComContent) {
        this.pComContent = pComContent;
    }

    public Integer getpScore() {
        return pScore;
    }

    public void setpScore(Integer pScore) {
        this.pScore = pScore;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public ProductOrderVO getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrderVO productOrder) {
        this.productOrder = productOrder;
    }
}
