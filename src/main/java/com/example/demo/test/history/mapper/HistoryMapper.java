package com.example.demo.test.history.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistoryMapper {
    Map<String, Object> selectHistory(Map<String, Object> param);
}
