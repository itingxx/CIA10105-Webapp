//package ProductOrder;
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.List;
//
//public class ProductOrderService {
//    /*
//     * 共有6個方法(照 增、刪、改、查 順序由上而下) :
//     *
//     * 1. addOrder -> 新增訂單
//     * 		參數有20 : memNo(會員編號)、rByrName(訂購人姓名)、rByrPhone(訂購人手機號碼)、rByrEmail(訂購人Email)、
//     *                rRcvName(收件人姓名)、rRcvPhone(收件人手機號碼)、rTakeMethod(取貨方式)、rAddr(宅配住址)、
//     *                rPayMethod(付款方式)、rAllPrice(訂單總金額)、rAllDepPrice(押金總金額)、rOrdTime(下單時間)、
//     *                rDate(預計租借日期)、rBackDate(預計歸還日期)、rRealBackDate(實際歸還日期)、rPayStat(付款狀態)、
//     *                rOrdStat(訂單狀態)、rtnStat(歸還狀態)、rtnRemark(歸還註記)、rtnCompensation(賠償金額)
//     * 		回傳值 : 該筆新增訂單
//     *
//     * 2. deleteOrder -> 刪除訂單
//     * 		參數有1 : rOrdNo(租借品訂單編號)
//     * 		無回傳值
//     *
//     * 3. updateOrder -> 修改訂單資料
//     * 		參數有21 : rOrdNo(租借品訂單編號)、memNo(會員編號)、rByrName(訂購人姓名)、rByrPhone(訂購人手機號碼)、
//     *                rByrEmail(訂購人Email)、rRcvName(收件人姓名)、rRcvPhone(收件人手機號碼)、rTakeMethod(取貨方式)、
//     *                rAddr(宅配住址)、rPayMethod(付款方式)、rAllPrice(訂單總金額)、rAllDepPrice(押金總金額)、
//     *                rOrdTime(下單時間)、rDate(預計租借日期)、rBackDate(預計歸還日期)、rRealBackDate(實際歸還日期)、
//     *                rPayStat(付款狀態)、rOrdStat(訂單狀態)、rtnStat(歸還狀態)、rtnRemark(歸還註記)、
//     *                rtnCompensation(賠償金額)
//     * 		回傳值 : 該筆被修改的訂單
//     *
//     * 4. getOneOrder -> 用 PK 查詢單筆訂單
//     * 		參數有1 : rOrdNo(租借品訂單編號)
//     * 		回傳值 : 該筆查詢的訂單
//     *
//     * 5. getOneOrderByName -> 用 訂購人姓名 查詢訂單
//     *      參數有1 : rByrName(訂購人姓名)
//     * 		回傳值 : 裝著所有訂單的 ArrayList
//     *
//     * 6. getAll -> 查詢所有訂單
//     * 		參數有0
//     * 		回傳值 : 裝著所有資料的 ArrayList
//     */
// private ProductOrderDAO dao;
//
//public ProductOrderService(){
//    dao=new ProductOrderDAO();
//}
//    public ProductOrderVO addOrder(Integer pOrdNo,
//                                   Integer memNo,
//                                   String pByrName,
//                                   Integer pByrPhone,
//                                   String pByrEmail,
//                                   String pRcvName,
//                                   String pRcvPhone,
//                                   Byte pTakeMethod,
//                                   String pAddr,
//                                   Byte pPayMethod,
//                                   BigDecimal pAllPrice,
//                                   Integer coupNo,
//                                   BigDecimal pDisc,
//                                   BigDecimal pRealPric,
//                                   Timestamp pOrdTime,
//                                   Byte pOrdStat,
//                                   Byte pStat) {
//
//       ProductOrderVO productOrderVO = new ProductOrderVO();
//
//        productOrderVO.setpOrdNo(pOrdNo);
//        productOrderVO.setmemNo(memNo);
//        productOrderVO.setpByrName(pByrName);
//        productOrderVO.setpByrPhone(pByrPhone);
//        productOrderVO.setpByrEmail(pByrEmail);
//        productOrderVO.setpRcvName(pRcvName);
//        productOrderVO.setpRcvPhone(pRcvPhone);
//        productOrderVO.setpTakeMethod(pTakeMethod);
//        productOrderVO.setpAddr(pAddr);
//        productOrderVO.setpPayMethod(pPayMethod);
//        productOrderVO.setpAllPrice(pAllPrice);
//        productOrderVO.setcoupNo(coupNo);
//        productOrderVO.setpDisc(pDisc);
//        productOrderVO.setpRealPric(pRealPric);
//        productOrderVO.setpOrdTime(pOrdTime);
//        productOrderVO.setpOrdStat(pOrdStat);
//        productOrderVO.setpStat(pStat);
//
//        dao.insert(productOrderVO);
//        return productOrderVO;
//
//    }
//
//
//    public void deleteOrder(Integer pOrdNo) {
//        dao.delete(pOrdNo);
//    }
//
//
//    public ProductOrderVO updateOrder(Integer pOrdNo,
//                                      Integer memNo,
//                                      String pByrName,
//                                      Integer pByrPhone,
//                                      String pByrEmail,
//                                      String pRcvName,
//                                      String pRcvPhone,
//                                      Byte pTakeMethod,
//                                      String pAddr,
//                                      Byte pPayMethod,
//                                      BigDecimal pAllPrice,
//                                      Integer coupNo,
//                                      BigDecimal pDisc,
//                                      BigDecimal pRealPric,
//                                      Timestamp pOrdTime,
//                                      Byte pOrdStat,
//                                      Byte pStat)
//    {
//        ProductOrderVO productOrderVO = new ProductOrderVO();
//
//       ProductOrderVO.setpOrdNo(pOrdNo);
//       ProductOrderVO.setmemNo(memNo);
//       ProductOrderVO.setpByrName(pByrName);
//       ProductOrderVO.setpByrPhone(pByrPhone);
//       ProductOrderVO.setpByrEmail(pByrEmail);
//       ProductOrderVO.setpRcvName(pRcvName);
//       ProductOrderVO.setpRcvPhone(pRcvPhone);
//       ProductOrderVO.setpTakeMethod(pTakeMethod);
//       ProductOrderVO.setpAddr(pAddr);
//       ProductOrderVO.setpPayMethod(pPayMethod);
//       ProductOrderVO.setpAllPrice(pAllPrice);
//       ProductOrderVO.setcoupNo(coupNo);
//       ProductOrderVO.setpDisc(pDisc);
//       ProductOrderVO.setpRealPric(pRealPric);
//       ProductOrderVO.setpOrdTime(pOrdTime);
//       ProductOrderVO.setpOrdStat(pOrdStat);
//       ProductOrderVO.setpStat(pStat);
//
//        dao.update(ProductOrderVO);
//
//        return dao.findByPK(pOrdNo);
//
//    }
//
//
//    public ProductOrderVO getOneOrder(Integer pOrdNo) {
//        return dao.findByPK(pOrdNo);
//    }
//
//    public List<ProductOrderVO> getOneOrderByName(String pByrName) {
//        return dao.findByName(pByrName);
//    }
//
//
//    public List<ProductOrderVO> getAll() {
//        return dao.getAll();
//    }
//}
