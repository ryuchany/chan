package com.kh.spring24;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//web.xml 역할을 수행하는 파일
//= 이 파일이 없으면 tomcat 등의 WAS에서 프로젝트 실행이 불가능
//= 프로젝트 생성 시 packaging을 war로 하면 생성되는 파일
//= 이 파일에 뭘 작성할 필요는 없으며 존재하기만 하면 문제없음
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Spring24bootApplication.class);
	}

}