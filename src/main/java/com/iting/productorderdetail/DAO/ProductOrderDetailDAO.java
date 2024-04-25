package com.iting.productorderdetail.DAO;



import com.iting.productorderdetail.model.ProductOrderDetailVO;

import java.util.List;

public interface ProductOrderDetailDAO {
    ProductOrderDetailVO insert(ProductOrderDetailVO productOrderDetailVO);


    List<ProductOrderDetailVO> getAll();

//    ProductOrderDetailVO getByCompositeQuery(Integer pOrdNo, Integer pNo);
//
//    List<ProductOrderDetailVO> getAllBypOrdNo(Integer pOrdNo);
}
