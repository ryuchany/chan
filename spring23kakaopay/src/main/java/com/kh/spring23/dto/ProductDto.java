package com.kh.spring23.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int no;
	private String name;
	private String type;
	private int price;
	private String made;
	private String expire;
}