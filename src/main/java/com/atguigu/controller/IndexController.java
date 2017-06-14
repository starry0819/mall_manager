package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("to_search_redis/{success}")
	public String toSearchRedis(@PathVariable("success") String success, ModelMap map){
		return "manager_search_redis";
	}
}
