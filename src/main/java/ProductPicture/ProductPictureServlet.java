package ProductPicture;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@MultipartConfig
public class ProductPictureServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

//            if ("getAll".equals(action)) {
//                /***************************開始查詢資料 ****************************************/
//                ProductPictureDAO dao = new ProductPictureDAO();
//                List<ProductPictureVO> list = dao.getAll();
//
//                /***************************查詢完成,準備轉交(Send the Success view)*************/
//                HttpSession session = req.getSession();
//                session.setAttribute("list", list);    // 資料庫取出的list物件,存入session
//                // Send the Success view
//                String url = "/listAllEmp2_getFromSession.jsp";
//                RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2_getFromSession.jsp
//                successView.forward(req, res);
//                return;
//            }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            String str = req.getParameter("pPicNo");
            if (str == null || (str.trim()).length() == 0) {    //防呆
                errorMsgs.add("請輸入照片編號");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/SelectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }


            try {
                Integer pPicNo = Integer.valueOf(str);
            } catch (Exception e) {
                errorMsgs.add("照片編號格式不正確");
            }
            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/SelectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }
/***************************2.開始查詢資料*****************************************/
            ProductPictureService dao = new ProductPictureService();
            ProductPictureVO productPictureVO = dao.getOneProductPicture(Integer.valueOf(req.getParameter("pPicNo")));
            if (productPictureVO == null) {
                errorMsgs.add("查無資料");
            }
            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/SelectPage.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }


            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("productPictureVO", productPictureVO);
            String url = "listOnePic.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }


        if ("insert".equals(action)) { // 來自addEmp.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);


            String str = req.getParameter("pNo");
            if (str == null || (str.trim()).length() == 0) {    //防呆
                errorMsgs.put("pNo","請輸入照片編號");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/addPic.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }
            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer pNo = null;
            try {
                pNo = Integer.valueOf(req.getParameter("pNo").trim());
            } catch (NumberFormatException e) {
                pNo = 0;
                errorMsgs.put("pNo", "請輸入商品編號");
            }
            if (pNo<=0) {
                errorMsgs.put("pNo", "商品編號格式錯誤");
            }

            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/addPic.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }
            InputStream inputStream = req.getPart("pPic").getInputStream();
            byte[] pPic = null;
            try {
                if (inputStream != null) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    pPic = outputStream.toByteArray();
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }

            if (pPic == null || pPic.length == 0 ) {    //防呆
                errorMsgs.put("pPic","請傳照片");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/addPic.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }
            ProductPictureService productPictureService = new ProductPictureService();
            ProductPictureVO productPictureVO=productPictureService.addProductPicture(pNo,pPic);




            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                req.setAttribute("productPictureVO", productPictureVO); // 含有輸入格式錯誤的empVO物件,也存入req
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/addPic.jsp");
                failureView.forward(req, res);
                return;
            }


            req.setAttribute("productPictureVO", productPictureVO);
            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/listAllPic.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
            successView.forward(req, res);


        }

        if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數****************************************/

            Integer pPicNo = Integer.valueOf(req.getParameter("pPicNo"));
            /***************************2.開始查詢資料****************************************/
            ProductPictureService productPictureSvc = new ProductPictureService();
            ProductPictureVO productPictureVO = productPictureSvc.getOneProductPicture(pPicNo);

            /***************************3.查詢完成,準備轉交(Send the Success view)************/
            req.setAttribute("productPictureVO", productPictureVO);         // 資料庫取出的empVO物件,存入req
            String url = "/update_productpicture.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_emp_inputproductpicture.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            // 接受請求參數並進行錯誤處理
            Integer pPicNo= Integer.valueOf(req.getParameter("pPicNo").trim());


            String str = req.getParameter("pNo");
            if (str == null || (str.trim()).length() == 0) {    //防呆
                errorMsgs.put("pNo", "請輸入商品編號");
            }

            // Send the user back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                ProductPictureService productPictureSvc = new ProductPictureService();
                ProductPictureVO productPictureVO = productPictureSvc.getOneProductPicture(pPicNo);
                req.setAttribute("productPictureVO", productPictureVO);
                RequestDispatcher failureView = req.getRequestDispatcher("/update_productpicture.jsp");
                failureView.forward(req, res);
                return; // 程式中斷
            }

            // 接收請求參數 - 輸入格式的錯誤處理
            Integer pNo = null;
            try {
                pNo = Integer.valueOf(req.getParameter("pNo").trim());
            } catch (NumberFormatException e) {
                pNo = 0;
                errorMsgs.put("pNo", "請輸入商品編號");
            }
            if (pNo<= 0) {
                errorMsgs.put("pNo", "商品編號格式錯誤");
            }


            // Send the user back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                ProductPictureService productPictureSvc = new ProductPictureService();
                ProductPictureVO productPictureVO = productPictureSvc.getOneProductPicture(pPicNo);
                req.setAttribute("productPictureVO", productPictureVO);
                RequestDispatcher failureView = req.getRequestDispatcher("/update_productpicture.jsp");
                failureView.forward(req, res);
                return; // 程式中斷
            }

            // 獲取圖片數據
            InputStream inputStream = req.getPart("pPic").getInputStream();
            byte[] pPic = null;
            try {
                if (inputStream != null) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    pPic = outputStream.toByteArray();
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }

            if (pPic == null || pPic.length == 0 ) {    //防呆
                errorMsgs.put("pPic","請傳照片");
            }

            // Send the user back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                ProductPictureService productPictureSvc = new ProductPictureService();
                ProductPictureVO productPictureVO = productPictureSvc.getOneProductPicture(pPicNo);
                req.setAttribute("productPictureVO", productPictureVO);
                RequestDispatcher failureView = req.getRequestDispatcher("/update_productpicture.jsp");
                failureView.forward(req, res);
                return; // 程式中斷
            }

            // 修改數據
            ProductPictureService productPictureSvc = new ProductPictureService();
            ProductPictureVO productPictureVO = productPictureSvc.updateProductPicture(pPicNo, pNo, pPic);

            // 再次設置 productPictureVO
            req.setAttribute("productPictureVO", productPictureVO);

            String url = "/listOnePic.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);
        }




        if ("delete".equals(action)) { // 來自listAllEmp.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer pPicNo = Integer.valueOf(req.getParameter("pPicNo"));

            /***************************2.開始刪除資料***************************************/
            ProductPictureService productPictureSvc = new ProductPictureService();
            productPictureSvc.delete(pPicNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/listAllPic.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
            successView.forward(req, res);
        }
    }
}

