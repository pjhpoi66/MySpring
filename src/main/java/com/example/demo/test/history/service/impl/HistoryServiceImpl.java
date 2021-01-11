package com.example.demo.test.history.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.test.history.mapper.HistoryMapper;
import com.example.demo.test.history.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryMapper hm;

    @Override
    public Map<String, Object> selectHistory(Map<String, Object> param) {
        Map<String, Object> result = hm.selectHistory(param);
        return result;
    }

}
