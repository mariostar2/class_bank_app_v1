package com.tencoding.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.exception.CustomRestFullException;
import com.tencoding.bank.repository.interfaces.UserRepository;



@Service		//IoC 대상
public class UserService {
	//DAO - 데이터 베이스 연동 
	@Autowired
	private UserRepository userRepository;
	//Di - 가지고오다
//	 public UserSerivce(UserRepository userRepository) {
//		 this.userRepository =userRepository;
//	 }
	//트랜젝션을 사용하는 이유는 정상처리 commit(반영)
	//정상 처리 안돼면 Rollback 처리됨
	
	@Transactional
	public void signUp(SignUpFormDto signUpFormDto){
		int result = userRepository.insert(signUpFormDto);
		if(result !=1 ) {
			throw new CustomRestFullException("회원가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
