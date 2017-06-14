package com.atguigu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mapper.TestMapper;
import com.atguigu.service.TestMapperService;

@Service
public class TestMapperServiceImpl implements TestMapperService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public int query() {
		return testMapper.query();
	}

}
