package ProductOrderDetail;

import ProductOrderDetail.model.ProductOrderDetailVO;

import java.util.List;
import java.util.Map;

public interface ProductOrderDetailDAO {
    int insert(ProductOrderDetailVO entity);

    int update(ProductOrderDetailVO entity);

    ProductOrderDetailVO getBypOrdNo(Integer pOrdNo);

    List<ProductOrderDetailVO> getAll();

    List<ProductOrderDetailVO> getByCompositeQuery(Map<String, String> map);

    long getTotal();
}
