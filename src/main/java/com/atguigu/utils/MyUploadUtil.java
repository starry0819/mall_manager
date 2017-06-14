package com.atguigu.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadUtil {

	public static List<String> getProductImageNames(MultipartFile[] multipartFiles){
		List<String> imgNames = new ArrayList<>();
		for (MultipartFile file : multipartFiles) {
			if (!file.isEmpty()) {
				String fileName = System.currentTimeMillis() + file.getOriginalFilename();
				try {
					file.transferTo(new File(MyPropertiesUtil.getImagePath("Windows") + "/" + fileName));
					imgNames.add(fileName);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return imgNames;
	}
}
