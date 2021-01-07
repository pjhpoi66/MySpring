package com.example.demo.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.test.vo.jhVO;

@Mapper
public interface TestMapper {
	List<jhVO> selectTest();
}
