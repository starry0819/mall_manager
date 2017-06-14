package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.MyT_mall_sku;
import com.atguigu.bean.T_mall_sku_attr_value;
import com.atguigu.bean.T_mall_value;

public interface SearchRedisService {

	List<MyT_mall_sku> getSkuByclass2AndAttr(int class2id, List<T_mall_sku_attr_value> sku_attr_values, String order);

	List<T_mall_value> getAttrvalueByAttrid(int attrId);

}
