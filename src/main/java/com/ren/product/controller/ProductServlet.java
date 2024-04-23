//package com.ren.product.controller;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.regex.Pattern;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.ren.product.model.ProductVO;
//import com.ren.product.service.ProductServiceImpl;
//import com.ren.product.service.ProductService_interface;
//import com.ren.productcategory.model.ProductCategoryVO;
//
//@WebServlet("/product/product.do")
//public class ProductServlet extends HttpServlet {
//    /*****************************常數區***************************************/
//    // 請輸入表格名稱:
//    private final String TABLE_NAME = "商品";
//    // 網址
//    private final String SELECT = "/product/select_product.jsp";
//    private final String LIST_ONE = "/product/listOneProduct.jsp";
//    private final String LIST_ALL = "/product/listAllProduct.jsp";
//    private final String ADD = "/product/addProduct.jsp";
//    private final String UPDATE = "/product/update_product_input.jsp";
//    /*****************************參數區***************************************/
////    Integer pNo = null;
////    Integer pCatNo = null;
////    String pName = null;
////    String pInfo = null;
////    Integer pSize = null;
////    String pColor = null;
////    BigDecimal pPrice = null;
////    Byte pStat = null;
////    Integer pSalQty = null;
////    Integer pComPeople = null;
////    Integer pComScore = null;
////    req.getParameter("pNo");
////    req.getParameter("pCatNo");
////    req.getParameter("pName");
////    req.getParameter("pInfo");
////    req.getParameter("pSize");
////    req.getParameter("pColor");
////    req.getParameter("pPrice");
////    req.getParameter("pStat");
////    req.getParameter("pSalQty");
////    req.getParameter("pComPeople");
////    req.getParameter("pComScore");
//
//    private ProductService_interface productService;
//
//    @Override
//    public void init() throws ServletException {
//        productService = new ProductServiceImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        doPost(req, res);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//        String forwardPath = "";
//        switch (action) {
//            case "insert":
//                forwardPath = insert(req, res);
//                break;
//            case "getOne_For_Display":
//                forwardPath = getOne(req, res);
//                break;
//            case "getOne_For_Update":
//                forwardPath = getOneForUpdate(req, res);
//                break;
//            // 先關
////            case "compositeQuery":
////                forwardPath = insert(req, res);
////                break;
//            case "update":
//                forwardPath = update(req, res);
//                break;
//            case "delete":
//                forwardPath = delete(req, res);
//                break;
//            case "getProdcutDetails":
//                getProductDetails(req, res);
//                break;
//            default:
//                forwardPath = SELECT;
//        }
//
//        res.setContentType("text/html; charset=UTF-8");
//        RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
//        dispatcher.forward(req, res);
//    }
//
//    private String getOne(HttpServletRequest req, HttpServletResponse res) {
//
//        List<String> errorMsgs = new LinkedList<>();
//        // Store this set in the request scope, in case we need to
//        // send the ErrorPage view.
//        req.setAttribute("errorMsgs", errorMsgs);
//
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//        Integer pNo = checkSerialNumber(req.getParameter("pNo"), errorMsgs);
//        // Send the use back to the form, if there were errors
//        if (!errorMsgs.isEmpty()) {
//            return SELECT;// 程式中斷
//        }
//
//        /*************************** 2.開始查詢資料 *****************************************/
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        // 執行Service的getOnProduct，該方法執行DAO的findByPrimaryKey，將資料庫內的資料以VO的形式傳回
//        ProductVO productVO = productSvc.getOneProduct(pNo);
//        // 引用類型的屬性在未附值時預設為null
//        if (productVO == null) {
//            errorMsgs.add("查無資料");
//        }
//        // Send the use back to the form, if there were errors
//        if (!errorMsgs.isEmpty()) {
//            return SELECT;// 程式中斷
//        }
//
//        /*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//        req.setAttribute("productVO", productVO); // 資料庫取出的productVO物件,存入req
//        return LIST_ONE;
//    }
//
//    private String getOneForUpdate(HttpServletRequest req, HttpServletResponse res) {
//        // 作轉傳資料使用
//
//        // 當點擊修改時，透過Service呼叫dao的查詢單項方法來獲得該資料的VO，傳到修改頁面
//        List<String> errorMsgs = new LinkedList<>();
//        // Store this set in the request scope, in case we need to
//        // send the ErrorPage view.
//        req.setAttribute("errorMsgs", errorMsgs);
//
//        /*************************** 1.接收請求參數 ****************************************/
//        Integer pNo = checkInteger(req.getParameter("pNo"), errorMsgs);
//
//        /*************************** 2.開始查詢資料 ****************************************/
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        ProductVO productVO = productSvc.getOneProduct(pNo);
//
//        /*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
//        req.setAttribute("productVO", productVO); // 資料庫取出的productVO物件,存入req
//        return UPDATE;
//    }
//
//    private String update(HttpServletRequest req, HttpServletResponse res) {
//        List<String> errorMsgs = new LinkedList<>();
//        // Store this set in the request scope, in case we need to
//        // send the ErrorPage view.
//        req.setAttribute("errorMsgs", errorMsgs);
//
//        /*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//        Integer pNo = checkInteger(req.getParameter("pNo"), errorMsgs);
//        Integer pCatNo = checkInteger(req.getParameter("pCatNo"), errorMsgs);
//        String pName = checkString(req.getParameter("pName"), errorMsgs);
//        String pInfo = checkString(req.getParameter("pInfo"), errorMsgs);
//        Integer pSize = checkInteger(req.getParameter("pSize"), errorMsgs);
//        String pColor = checkString(req.getParameter("pColor"), errorMsgs);
//        BigDecimal pPrice = checkBigDecimal(req.getParameter("pPrice"), errorMsgs);
//        Byte pStat = checkByte(req.getParameter("pStat"), errorMsgs);
//        Integer pSalQty = checkInteger(req.getParameter("pSalQty"), errorMsgs);
//        Integer pComPeople = checkInteger(req.getParameter("pComPeople"), errorMsgs);
//        Integer pComScore = checkInteger(req.getParameter("pComScore"), errorMsgs);
//
//        // Send the use back to the form, if there were errors
//        if (!errorMsgs.isEmpty()) {
//            return UPDATE; // 程式中斷
//        }
//
//        ProductCategoryVO productCategory = new ProductCategoryVO(pCatNo);
//        ProductVO product = new ProductVO(pNo, productCategory, pName, pInfo, pSize, pColor, pPrice, pStat, pSalQty, pComPeople, pComScore);
//
//        /*************************** 2.開始修改資料 *****************************************/
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        ProductVO updatedProduct = productSvc.updateProduct(product);
//
//        /*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//        req.setAttribute("productVO", updatedProduct); // 資料庫update成功後,正確的的productVO物件,存入req
//        return LIST_ONE;
//    }
//
//    private String insert(HttpServletRequest req, HttpServletResponse res) {
//
//        List<String> errorMsgs = new LinkedList<>();
//        // Store this set in the request scope, in case we need to
//        // send the ErrorPage view.
//        req.setAttribute("errorMsgs", errorMsgs);
//
//        /*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//        Integer pCatNo = checkInteger(req.getParameter("pCatNo"), errorMsgs);
//        String pName = checkString(req.getParameter("pName"), errorMsgs);
//        String pInfo = checkString(req.getParameter("pInfo"), errorMsgs);
//        Integer pSize = checkInteger(req.getParameter("pSize"), errorMsgs);
//        String pColor = checkString(req.getParameter("pColor"), errorMsgs);
//        BigDecimal pPrice = checkBigDecimal(req.getParameter("pPrice"), errorMsgs);
//        Byte pStat = checkByte(req.getParameter("pStat"), errorMsgs);
//        Integer pSalQty = checkInteger(req.getParameter("pSalQty"), errorMsgs);
//        Integer pComPeople = checkInteger(req.getParameter("pComPeople"), errorMsgs);
//        Integer pComScore = checkInteger(req.getParameter("pComScore"), errorMsgs);
//
//        // Send the use back to the form, if there were errors
//        if (!errorMsgs.isEmpty()) {
//            return SELECT;
//        }
//        ProductCategoryVO productCategory = new ProductCategoryVO(pCatNo);
//        ProductVO product = new ProductVO(productCategory, pName, pInfo, pSize, pColor, pPrice, pStat, pSalQty, pComPeople, pComScore);
//        /*************************** 2.開始新增資料 ***************************************/
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        productSvc.addProduct(product);
//
//        /*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//        return LIST_ALL;
//    }
//
//    private String delete(HttpServletRequest req, HttpServletResponse res) {
//        List<String> errorMsgs = new LinkedList<>();
//        // Store this set in the request scope, in case we need to
//        // send the ErrorPage view.
//        req.setAttribute("errorMsgs", errorMsgs);
//        /*************************** 1.接收請求參數 ***************************************/
//        Integer pNo = checkInteger(req.getParameter("pNo"), errorMsgs);
//
//        /*************************** 2.開始刪除資料 ***************************************/
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        productSvc.deleteProduct(pNo);
//
//        /*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
//        return LIST_ALL;
//    }
//
//    private void getProductDetails(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        Integer pNo = Integer.valueOf(req.getParameter("pNo").trim());
//
//        // 根据商品编号获取商品的详细信息
//        ProductServiceImpl productSvc = new ProductServiceImpl();
//        ProductVO productVO = productSvc.getOneProduct(pNo);
//
//        if (productVO != null) {
//            // 将商品详细信息转换为 JSON 格式
//            Gson gson = new Gson();
//            String json = gson.toJson(productVO);
//
//            // 设置响应类型为 JSON
//            res.setContentType("application/json");
//            res.setCharacterEncoding("UTF-8");
//
//            // 将 JSON 数据发送到客户端
//            res.getWriter().write(json);
//        } else {
//            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//
//    /******************************正則表達式區*********************************/
//    // 只包含中文字符、英文大小寫、數字及下劃線
//    private final Pattern inputRegex = Pattern.compile("^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$");
//    // 密碼格式(至少包含一個大寫字母、一個小寫字母、一個數字、一個特殊字符)
//    private final Pattern passwordRegex = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,12}$");
//    // 只能輸入中文格式
//    private final Pattern hzRegex = Pattern.compile("^[\\u4e00-\\u9fa5]+$");
//    // 只能輸入數字格式
//    private final Pattern numberRegex = Pattern.compile("^[0-9]+$");
//    // email格式
//    private final Pattern emailRegex = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
//
//    /******************************參數驗證區***********************************/
//    // 驗證是否為空值或空字串
//    private Boolean validateSpace(String requestParameter) {
//        return requestParameter != null && requestParameter.trim().length() == 0;
//    }
//
//    // 驗證輸入內容格式
//    private Boolean validateInput(String input) {
//        return inputRegex.matcher(input).find();
//    }
//
//    // 驗證密碼格式
//    private Boolean validatePassword(String password) {
//        return passwordRegex.matcher(password).find();
//    }
//
//    // 驗證中文格式
//    private Boolean validateHz(String hz) {
//        return hzRegex.matcher(hz).find();
//    }
//
//    // 驗證數字格式
//    private Boolean validateNumber(String number) {
//        return numberRegex.matcher(number).find();
//    }
//
//    // 驗證信箱格式
//    private Boolean validateEmail(String email) {
//        return emailRegex.matcher(email).find();
//    }
//
//    /**********錯誤處理區**********/
//    // 編號的錯誤處理
//    private Integer checkSerialNumber(String parameter, List<String> errorMsgs) {
//        if (!validateSpace(parameter)) {
//            // 因為使用兩次 + 會 new 兩次 StringBuilder物件，這裡直接新增一個StringBuilder物件
//            // 請輸入 表格名稱 編號
//            errorMsgs.add(new StringBuilder("請輸入")
//                    .append(TABLE_NAME)
//                    .append("編號")
//                    .toString());
//        }
//        Integer value = null;
//        // 轉型成Integer型態
//        try {
//            value = Integer.valueOf(parameter);
//        } catch (Exception e) {
//            errorMsgs.add(TABLE_NAME + "編號格式不正確");
//        }
//        return value;
//    }
//
//    // 整數的錯誤處理
//    private Integer checkInteger(String parameter, List<String> errorMsgs) {
//        // 轉型成Integer型態
//        Integer value = null;
//        try {
//            value = Integer.valueOf(parameter);
//        } catch (Exception e) {
//            errorMsgs.add(TABLE_NAME + "編號格式不正確");
//        }
//        return value;
//    }
//
//    // Byte的錯誤處理
//    private Byte checkByte(String parameter, List<String> errorMsgs) {
//        if (!validateSpace(parameter)) {
//            errorMsgs.add(TABLE_NAME + "狀態: 請勿空白");
//        }
//        Byte value = null;
//        try {
//            value = Byte.valueOf(parameter);
//        } catch (NumberFormatException e) {
//            value = Byte.valueOf("0");
//            errorMsgs.add(TABLE_NAME + "狀態請填數字.");
//        }
//        return value;
//    }
//
//    // 字串的錯誤處理
//    private String checkString(String parameter, List<String> errorMsgs) {
//        if (!validateSpace(parameter)) {
//            errorMsgs.add(TABLE_NAME + "名稱: 請勿空白");
//        } else if (!validateInput(parameter.trim())) { // 以下練習正則(規)表示式(regular-expression)
//            errorMsgs.add(TABLE_NAME + "名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//        }
//        return parameter;
//    }
//
//    // BigDecimal的錯誤處理
//    private BigDecimal checkBigDecimal(String parameter, List<String> errorMsgs) {
//        BigDecimal value = null;
//        try {
//            value = new BigDecimal(parameter.trim());
//        } catch (NumberFormatException e) {
//            value = BigDecimal.ZERO;
//            errorMsgs.add(TABLE_NAME + "價格請填數字.");
//        }
//        return value;
//    }
//
//    // Date的錯誤處理
//    private Date checkDate(String parameter, List<String> errorMsgs) {
//        Date value = null;
//        try {
//            value = Date.valueOf(parameter.trim());
//        } catch (IllegalArgumentException e) {
//            errorMsgs.add("請輸入日期");
//        }
//        return value;
//    }
//
//    // Timestamp的錯誤處理
//    private Timestamp checkTimestamp(String parameter, List<String> errorMsgs) {
//        Timestamp value = null;
//        try {
//            value = Timestamp.valueOf(parameter.trim());
//        } catch (IllegalArgumentException e) {
//            errorMsgs.add("請輸入日期時間");
//        }
//        return value;
//    }
//
//}
