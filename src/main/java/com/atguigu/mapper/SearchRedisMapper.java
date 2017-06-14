package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.MyT_mall_sku;
import com.atguigu.bean.T_mall_value;

public interface SearchRedisMapper {

	List<MyT_mall_sku> querySkuByclass2(Map<String, Object> param);

	List<MyT_mall_sku> querySkuByclass2AndAttr(Map<String, Object> param);

	List<T_mall_value> queryAttrvalueByAttrid(int attrId);

}
