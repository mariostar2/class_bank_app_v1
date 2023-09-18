package com.tencoding.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.bank.exception.CustomRestFullException;

@RestController		//데이터 반환 컨트롤러 
@RequestMapping("/macc")
public class MTest1RestController {
	
	//http://localhost:80/macc/test
	@GetMapping("/test")
	public void  test1() {
		throw new CustomRestFullException("잘못된 연산",HttpStatus.BAD_REQUEST);
		//return " 정상 동작 ";
	}
}
