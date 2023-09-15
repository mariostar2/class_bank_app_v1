package com.tencoding.bank.dto;

import lombok.Data;

@Data
public class DepositFormDto {
	
	private long amount;
	private String dAccountNumber;
	private String wAccountNumber;
	
}
