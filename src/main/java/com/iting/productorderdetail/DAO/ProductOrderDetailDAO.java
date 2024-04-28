package com.iting.productorderdetail.DAO;



import com.iting.productorderdetail.model.ProductOrderDetailVO;

import java.util.List;
import java.util.Map;

public interface ProductOrderDetailDAO {
    ProductOrderDetailVO insert(ProductOrderDetailVO productOrderDetailVO);


    List<ProductOrderDetailVO> getAll();

    List<ProductOrderDetailVO> getByCompositeQuery(Map<String, String> map);
//
//    List<ProductOrderDetailVO> getAllBypOrdNo(Integer pOrdNo);
}
