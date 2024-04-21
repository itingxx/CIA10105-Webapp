package ProductOrderDetail;

import ProductOrderDetail.model.ProductOrderDetailVO;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public int insert(ProductOrderDetailVO entity) {
        return (Integer) getSession().save(entity);
    }

    @Override
    public int update(ProductOrderDetailVO entity) {
        try {
            getSession().update(entity);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public ProductOrderDetailVO getBypOrdNo(Integer pOrdNo) {
        return getSession().get(ProductOrderDetailVO.class, pOrdNo);
    }

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
                    predicates.add(builder.equal(root.get("pOrdNo"), Integer.parseInt(value)));
                    break;
                case "pNo":
                    predicates.add(builder.equal(root.get("pNo"), Integer.parseInt(value)));
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
        criteria.orderBy(builder.asc(root.get("pOrdNo")));
        TypedQuery<ProductOrderDetailVO> query = getSession().createQuery(criteria);

        return query.getResultList();
    }

    @Override
    public long getTotal() {
        return (Long) getSession().createQuery("select count(*) from ProductOrderDetailVO").uniqueResult();
    }
}
