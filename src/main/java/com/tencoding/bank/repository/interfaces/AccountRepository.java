package com.tencoding.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tencoding.bank.repository.model.Account;

@Mapper // 반드시 정의 
public interface AccountRepository {
	
	public int insert(Account account);
	public int updateById(Account account);
	public int deleteById(Integer id);
	public List<Account> findAll();
	public Account findById(Integer id);
	public List<Account> findByUserId(Integer principalID);  // 코드 추가 확인 
	public Account findByNumber(String number); // 계좌 번호로 계좌 존재 여부 확인
}