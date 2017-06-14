package com.atguigu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MyT_mall_sku;
import com.atguigu.bean.T_mall_sku_attr_value;
import com.atguigu.bean.T_mall_value;
import com.atguigu.mapper.SearchRedisMapper;
import com.atguigu.service.SearchRedisService;

@Service
public class SearchRedisServiceImpl implements SearchRedisService {

	@Autowired
	private SearchRedisMapper searchRedisMapper;
	
	@Override
	public List<MyT_mall_sku> getSkuByclass2AndAttr(int class2id, List<T_mall_sku_attr_value> sku_attr_values, String order) {
		Map<String, Object> param = new HashMap<>();
		param.put("class2id", class2id);
		param.put("order", order);
		if (sku_attr_values == null || sku_attr_values.size() == 0) {
			return searchRedisMapper.querySkuByclass2(param);
		} else {
			StringBuffer sql = new StringBuffer();
			sql.append(" AND sku.Id IN(SELECT sku0.sku_id FROM ");

			for (int i = 0; i < sku_attr_values.size(); i++) {
				sql.append(" (SELECT sku_id from t_mall_sku_attr_value where shxm_id = "
						+ sku_attr_values.get(i).getShxm_id() + " AND shxzh_id = "
						+ sku_attr_values.get(i).getShxzh_id() + ") sku" + i + " ");
				if (i < sku_attr_values.size() - 1) {
					sql.append(",");
				}
			}
			if (sku_attr_values.size() != 1) {
				sql.append(" WHERE ");
			}
			for (int i = 0; i < sku_attr_values.size(); i++) {
				if (i < sku_attr_values.size() - 1) {
					sql.append(" sku" + i + ".sku_id=" + "sku" + (i + 1) + ".sku_id");
				}
				if (i < sku_attr_values.size() - 2) {
					sql.append(" AND ");
				}
			}
			sql.append(" )");
			param.put("sql", sql.toString());
			return searchRedisMapper.querySkuByclass2AndAttr(param);
		}
	}

	@Override
	public List<T_mall_value> getAttrvalueByAttrid(int attrId) {
		List<T_mall_value> attrvalues = searchRedisMapper.queryAttrvalueByAttrid(attrId);
		return attrvalues;
	}

}
