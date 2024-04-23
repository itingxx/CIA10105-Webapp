package com.iting.productpicture.DAO;

import com.iting.productpicture.DAO.ProductPictureDAO;
import com.iting.productpicture.model.ProductPictureVO;
import com.ren.product.model.ProductVO;

import java.util.List;

public class ProductPictureService {

    private ProductPictureDAO dao;

    public ProductPictureService() {
        dao = new ProductPictureDAO();//將介面型態
    }


    //增加資料
    public ProductPictureVO addProductPicture(Integer pNo, byte[] pPic) {
        ProductPictureVO productPictureVO = new ProductPictureVO();
        ProductVO product = new ProductVO();
        product.setpNo(pNo);
        productPictureVO.setProduct(product);
        productPictureVO.setpPic(pPic);
        dao.insert(productPictureVO);
        return productPictureVO;
    }

    //預留給 Struts 2 或 Spring MVC 用


    public ProductPictureVO updateProductPicture(Integer pPicNo, Integer pNo, byte[] pPic) {
        // 创建 ProductPictureVO 对象
        ProductPictureVO productPictureVO = new ProductPictureVO();

        // 设置照片编号
        productPictureVO.setpPicNo(pPicNo);

        // 创建 ProductVO 对象并设置商品编号
        ProductVO product = new ProductVO();
        product.setpNo(pNo);

        // 将 ProductVO 对象设置到 ProductPictureVO 对象中
        productPictureVO.setProduct(product);

        // 设置图片数据
        productPictureVO.setpPic(pPic);

        // 调用 DAO 层的更新方法
        dao.update(productPictureVO);

        // 返回更新后的 ProductPictureVO 对象
        return dao.findByPrimaryKey(pPicNo);
    }


    //預留給 Struts 2 用的
//    public void updateProductPicture(ProductPictureVO productPictureVO) {
//        dao.update(productPictureVO);
//    }


    //查詢一筆資料
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