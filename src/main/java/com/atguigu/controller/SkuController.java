package com.atguigu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.MyT_mall_attr;
import com.atguigu.bean.MyT_mall_sku_attr_value;
import com.atguigu.bean.T_mall_product;
import com.atguigu.bean.T_mall_sku;
import com.atguigu.service.AttrService;
import com.atguigu.service.SkuService;

@Controller
public class SkuController {

	@Autowired
	private SkuService skuService;
	@Autowired
	private AttrService attrService;

	@RequestMapping("addSku")
	public ModelAndView addSku(MyT_mall_sku_attr_value attr_value, int shp_id, T_mall_sku sku) {
		sku.setShp_id(shp_id);
		skuService.addSku(attr_value.getSku_attr_values(),sku);
//		ModelAndView view = new ModelAndView("redirect:/to_sku_publish/{success}.htm");
		String title = null;
		String result = null;
		try {
			title = URLEncoder.encode("库存信息发布","UTF-8");
			result = URLEncoder.encode("发布成功","UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("redirect:/managerIndex.htm?title="+title+"&url=to_sku_publish/"+result+".htm");
		return view;
	}

	@RequestMapping("get_skuAttrlistByclass2")
	public String getSkuAttrListByclass2id(int class2id, ModelMap map) {
		List<MyT_mall_attr> attrs = attrService.getAttrlistByclass2(class2id);
		map.put("attrList", attrs);
		return "manager_sku_inner";
	}

	@ResponseBody
	@RequestMapping("get_spuByppid_class2id_class1id")
	public Object get_spuByppid_class2id_class1id(int flbh1, int flbh2, int pp_id) {
		List<T_mall_product> products = skuService.get_spuByppid_class2id_class1id(flbh1, flbh2, pp_id);
		return products;
	}

	@RequestMapping("to_sku_publish/{success}")
	public String toSkuPublish(@PathVariable("success")String result, ModelMap map) {
		map.put("result", result);
		return "manager_sku_publish";
	}
}
