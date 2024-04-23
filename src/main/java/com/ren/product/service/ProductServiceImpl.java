//package com.ren.product.service;
//
//import com.ren.product.dao.ProductHibernateDAOImpl;
//import com.ren.product.model.ProductVO;
//import com.ren.product.dao.ProductDAO_interface;
//import com.ren.util.HibernateUtil;
//import org.hibernate.Session;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class ProductServiceImpl implements ProductService_interface {
//
//    private ProductDAO_interface dao;
//
//    // DI
//    public ProductServiceImpl() {
//        dao = new ProductHibernateDAOImpl();
//    }
//
//    @Override
//    public ProductVO addProduct(ProductVO productVO) {
//        return dao.getById(dao.insert(productVO));
//    }
//
//    @Override
//    public ProductVO getOneProduct(Integer pNo) {
//        return dao.getById(pNo);
//    }
//
//    @Override
//    public List<ProductVO> getAll() {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            List<ProductVO> list = dao.getAll();
//            session.getTransaction().commit();
//            return list;
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<ProductVO> getAll(int currentPage) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            List<ProductVO> list = dao.getAll(currentPage);
//            session.getTransaction().commit();
//            return list;
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<ProductVO> getProductsByCompositeQuery(Map<String, String[]> map) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Map<String, String> query = new HashMap<>();
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
//        try {
//            session.beginTransaction();
//            List<ProductVO> list = dao.getByCompositeQuery(query);
//            session.getTransaction().commit();
//            return list;
//        } catch (Exception e) {
//            session.getTransaction().rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public ProductVO updateProduct(ProductVO productVO) {
//        if (dao.update(productVO) == 1) {
//            return dao.getById(productVO.getpNo());
//        }
//        return productVO;
//    }
//
//    @Override
//    public void deleteProduct(Integer pNo) {
//        dao.delete(pNo);
//    }
//
//}
