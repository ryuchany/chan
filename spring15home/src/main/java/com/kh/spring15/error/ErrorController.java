package com.kh.spring15.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 *	전체 오류를 처리하는 도구
 *	- 내부에 @ExceptionHandler 를 배치하여 간섭 대상에서 발생한 오류를 인터셉트한다
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
//@ControllerAdvice(basePackages = {"com.kh.spring15.controller"})
@Slf4j
public class ErrorController {

//	@ExceptionHandler(SQLException.class)
//	@ExceptionHandler(IOException.class)
//	@ExceptionHandler(RuntimeException.class)
	
	@ExceptionHandler(Exception.class)
	public String ex(Exception e) {
		//기록? 단순출력? 파일출력?
		//System.err.println(e);
		log.error("오류 발생", e);//기본메세지(오류발생) + stack-trace(예외추적정보) 출력
		return "error/500";
	}

}