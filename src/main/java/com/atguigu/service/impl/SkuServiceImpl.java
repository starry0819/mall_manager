package com.atguigu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_mall_product;
import com.atguigu.bean.T_mall_sku;
import com.atguigu.bean.T_mall_sku_attr_value;
import com.atguigu.mapper.SkuMapper;
import com.atguigu.service.SkuService;

@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	private SkuMapper skuMapper;
	
	@Override
	public List<T_mall_product> get_spuByppid_class2id_class1id(Integer flbh1, int flbh2, int pp_id) {
		Map<String, Object> param = new HashMap<>();
		param.put("flbh1", flbh1);
		param.put("flbh2", flbh2);
		param.put("pp_id", pp_id);
		List<T_mall_product> products = skuMapper.querySpuByppid_class2id_class1id(param);
		return products;
	}

	@Override
	public void addSku(List<T_mall_sku_attr_value> sku_attr_values, T_mall_sku sku) {
		skuMapper.insertSku(sku);
		Map<String, Object> param = new HashMap<>();
		param.put("sku_id", sku.getId());
		param.put("shp_id", sku.getShp_id());
		param.put("sku_attrvalues", sku_attr_values);
		skuMapper.insertSkuAttrvalues(param);
	}


}
