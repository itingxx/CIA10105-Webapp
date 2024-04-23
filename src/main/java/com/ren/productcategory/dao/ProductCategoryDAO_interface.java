package com.ren.productcategory.dao;

import java.util.List;
import java.util.Set;

import com.ren.product.model.ProductVO;
import com.ren.productcategory.model.ProductCategoryVO;

public interface ProductCategoryDAO_interface {

    // 新增商品類別
    public void insert(ProductCategoryVO productCategoryVO);
    // 透過商品類別編號查詢商品類別
    public ProductCategoryVO findByPrimaryKey(Integer pCatNo);
    // 查詢全部商品類別
    public List<ProductCategoryVO> getAll();
    //查詢某類別的衣服(一對多)(回傳 Set)
    public Set<ProductVO> getProductsBypCatNo(Integer pCatNo);
    // 更新商品類別資料
    public void update(ProductCategoryVO productCategoryVO);
    // 根據商品類別編號刪除
    public void delete(Integer pCatNo);

}
