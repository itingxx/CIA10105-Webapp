package ProductMyFavorite;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productmyfavorite")
public class ProductMyFavoriteVO {
    @Id
    @Column(name = "pNo", updatable = false)
    private Integer pNo;
    @Id
    @Column(name = "memNo", updatable = false)
    private Integer memNo;

    public ProductMyFavoriteVO() {
        super();
    }

    public ProductMyFavoriteVO(Integer pNo, Integer memNo) {
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
}
