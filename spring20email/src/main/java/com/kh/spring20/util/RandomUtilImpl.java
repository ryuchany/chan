package com.kh.spring20.util;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomUtilImpl implements RandomUtil{

	private Random r = new Random();

	@Override
	public String generateRandomNumber(int size) {
		//size = 2 --> 00 ~ 99(100개)
		//size = 3 --> 000 ~ 999(1000개)
		//size = 4 --> 0000 ~ 9999(10000개)
		//size = n --> 10^n개
		int range =  (int) Math.pow(10, size);
		int number = r.nextInt(range);

		StringBuffer buffer = new StringBuffer();
		for(int i=0; i < size; i++) {
			buffer.append("0");
		}
		Format f = new DecimalFormat(buffer.toString());

		return f.format(number);
	}

}