package com.kh.spring21.vo;

import java.util.List;

import lombok.Data;

@Data
public class ChartTotalVO {
	private String title;
	private String label;
	private List<ChartVO> dataset;
}