package Cart.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class CartVO {

    @EmbeddedId
    private CompositeDetail2 compositeKey2;
    @Column(name = "pBuyQty")
        private Integer pBuyQty;

    public CompositeDetail2 getcompositeKey2() {
        return compositeKey2;
    }

    public void setcompositeKey2(CompositeDetail2 compositeKey) {
        this.compositeKey2 = compositeKey2;}
        public Integer getpBuyQty() {
            return pBuyQty;
        }
        public void setpBuyQty(Integer pBuyQty) {
            this.pBuyQty = pBuyQty;
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
    @ManyToOne
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO  memberVO;
    //優惠券一對多未設
    // fetch 預設為 EAGER
    @ManyToOne
    @JoinColumn(name = "pNo", referencedColumnName = "pNo")
    private ProductVO productVO;
    public MemberVO getmemberVO() {
        return memberVO;
    }
    public void setmemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }
    public ProductVO getproductVO() {
        return productVO;
    }
    public void setproductVO(ProductVO productVO) {
        this.productVO = productVO;
    }
}


