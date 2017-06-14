package com.atguigu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MyT_mall_attr;
import com.atguigu.mapper.AttrMapper;
import com.atguigu.service.AttrService;

@Service
public class AttrServiceImpl implements AttrService {
	@Autowired
	private AttrMapper attrMapper;

	@Override
	public List<MyT_mall_attr> getAttrlistByclass2(int class2id) {
		List<MyT_mall_attr> attrs = attrMapper.queryAttrlistByclass2(class2id);
		return attrs;
	}

	@Override
	public void addAttr(List<MyT_mall_attr> attrList) {
		for (MyT_mall_attr attr : attrList) {
			attrMapper.insertAttr(attr);
			Map<String, Object> attrvalueMap = new HashMap<>();
			attrvalueMap.put("shxm_id", attr.getId());
			attrvalueMap.put("attrvalues", attr.getValueList());
			attrMapper.insertAttrValue(attrvalueMap);
		}
	}
}

