package dao;
import java.util.List;

public class ProductPictrueService {

        private ProductPicture_interface dao;

        public ProductPictrueService() {
          dao = new ProductPictureDAO();
        }

        public ProductPictureVO addPic(Integer pPicNo, Integer pNo, byte[] pPic) {

            ProductPictureVO productPictrueVO = new ProductPictureVO();

            productPictrueVO.setpPicNo(pPicNo);
            productPictrueVO.setpNo(pNo);
            productPictrueVO.setpPic(pPic);
            dao.insert(productPictrueVO);

            return productPictrueVO;
        }
    public List<ProductPictureVO> getAll() {
        return dao.getAll();
    }
}
