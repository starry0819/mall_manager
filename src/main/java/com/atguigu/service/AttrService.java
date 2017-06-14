package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.MyT_mall_attr;

public interface AttrService {

	List<MyT_mall_attr> getAttrlistByclass2(int class2id);

	void addAttr(List<MyT_mall_attr> attrList);
	
}
