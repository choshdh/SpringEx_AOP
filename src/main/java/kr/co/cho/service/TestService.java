package kr.co.cho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cho.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao tDao;
	
	
	public String testService() {
		System.out.println("Service 실행 - joinpoint");
		return "hello";
	}
	
	public String doBService() {
		return "doBService 실행됨";
	}
	
}
