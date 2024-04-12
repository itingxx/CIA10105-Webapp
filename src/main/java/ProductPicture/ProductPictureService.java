package ProductPicture;
import java.util.List;

public class ProductPictureService {

    private ProductPicture_interface dao;

    public ProductPictureService() {
        dao = new ProductPictureDAO();
    }



        public ProductPictureVO addProductPicture(Integer pNo,byte[] pPic) {

        ProductPictureVO productPictureVO = new ProductPictureVO();


        productPictureVO.setpNo(pNo);
        productPictureVO.setpPic(pPic);

        dao.insert(productPictureVO);

        return productPictureVO;
    }

    //預留給 Struts 2 或 Spring MVC 用
    public ProductPictureVO addPicture(ProductPictureVO productPictureVO) {
        return productPictureVO;
    }

    public ProductPictureVO updateProductPicture(Integer pPicNo,Integer pNo,byte[] pPic) {

        ProductPictureVO productPictureVO = new ProductPictureVO();

        productPictureVO.setpPicNo(pPicNo);
        productPictureVO.setpNo(pNo);
        productPictureVO.setpPic(pPic);
        dao.update(productPictureVO);

        return dao.findByPrimaryKey(pPicNo);
    }

    //預留給 Struts 2 用的
//    public void updateProductPicture(ProductPictureVO productPictureVO) {
//        dao.update(productPictureVO);
//    }



    public ProductPictureVO getOneProductPicture(Integer pPicNo) {
        return dao.findByPrimaryKey(pPicNo);
    }
    public void delete(Integer pPicNo) {
        dao.delete(pPicNo);
    }
    public List<ProductPictureVO> getAll() {
        return dao.getAll();
    }
}
