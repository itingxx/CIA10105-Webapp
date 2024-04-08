package dao;
import java.util.List;
import java.util.Set;

public class ProductPictureService {

    private ProductPicture_interface dao;

    public ProductPictureService() {
//		dao = new EmpJDBCDAO();
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
    public void addProductPicture(ProductPictureVO productPictureVO) {
        dao.insert(productPictureVO);
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
    public void updateProductPicture(ProductPictureVO productPictureVO) {
        dao.update(productPictureVO);
    }

//    public void deleteEmp(Integer empno) {
//        dao.delete(empno);
//    }

    public ProductPictureVO getOneProductPicture(Integer pPicNo) {
        return dao.findByPrimaryKey(pPicNo);
    }

    public List<ProductPictureVO> getAll() {
        return dao.getAll();
    }
}
