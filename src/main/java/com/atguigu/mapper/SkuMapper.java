package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.T_mall_product;
import com.atguigu.bean.T_mall_sku;

public interface SkuMapper {

	List<T_mall_product> querySpuByppid_class2id_class1id(Map<String, Object> map);

	void insertSku(T_mall_sku sku);

	void insertSkuAttrvalues(Map<String, Object> param);


}
