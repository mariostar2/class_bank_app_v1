package com.tencoding.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.exception.CustomRestFullException;
import com.tencoding.bank.service.UserService;

@Controller		// <-----------컨트롤러
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원 가입 페이지 요청 
	// http://localhost:80/user/sign-up
	@GetMapping("/sign-up")
	public String signUp() {
		
		return "user/signUp";
	} 
	
	//로그인 페이지 요청
	//http://localhost:80/user/sign-in
	@GetMapping("/sign-in")
	public String signin() {
		return "user/signIn";
	}
	
	//회원가입 처리
	//http://localhost:80/user/sign-in
	//Post -HTTP BODY
	//name 속성을 이용해서 
	//Key=value
//	http://localhost/user/sign-up
	@PostMapping("/sign-up")
	public String signUpProc(SignUpFormDto signUpFormDto ) {
		//1 . 유효성 검사
		if(signUpFormDto.getUsername() == null||signUpFormDto.getUsername().isEmpty()) {
			throw new CustomRestFullException("username을 입력하세요", HttpStatus.BAD_REQUEST);
		}
			if(signUpFormDto.getPassword() == null ||signUpFormDto.getUsername().isEmpty()) {
				throw new CustomRestFullException("password을 입력하세요", HttpStatus.BAD_REQUEST);
		
	    }		
			if(signUpFormDto.getPassword() == null ||signUpFormDto.getFullname().isEmpty()) {
				throw new CustomRestFullException("fullname을 입력하세요", HttpStatus.BAD_REQUEST);		
	    }
			//로직추가 - 서비스 호출
			userService.signUp(signUpFormDto);			
			return "redirect:/user/sign-in";
	}
}