//package Cart;
//
//
//import java.util.List;
//
//public class CartService {
//    private CartDAO dao;
//
//    public CartService() {
//        dao = new CartDAO();//將介面型態
//    }
//
//
//    //增加資料
//    public CartVO addProductPicture(Integer pNo, Integer pPic) {
//        CartVO CartVO = new CartVO();
//        CartVO.setpNo(pNo);
//        CartVO.setmemNo(pPic);
//        dao.insert(CartVO);
//        return CartVO;
//    }
//
//    //預留給 Struts 2 或 Spring MVC 用
//
//
//    public CartVO updateProductPicture(Integer pPicNo, Integer pNo, Integer pPic) {
//
//        CartVO CartVO = new CartVO();
//
//        CartVO.setpNo(pNo);
//        CartVO.setmemNo(pmemNo);
//        CartVO.setpPic(pPic);
//        dao.update(CartVO);
//
//        return dao.findByPrimaryKey(pPicNo);
//    }
//
//    //預留給 Struts 2 用的
////    public void updateProductPicture(CartVO CartVO) {
////        dao.update(CartVO);
////    }
//
//
//    //查詢一筆資料
//    public ProductOrderVO getOneProductPicture(Integer pPicNo) {
//        return dao.findByPrimaryKey(pPicNo);
//    }
//
//    public void delete(Integer pPicNo) {
//        dao.delete(pPicNo);
//    }
//
//    public List<ProductPictureVO> getAll() {
//        return dao.getAll();
//    }
//}
