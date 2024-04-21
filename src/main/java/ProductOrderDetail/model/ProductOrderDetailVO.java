package ProductOrderDetail.model;

import ProductOrder.model.ProductOrderVO;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;



@Entity
@Table(name = "productorderdetail")
public class ProductOrderDetailVO {


@EmbeddedId
private  CompositeDetail compositeKey;


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

	public CompositeDetail getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(CompositeDetail compositeKey) {
		this.compositeKey = compositeKey;}




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










    // 需要宣告一個有包含複合主鍵屬性的類別，並一定實作 java.io.Serializable 介面
	@Embeddable
	public static class CompositeDetail implements Serializable {
		private static final long serialVersionUID = 1L;
		@Column(name = "pOrdNo", updatable = false)
		private Integer pOrdNo;
		@Column(name = "pNo", updatable = false)
		private Integer pNo;

    public CompositeDetail(){
        super();
}
    public CompositeDetail(Integer pOrdNo,Integer pNo){
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
     //一定要 override 此類別的 hashCode() 與 equals() 方法！
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

			if (obj != null && getClass() == obj.getClass()) {
				CompositeDetail compositeKey = (CompositeDetail) obj;
				if (pOrdNo.equals(compositeKey.pOrdNo) && pNo.equals(compositeKey.pNo)) {
					return true;
				}
			}

			return false;
		}
}
    // fetch 預設為 EAGER
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo")
    private ProductVO productVO;


    @ManyToOne
    @JoinColumn(name = "pOrdNo", referencedColumnName = "pOrdNo")
    private ProductOrderVO productOrderVO ;

    public ProductVO getproductVO() {
        return productVO;
    }

    public void setproductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public ProductOrderVO getproductOrderVO() {
        return productOrderVO;
    }

    public void setproductOrderVO(ProductOrderVO productOrderVO) {
        this.productOrderVO = productOrderVO;
    }
}
