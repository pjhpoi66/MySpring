package com.example.demo.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.test.mapper.TestMapper;
import com.example.demo.test.service.TestService;
import com.example.demo.test.vo.jhVO;

@Service
public class TestServiceImpl implements TestService {
    
    @Autowired
    public TestMapper tm;

    @Override
    public List<jhVO> selectTest() {

        return tm.selectTest();
    }

}
