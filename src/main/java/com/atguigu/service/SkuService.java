package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.T_mall_product;
import com.atguigu.bean.T_mall_sku;
import com.atguigu.bean.T_mall_sku_attr_value;

public interface SkuService {

	List<T_mall_product> get_spuByppid_class2id_class1id(Integer flbh1, int flbh2, int pp_id);

	void addSku(List<T_mall_sku_attr_value> sku_attr_values, T_mall_sku sku);


}
