package com.iting.productorderdetail.DAO;


import Util.HibernateUtil;
import com.iting.productorderdetail.model.ProductOrderDetailVO;
import com.iting.productpicture.model.ProductPictureVO;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

public class ProductOrderDetailService {
    private ProductOrderDetailDAO dao;

    public ProductOrderDetailService() {
        dao = new ProductOrderDetailDAOimpl();
    }


    public ProductOrderDetailVO addProductOrderDetailVO(Map<String, String> map) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();


            ProductOrderDetailVO insertedProductOrderDetail = dao.insert(productOrderDetailVO);
            session.getTransaction().commit();
            return insertedProductOrderDetail;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }


//
//
//    public ProductOrderDetailVO updateProductOrderDetailVO(ProductOrderDetailVO productOrderDetailVO) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//
//
//
//    public ProductOrderDetailVO getProductOrderDetailBypOrdNo(Integer pOrdNo) {
//        // TODO Auto-generated method stub
//        return null;
//    }


    public  List<ProductOrderDetailVO> getAllProductOrderDetailVO() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            List<ProductOrderDetailVO> list = dao.getAll();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }


//    public List<ProductOrderDetailVO> getProductOrderDetailByCompositeQuery(Map<String, String[]> map) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Map<String, String> query = new HashMap<>();
//        // Map.Entry即代表一組key-value
//        Set<Map.Entry<String, String[]>> entry = map.entrySet();
//
//        for (Map.Entry<String, String[]> row : entry) {
//            String key = row.getKey();
//            // 因為請求參數裡包含了action，做個去除動作
//            if ("action".equals(key)) {
//                continue;
//            }
//            // 若是value為空即代表沒有查詢條件，做個去除動作
//            String value = row.getValue()[0];
//            if (value.isEmpty() || value == null) {
//                continue;
//            }
//            query.put(key, value);
//        }
//
//        System.out.println(query);
//
//        try {
//            session.beginTransaction();
//            List<ProductOrderDetailVO> list = dao.getByCompositeQuery(query);
//            session.getTransaction().commit();
//            return list;
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }


}
