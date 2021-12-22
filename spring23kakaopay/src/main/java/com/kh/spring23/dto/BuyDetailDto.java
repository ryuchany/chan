package com.kh.spring23.dto;

import lombok.Data;

@Data
public class BuyDetailDto {
	private int buyNo;
	private int productNo;
	private String productName;
	private int quantity;
	private int price;
	private String status;
	
	public boolean isCancelAvailable() {
		return status != null && status.equals("결제");
	}
	
}