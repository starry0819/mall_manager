package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.T_mall_product;

public interface SpuService {

	void spuPublish(T_mall_product product, List<String> imgNames);

}
