package com.iting.productorderdetail.DAO;


import com.iting.productorderdetail.model.ProductOrderDetailVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/ProductOrderDetail/productOrderDetail.do")
public class ProductOrderDetailServlet extends HttpServlet {


        // 一個 servlet 實體對應一個 service 實體
        private ProductOrderDetailService productOrderDetailService;

        @Override
        public void init() throws ServletException {
            productOrderDetailService = new  ProductOrderDetailService();
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            String action = req.getParameter("action");
            String forwardPath = "";
            switch (action) {
                case "getAll":
                    forwardPath = getAllProductOrderDetail(req, res);
                    break;
//                case "compositeQuery":
//                    forwardPath = getproductOrderDetailByCompositeQuery(req, res);
//                    break;
                default:
                    forwardPath = "/index.jsp";
            }

            res.setContentType("text/html; charset=UTF-8");
            RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
            dispatcher.forward(req, res);
        }

        private String getAllProductOrderDetail(HttpServletRequest req, HttpServletResponse res) {
            List<ProductOrderDetailVO> productOrderDetailList = productOrderDetailService.getAllProductOrderDetailVO();

            req.setAttribute("productOrderDetailList", productOrderDetailList);

            return "/ProductOrderDetail/listAllProductOrderDetail.jsp";
        }

//        private String getproductOrderDetailByCompositeQuery(HttpServletRequest req, HttpServletResponse res) {
//            Map<String, String[]> map = req.getParameterMap();
//
//            if (map != null) {
//                List<ProductOrderDetailVO> productOrderDetailList =  productOrderDetailService.getProductOrderDetailByCompositeQuery(map);
//                req.setAttribute("productOrderDetailList", productOrderDetailList);
//            } else {
//                return "/index.jsp";
//            }
//            return "/productOrderDetail/listCompositeQueryproductOrderDetail.jsp";
//        }


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doPost(req, res);
        }
}
