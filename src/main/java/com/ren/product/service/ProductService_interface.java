package com.ren.product.service;

import com.ren.product.model.ProductVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService_interface {

	// 新增商品(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
	ProductVO addProduct(ProductVO productVO);
	// 查詢單筆商品資料
	ProductVO getOneProduct(Integer pNo);
	List<ProductVO> getAll();
	// 查詢所有商品資料
	List<ProductVO> getAll(int currentPage);
	// 複合查詢
	List<ProductVO> getProductsByCompositeQuery(Map<String, String[]> map);
	// 修改商品(返回值由Controller轉給View)
	ProductVO updateProduct(ProductVO productVO);
	// 刪除商品
	void deleteProduct(Integer pNo);
}
