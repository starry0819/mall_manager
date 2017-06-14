package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.MyT_mall_attr;

public interface AttrMapper {

	List<MyT_mall_attr> queryAttrlistByclass2(int class2id);

	void insertAttr(MyT_mall_attr attr);

	void insertAttrValue(Map<String, Object> attrvalueMap);


}
