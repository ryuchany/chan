package com.kh.spring23.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BuyDto {
	private int no;
	private String tid;
	private String itemName;
	private long totalAmount;
	private Date buyTime;
	private String status;
	
	public boolean isAllCanceled() {
		return status == null || status.equals("전체취소");
	}
}