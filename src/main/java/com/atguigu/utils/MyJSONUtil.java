package com.atguigu.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;

import net.sf.json.JSONArray;

public class MyJSONUtil {

	/**
	 * 将json字符串转化为List集合
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> json2List(String json, Class<T> clazz) {
		try {
			URLDecoder.decode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<T> list = null;
		if (json != null && !("").equals(json)) {
			JSONArray jsonArray = JSONArray.fromObject(json);
			list = (List<T>) JSONArray.toCollection(jsonArray, clazz);
		}
		return list;
	}

	/**
	 * 将对象转化为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String object2json(Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		try {
			return URLEncoder.encode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
