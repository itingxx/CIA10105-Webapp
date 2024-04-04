package dao;

public class ProductPictureVO {
	
	    private Integer pPicNo;
	    private Integer pNo;
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
	    @Override
	    public String toString() {
			return "ProductPictureVO [pPicNo=" + pPicNo + ", pNo=" + pNo + ", pPic=" + pPic + "]";
		}

		

	
	
}
