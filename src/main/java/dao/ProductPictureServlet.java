package dao;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ProductPictureServlet")
@MultipartConfig
public class ProductPictureServlet extends HttpServlet{


        public void doGet(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
            doPost(req, res);
        }

        public void doPost(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException{

            req.setCharacterEncoding("UTF-8");
            String action = req.getParameter("action");
//
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

                Integer pPicNo = null;
                try {
                    pPicNo = Integer.valueOf(str);
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
                ProductPictureDAO dao = new ProductPictureDAO();
                ProductPictureVO productPictureVO = dao.findByPrimaryKey(Integer.valueOf(req.getParameter("pPicNo")));
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
                req.setAttribute("productPictureVO", productPictureVO); // 資料庫取出的empVO物件,存入req
                String url = "listOnePic.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
                successView.forward(req, res);
            }

            InputStream inputStream = req.getPart("pPic").getInputStream();
            byte[] pPic = null;
            if(inputStream != null){
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[8192]; // 8KB 缓冲区大小，可以根据需要调整
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                pPic = outputStream.toByteArray();
                inputStream.close();
            }
        if ("insert".equals(action)) { // 來自addEmp.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer pNo = null;
            try {
                pNo = Integer.valueOf(req.getParameter("pNo").trim());
            } catch (NumberFormatException e) {
                pNo = 0;
                errorMsgs.put("pNo","請輸入照片編號");
            }
            if (pNo == null) {
                errorMsgs.put("pNo", "商品編號請勿空白");
            }

            ProductPictureVO productPictureVO = new ProductPictureVO();
            productPictureVO.setpNo(pNo);
            productPictureVO.setpPic(pPic);


            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                req.setAttribute("productPictureVO", productPictureVO); // 含有輸入格式錯誤的empVO物件,也存入req
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/addPic.jsp");
                failureView.forward(req, res);
                return;
            }
            ProductPictureService productPictureSvc = new ProductPictureService();
            productPictureVO = productPictureSvc.addProductPicture(pNo,pPic);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/listAllPic.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
            successView.forward(req, res);
        }
        }
//            if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//                Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//                req.setAttribute("errorMsgs", errorMsgs);
//
//                /***************************1.接收請求參數****************************************/
//                Integer pPicNo = Integer.valueOf(req.getParameter("pPicNo"));
//
//                /***************************2.開始查詢資料****************************************/
//                ProductPictureService productPictureSvc = new ProductPictureService();
//                ProductPictureVO productPictureVO = productPictureSvc.getOneProductPicture(pPicNo);
//
//                /***************************3.查詢完成,準備轉交(Send the Success view)************/
//                String param = "?pPicNo="  +productPictureVO.getpPicNo()+
//                        "&pNo="  +productPictureVO.getpNo()+
//                        "&pPic="    +productPictureVO.getpPic();
//                String url = "/update_emp_input.jsp"+param;
//                RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
//                successView.forward(req, res);
//            }
//
//
//            if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//
//                Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//                req.setAttribute("errorMsgs", errorMsgs);
//
//                /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//                Integer pPicNo = Integer.valueOf(req.getParameter("pPicNo").trim());
//                if (pPicNo == null) {
//                    errorMsgs.put("pPicNo","照片編號請勿空白");
//                }
//
//                Integer pNo = Integer.valueOf(req.getParameter("pNo").trim());
//                if (pNo == null) {
//                    errorMsgs.put("pNo","商品編號請勿空白");
//                }
//
//                String pPicParam = req.getParameter("pPic");
//                byte[] pPic = null;
//                if (pPicParam != null) {
//                    pPic = Base64.getDecoder().decode(pPicParam);
//                }


//                String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//                if (ename == null || ename.trim().length() == 0) {
//                    errorMsgs.put("ename","員工姓名: 請勿空白");
//                } else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//                    errorMsgs.put("ename","員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//                }

//                String job = req.getParameter("job").trim();
//                if (job == null || job.trim().length() == 0) {
//                    errorMsgs.put("job","職位請勿空白");
//                }
//
//                java.sql.Date hiredate = null;
//                try {
//                    hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//                } catch (IllegalArgumentException e) {
//                    errorMsgs.put("hiredate","請輸入日期");
//                }
//
//                Double sal = null;
//                try {
//                    sal = Double.valueOf(req.getParameter("sal").trim());
//                } catch (NumberFormatException e) {
//                    errorMsgs.put("sal","薪水請填數字");
//                }
//
//                Double comm = null;
//                try {
//                    comm = Double.valueOf(req.getParameter("comm").trim());
//                } catch (NumberFormatException e) {
//                    errorMsgs.put("comm","獎金請填數字");
//                }
//
//                Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());

                // Send the use back to the form, if there were errors
//                if (!errorMsgs.isEmpty()) {
//                    RequestDispatcher failureView = req
//                            .getRequestDispatcher("/emp/update_emp_input.jsp");
//                    failureView.forward(req, res);
//                    return; //程式中斷
//                }
//
//                /***************************2.開始修改資料*****************************************/
//                ProductPictureService productPictureSvc = new ProductPictureService();
//                ProductPictureVO productPictureVO = productPictureSvc.updateProductPicture(pPicNo,pNo,pPic);
//
//                /***************************3.修改完成,準備轉交(Send the Success view)*************/
//                req.setAttribute("productPictureVO", productPictureVO); // 資料庫update成功後,正確的的empVO物件,存入req
//                String url = "/emp/listOneEmp.jsp";
//                RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//                successView.forward(req, res);
//            }
//



//            if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//                Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//                req.setAttribute("errorMsgs", errorMsgs);
//
//                /***************************1.接收請求參數***************************************/
//                Integer empno = Integer.valueOf(req.getParameter("empno"));
//
//                /***************************2.開始刪除資料***************************************/
//                EmpService empSvc = new EmpService();
//                empSvc.deleteEmp(empno);
//
//                /***************************3.刪除完成,準備轉交(Send the Success view)***********/
//                String url = "/emp/listAllEmp.jsp";
//                RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//                successView.forward(req, res);
//            }
//        }
//    }
        }
