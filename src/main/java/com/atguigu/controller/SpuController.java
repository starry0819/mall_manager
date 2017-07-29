package com.atguigu.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.bean.T_mall_product;
import com.atguigu.service.SpuService;
import com.atguigu.service.TestMapperService;
import com.atguigu.utils.MyUploadUtil;

@Controller
public class SpuController {
	@Autowired
	private SpuService spuService;
	@SuppressWarnings("unused")
	@Autowired
	private TestMapperService testMapperService;

	@RequestMapping(value = "spu_publish", method = RequestMethod.POST)
	public String spuPublish(T_mall_product product, @RequestParam(value="files",required=false) MultipartFile[] multipartFiles) {
		List<String> imgNames = MyUploadUtil.getProductImageNames(multipartFiles);
		// 将第一张图片作为该product的头图
		product.setShp_tp(imgNames.get(0));
		spuService.spuPublish(product, imgNames);

		String title = "商品信息发布";
		String result = "发布成功";

		try {
			title = URLEncoder.encode("商品信息发布","UTF-8");
			result = URLEncoder.encode("发布成功","UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/managerIndex.htm?title="+title+"&url=to_spu_publish/"+result+".htm";
	}

	@RequestMapping("to_spu_publish/{result}")
	public String tospuPublish(@PathVariable("result") String result, ModelMap modelMap) {
		try {
			result = URLDecoder.decode(result, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		modelMap.put("result", result);
		return "manager_spu_publish";
	}

	@RequestMapping("managerIndex")
	public String manager(ModelMap map,String title, String url) {
		
//		int count = testMapperService.query();
//		System.out.println(count);
		map.put("title", title);
		map.put("url", url);
		return "manager_index";
	}
}
