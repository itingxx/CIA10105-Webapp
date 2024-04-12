package ProductPicture;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ProductPictureServlet")
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
                errorMsgs.put("pPic","請輸入照片編號");
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
                errorMsgs.put("pNo", "請輸入照片編號");
            }
            if (str == null || (str.trim()).length() == 0) {
                errorMsgs.put("pNo", "商品編號請勿空白");
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

        if ("update".equals(action)) { // 来自update_emp_input.jsp的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            // 接受請求參數並進行錯誤處理
            Integer pPicNo = Integer.valueOf(req.getParameter("pPicNo").trim());

            String pNo = req.getParameter("pNo");
            if (pNo == null || pNo.trim().isEmpty()) {    // 防呆
                errorMsgs.put("pNo", "請輸入商品編號");
            }

            // 将原始参数放回请求属性中
            req.setAttribute("pPicNo", pPicNo);
            req.setAttribute("pNo", pNo);

            // 獲取圖片數據
            InputStream inputStream = null;
            byte[] pPic = null;
            try {
                Part filePart = req.getPart("pPic");
                if (filePart != null) {
                    inputStream = filePart.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    pPic = outputStream.toByteArray();
                } else {
                    errorMsgs.put("pPic", "請傳照片");
                }
            } catch (IOException | ServletException e) {
                errorMsgs.put("fileUpload", "文件上傳失敗：" + e.getMessage());
                e.printStackTrace(); // 将异常打印出来，方便调试
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        errorMsgs.put("fileUpload", "文件上傳失敗：" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            // 如果有错误，不执行任何跳转，而是在当前页面显示错误消息
            if (!errorMsgs.isEmpty()) {
                // 设置其他可能需要的属性
                // ...
req.setAttribute("pPicNo",pPicNo);
                // 将控制流返回到原始页面
                RequestDispatcher view = req.getRequestDispatcher("/update_productpicture.jsp");
                view.forward(req, res);
                return;
            }

            // 修改數據
            ProductPictureService productPictureSvc = new ProductPictureService();
            ProductPictureVO productPictureVO = productPictureSvc.updateProductPicture(pPicNo, Integer.valueOf(pNo), pPic);

            // 修改成功后转发到成功页面
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
