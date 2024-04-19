package ProductPicture;
import javax.persistence.*;


@Entity
@Table(name = "productpicture")
public class ProductPictureVO implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pPicNo", updatable = false)
	    private Integer pPicNo;
	@Column(name = "pNo")
	    private Integer pNo;

	@Column(name = "pPic", columnDefinition = "longblob")
	    private byte[] pPic;

	public ProductPictureVO() {
		super();
	}

	public ProductPictureVO(Integer pPicNo, Integer pNo, byte[] pPic) {
		super();
		this.pPicNo = pPicNo;
		this.pNo = pNo;
		this.pPic = pPic;
	}

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
	    @Override
	    public String toString() {
			return "ProductPictureVO [pPicNo=" + pPicNo + ", pNo=" + pNo + ", pPic=" + pPic + "]";
		}

		

	
	
}
