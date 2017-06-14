package com.atguigu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesUtil {
	
	public static String getImagePath(String key){
		Properties properties = new Properties();
		InputStream resourceAsStream = MyPropertiesUtil.class.getClassLoader().getResourceAsStream("imagePath.properties");
		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
