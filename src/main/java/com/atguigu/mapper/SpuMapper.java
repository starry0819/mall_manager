package com.atguigu.mapper;

import java.util.Map;

import com.atguigu.bean.T_mall_product;

public interface SpuMapper {

	void insertProduct(T_mall_product product);

	void insertProductImage(Map<String, Object> map);

}
