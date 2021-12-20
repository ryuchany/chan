package com.kh.spring23.dto;

import lombok.Data;

@Data
public class BuyDetailDto {
	private int buyNo;
	private int productNo;
	private String productName;
	private int quantity;
	private int price;
}
