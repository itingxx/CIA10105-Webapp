package ProductMyFavorite.model;


import javax.persistence.*;

@Entity
@Table(name = "productmyfavorite")
public class ProductMyFavoriteVO {
    @Id
    @Column(name = "pNo", updatable = false)
    private Integer pNo;
    @Id
    @Column(name = "memNo", updatable = false)
    private Integer memNo;



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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pNo", referencedColumnName = "pNo")
    private ProductVO productVO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memNo", referencedColumnName = "memNo")
    private MemberVO  memberVO;

    public ProductVO getproductVO() {
        return productVO;
    }

    public void setproductVO(ProductVO productVO) {
        this.productVO = productVO;
    }
    public MemberVO getmemberVO() {
        return memberVO;
    }

    public void setmemberVO(MemberVO memberVO) {
        this.memberVO = memberVO;
    }


}
