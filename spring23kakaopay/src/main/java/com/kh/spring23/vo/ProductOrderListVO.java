package com.kh.spring23.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProductOrderListVO {
	private List<ProductOrderVO> list;//변수명에는 객체 파라미터의 대표이름을 작성(list[0].no 면 list가 대표이름)
}
