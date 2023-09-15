package com.tencoding.bank.dto;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class SignUpFormDto {
	private String username;		//화면에 name 태그 기준
	private String password;		
	private String fullname;
	
	//todo  --추후 추가 예정
	
	
}
