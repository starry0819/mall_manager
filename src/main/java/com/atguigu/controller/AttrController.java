package com.atguigu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.MyT_mall_attr;
import com.atguigu.bean.MyT_mall_attr_List;
import com.atguigu.service.AttrService;

@Controller
public class AttrController {
	
	@Autowired
	private AttrService attrService ;
	
	@RequestMapping("add_attr")
	public ModelAndView attrAdd(MyT_mall_attr_List attr_List, int class2id, String class2name){
		List<MyT_mall_attr> attrList = attr_List.getAttrList();
		for (MyT_mall_attr attr : attrList) {
			attr.setFlbh2(class2id);
		}
		attrService.addAttr(attr_List.getAttrList());
		ModelAndView modelAndView = new ModelAndView("redirect:/to_attr_add/{id}/{name}/{success}.htm");
		modelAndView.addObject("id", class2id);
		modelAndView.addObject("name", class2name);
		modelAndView.addObject("success", "成功");
		return modelAndView;
	}
	
	@RequestMapping("to_attr_add/{class2id}/{class2name}/{success}")
	public String toAttrAdd(@PathVariable("class2id") int class2id, @PathVariable("class2name") String class2name, @PathVariable String success){
		return "manager_attr_add";
	}
	
	@ResponseBody
	@RequestMapping("get_attrlistByclass2")
	public List<MyT_mall_attr> getAttrlistByclass2(int class2id){
		List<MyT_mall_attr> attrs = attrService.getAttrlistByclass2(class2id);
		return attrs;
	}
	
	@RequestMapping("to_attr_publish/{result}")
	public String toAttrPublish(ModelMap map, @PathVariable("result") String result){
		map.put("result", result);
		return "manager_attr_publish";
	}
}
