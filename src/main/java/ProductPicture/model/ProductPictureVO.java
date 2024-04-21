package ProductPicture.model;
import javax.persistence.*;


@Entity
@Table(name = "productpicture")
public class ProductPictureVO implements java.io.Serializable {
	@Id
	@Column(name = "pPicNo", updatable = false)
	    private Integer pPicNo;
	@Column(name = "pNo")
	    private Integer pNo;

	@Column(name = "pPic", columnDefinition = "longblob")
	    private byte[] pPic;


	public Integer getpPicNo() {
			return pPicNo;
		}

		public void setpPicNo(Integer pPicNo) {
			this.pPicNo = pPicNo;
		}

		public byte[] getpPic() {
			return pPic;
		}

		public void setpPic(byte[] pPic) {
			this.pPic = pPic;
		}

		public Integer getpNo() {
	        return pNo;
	    }

	    public void setpNo(Integer pNo) {
	        this.pNo = pNo;
	    }



	@ManyToOne
	@JoinColumn(name = "pNo", referencedColumnName = "pNo")
	private ProductVO productVO;

	public ProductVO getproductVO() {
		return productVO;
	}

	public void setproductVO(ProductVO productVO) {
		this.productVO = productVO;
	}


}
