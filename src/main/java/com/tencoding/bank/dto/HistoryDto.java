package com.tencoding.bank.dto;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import com.tencoding.bank.utils.TimestampUtill;

import lombok.Data;
 
@Data
public class HistoryDto {
		private Integer id;
		private Long amount;
		private Long balance;
		private String sender;
		private String receiver;
		private Timestamp createdAt;
		
		//시간 가공 (Timestamp)
		public String formatCreatedAt() {
			return TimestampUtill.timestampToString(createdAt);
		}
		//금액 , 처리
		public String formatBalance() {
			DecimalFormat df = new DecimalFormat("#,###");
			return df.format(balance);
		}
		
		
}
