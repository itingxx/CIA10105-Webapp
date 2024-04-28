package com.iting.productorderdetail.DAO;


import Util.HibernateUtil;
import com.iting.productorderdetail.model.ProductOrderDetailVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductOrderDetailDAOimpl implements ProductOrderDetailDAO {
    private SessionFactory factory;

    public ProductOrderDetailDAOimpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public ProductOrderDetailVO insert(ProductOrderDetailVO productOrderDetailVO) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(productOrderDetailVO);
            session.getTransaction().commit();
            return productOrderDetailVO;
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
    }



//    @Override
//    public ProductOrderDetailVO getBypOrdNo(Integer pOrdNo) {
//        return getSession().get(ProductOrderDetailVO.class, pOrdNo);
//    }

    @Override
    public List<ProductOrderDetailVO> getAll() {
        return getSession().createQuery("from ProductOrderDetailVO", ProductOrderDetailVO.class).list();
    }


    @Override
    public List<ProductOrderDetailVO> getByCompositeQuery(Map<String, String> map) {
        if (map.size() == 0)
            return getAll();

        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<ProductOrderDetailVO> criteria = builder.createQuery(ProductOrderDetailVO.class);
        Root<ProductOrderDetailVO> root = criteria.from(ProductOrderDetailVO.class);

        List<Predicate> predicates = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "pOrdNo":
                    predicates.add(builder.equal(root.get("compositeKey").get("pOrdNo"), Integer.parseInt(value)));
                    break;
                case "pNo":
                    predicates.add(builder.equal(root.get("compositeKey").get("pNo"), Integer.parseInt(value)));
                    break;
                case "startpScore":
                    if (!map.containsKey("endpScore"))
                        predicates.add(builder.greaterThanOrEqualTo(root.get("pScore"), Integer.parseInt(value)));
                    break;
                case "endpScore":
                    if (!map.containsKey("startpScore"))
                        predicates.add(builder.lessThanOrEqualTo(root.get("pScore"), Integer.parseInt(value)));
                    break;
            }
        }

        criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
        criteria.orderBy(builder.asc(root.get("compositeKey").get("pOrdNo")));
        criteria.orderBy(builder.asc(root.get("compositeKey").get("pNo")));
        TypedQuery<ProductOrderDetailVO> query = getSession().createQuery(criteria);

        return query.getResultList();
    }
}

//    @Override
//    public long getTotal() {
//        return (Long) getSession().createQuery("select count(*) from ProductOrderDetailVO").uniqueResult();
//    }

