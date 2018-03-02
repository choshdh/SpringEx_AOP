package kr.co.cho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cho.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value="/doA" , method=RequestMethod.GET)
	String doA(Model model) {
		System.out.println("doA 호출!");
		String result = testService.testService();
		model.addAttribute("msg", result);
		return "doA";
	}
	
	@RequestMapping(value="/doB")
	String doB() {
		
		return "doB";
	}
	
}
