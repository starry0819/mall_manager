package com.atguigu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_mall_product;
import com.atguigu.mapper.SpuMapper;
import com.atguigu.service.SpuService;

@Service
public class SpuServiceImpl implements SpuService {
	@Autowired
	private SpuMapper spuMapper;

	@Override
	public void spuPublish(T_mall_product product, List<String> imgNames) {

		spuMapper.insertProduct(product);

		Map<String, Object> map = new HashMap<>();
		map.put("shp_id", product.getId());
		map.put("imgNames", imgNames);
		spuMapper.insertProductImage(map);
	}
}
