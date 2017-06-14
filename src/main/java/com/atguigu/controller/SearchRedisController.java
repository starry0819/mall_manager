package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MyT_mall_sku;
import com.atguigu.bean.T_mall_sku_attr_value;
import com.atguigu.bean.T_mall_value;
import com.atguigu.service.SearchRedisService;
import com.atguigu.utils.JedisUtil;
import com.atguigu.utils.MyJSONUtil;

import redis.clients.jedis.Jedis;

@Controller
public class SearchRedisController {

	@Autowired
	private SearchRedisService searchRedisService;
	
	/**
	 * 根据二级分类id和分类属性检索sku结果
	 * @param class_2_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("get_sku_list_by_class_2_attr_value")
	public int get_sku_list_by_class_2_attr_value(int class_2_id, @RequestParam("attr_array[]") int[] attr_array){
		Jedis jedis = JedisUtil.getJedisResource();
		int sum=0;
		for (int attrId : attr_array) {
			List<T_mall_value> values = searchRedisService.getAttrvalueByAttrid(attrId);
			
			for (T_mall_value value : values) {
				T_mall_sku_attr_value sku_attr_value = new T_mall_sku_attr_value();
				sku_attr_value.setShxm_id(attrId);
				sku_attr_value.setShxzh_id(value.getId());
				
				List<T_mall_sku_attr_value> attr_values = new ArrayList<>();
				attr_values.add(sku_attr_value);
				// 根据二级分类和一对分类属性检索sku结果
				List<MyT_mall_sku> skus = searchRedisService.getSkuByclass2AndAttr(class_2_id, attr_values, null);
				
				String key = "attr_value_" + class_2_id + "_" + attrId + "_" + value.getId();
				jedis.del(key);	//刷新缓存时，先清理下对应的key
				for (MyT_mall_sku sku : skus) {
					String object2json = MyJSONUtil.object2json(sku);
					jedis.zadd(key, skus.indexOf(sku), object2json);
					sum++;
				}
			}
		}
		return sum;
	}
	
	
	/**
	 * 根据二级分类id检索sku结果
	 * @param class_2_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("get_sku_by_class_2")
	public int get_sku_by_class_2(int class_2_id){
		Jedis jedis = JedisUtil.getJedisResource();
		List<MyT_mall_sku> skus = searchRedisService.getSkuByclass2AndAttr(class_2_id, null, null);
		String key = "class_2_id"+class_2_id;
		jedis.del(key);
		for (MyT_mall_sku sku : skus) {
			String object2json = MyJSONUtil.object2json(sku);
			jedis.zadd(key, skus.indexOf(sku), object2json);
		}
		
		return skus.size();
	}
}
