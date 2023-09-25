package com.tencoding.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tencoding.bank.dto.SignInFormDto;
import com.tencoding.bank.dto.SignUpFormDto;
import com.tencoding.bank.handler.exception.CustomRestfullException;
import com.tencoding.bank.repository.interfaces.UserRepository;
import com.tencoding.bank.repository.model.User;

@Service // IoC 대상 - 싱글톤 패턴
public class UserService {

	// DAO - 데이터 베이스 연습
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	/**
	 * 회원 가입 
	 * 비밀번호 암호화 처리 
	 * @param signUpFormDto
	 */
	@Transactional
	public void signUp(SignUpFormDto signUpFormDto) {
		
		String rawPwd = signUpFormDto.getPassword();
		String hashPwd = passwordEncoder.encode(rawPwd);
		signUpFormDto.setPassword(hashPwd);
		int result = userRepository.insert(signUpFormDto);
		if (result != 1) {
			throw new CustomRestfullException("회원가입실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// 로그인 서비스 처리 
	public User signIn(SignInFormDto signInFormDto) {
		//User userEntity = userRepository.findByUsernameAndPassword(signInFormDto);
		//findByUsernameAndPassword <-- where , id and pw가 넘어와야 작동하는 방식을 바꿔보자
		
		//계정 이름만 확인으로 변경 처리
		User userEntity = userRepository.findByUsername(signInFormDto.getUsername());
		
		//계정 확인
		if(userEntity == null ||
				userEntity.getUsername().equals(signInFormDto.getUsername()) ==false){
			throw new CustomRestfullException("존재하지 않는 계정입니다", HttpStatus.INTERNAL_SERVER_ERROR);
		} 

		boolean isPwdMatched = passwordEncoder.matches(signInFormDto.getPassword(), userEntity.getPassword());
		
		if(isPwdMatched == false) {
			throw new CustomRestfullException("비밀 번호가 다릅니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}	 
		return userEntity;
	}
}