package com.example.demo.test.history.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.test.history.service.impl.HistoryServiceImpl;

@Controller
public class HistoryController {

    @Autowired
    HistoryServiceImpl hsimpl;

    @GetMapping("/company/history")
    public ModelAndView history(Map<String, Object> model) {
        Map<String, Object> result = hsimpl.selectHistory(model);
        result.put("title", "얼티온 - (주)얼티온 홈페이지");
        result.put("list", result);
        return new ModelAndView("/company/history", result);
    }
}
