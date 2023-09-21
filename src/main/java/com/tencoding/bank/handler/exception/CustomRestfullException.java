package com.tencoding.bank.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

//RuntimeException으로 재정의
//클래스를 정의한다
@Getter	//IoC 대상이 아닙니다 (필요할때 직접 new 할 예정)
public class CustomRestfullException extends RuntimeException {

	private HttpStatus status;
	
	public CustomRestfullException(String message,
			HttpStatus httpStatus) {
		super(message);
		
		this.status = status;
		
	}
	
}
