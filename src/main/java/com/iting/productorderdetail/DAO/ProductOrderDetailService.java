package com.iting.productorderdetail.DAO;


import Util.HibernateUtil;
import com.iting.productorderdetail.model.ProductOrderDetailVO;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductOrderDetailService {
    private ProductOrderDetailDAO dao;

    public ProductOrderDetailService() {
        dao = new ProductOrderDetailDAOimpl();
    }


    public ProductOrderDetailVO addProductOrderDetailVO(Map<String, String[]> map) {
        ProductOrderDetailVO productOrderDetailVO = new ProductOrderDetailVO();
        ProductOrderDetailVO.CompositeDetail compositeKey = new ProductOrderDetailVO.CompositeDetail();
        if (map.containsKey("pOrdNo") && map.get("pOrdNo").length > 0) {
            compositeKey.setpOrdNo(Integer.parseInt(map.get("pOrdNo")[0]));
        }
        if (map.containsKey("pNo") && map.get("pNo").length > 0) {
            compositeKey.setpNo(Integer.parseInt(map.get("pNo")[0]));
        }
        productOrderDetailVO.setcompositeKey(compositeKey);

        // 设置其他属性
        if (map.containsKey("pPrice") && map.get("pPrice").length > 0) {
            productOrderDetailVO.setpPrice(new BigDecimal(map.get("pPrice")[0]));
        }
        if (map.containsKey("pOrdQty") && map.get("pOrdQty").length > 0) {
            productOrderDetailVO.setpOrdQty(Integer.parseInt(map.get("pOrdQty")[0]));
        }
        if (map.containsKey("pRealPrice") && map.get("pRealPrice").length > 0) {
            productOrderDetailVO.setpRealPrice(new BigDecimal(map.get("pRealPrice")[0]));
        }
        if (map.containsKey("pComContent") && map.get("pComContent").length > 0) {
            productOrderDetailVO.setpComContent(map.get("pComContent")[0]);
        }
        if (map.containsKey("pScore") && map.get("pScore").length > 0) {
            productOrderDetailVO.setpScore(Integer.parseInt(map.get("pScore")[0]));
        }
        ProductOrderDetailVO insertedProductOrderDetail = dao.insert(productOrderDetailVO);
        return insertedProductOrderDetail;
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


    public List<ProductOrderDetailVO> getProductOrderDetailByCompositeQuery(Map<String, String[]> map) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Map<String, String> query = new HashMap<>();
        Set<Map.Entry<String, String[]>> entry = map.entrySet();

        for (Map.Entry<String, String[]> row : entry) {
            String key = row.getKey();
            if ("action".equals(key)) {
                continue;
            }
            String value = row.getValue()[0];
            if (value.isEmpty() || value == null) {
                continue;
            }
            query.put(key, value);
        }

        try {
            session.beginTransaction();
            List<ProductOrderDetailVO> list = dao.getByCompositeQuery(query);
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }
}
