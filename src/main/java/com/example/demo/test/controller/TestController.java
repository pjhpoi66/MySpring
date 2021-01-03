package com.example.demo.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.test.service.TestService;
import com.example.demo.test.vo.TestVO;
import com.example.demo.test.vo.jhVO;

@RestController
public class TestController {

	@RequestMapping("/home")
	public String home() {
		return "index.html";
	}

	@RequestMapping(value = "/testValue", method = RequestMethod.GET)
	public String getTestValue() {
		String TestValue = "레스트컨트롤러 테스트";
		return TestValue;
	}

	@RequestMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("name", "joongho");

		List<String> list = new ArrayList<String>();

		list.add("1중호");
		list.add("2갓중호");
		list.add("3킹중호");

		mv.addObject("list", list);

		return mv;

	}

	@RequestMapping("/thymeleafTest")
	public String thymeleafTest(Model model) {
		TestVO testModel = new TestVO("pjhpoi", "박중호");
		model.addAttribute("testModel", testModel);
		return "thymeleaf/thymeleafTest";
	}

	@Autowired
	TestService testService;

	@RequestMapping(value = "/testVO")
	public ModelAndView testVO() throws Exception {
		ModelAndView mav = new ModelAndView("testVO");
		List<jhVO> testList = testService.selectTest();
		mav.addObject("list", testList);
		return mav;
	}

}
