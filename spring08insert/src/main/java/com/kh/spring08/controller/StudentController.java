package com.kh.spring08.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.spring08.entity.StudentDto;
import com.kh.spring08.repository.StudentDao;

@Controller
public class StudentController {

	//제가 일하려면 StudentDao가 필요한데... 좀 주시면 감사하겠습니다(굽신굽신)
	@Autowired
	private StudentDao studentDao;
	
	//등록 절차
	//= 반드시 입력페이지와 처리페이지가 존재해야 한다.
	//= 주소를 맞추고 GET/POST로 구분해서 처리한다.

	//@RequestMapping("/insert") - 모든 방식
	//@RequestMapping(value = "/insert", method = RequestMethod.GET) - GET방식(~spring 4.x)
	//@RequestMapping(value = "/insert", method = RequestMethod.POST) - POST방식(~spring 4.x)
	@GetMapping("/insert")//GET방식(spring 5.x)
	public String insert() {
		//해야할 일 : 입력 페이지로 연결
		//return "/WEB-INF/views/insert.jsp";
		return "insert";
	}

	@PostMapping("/insert")//POST방식(spring 5.x)
	public String insert(@ModelAttribute StudentDto studentDto) throws Exception {
		System.out.println(studentDto.getName());
		System.out.println(studentDto.getScore());
		//해야할 일 : 데이터를 받아서 처리한 뒤 다른 곳으로 안내
		//DB 접속 및 등록 코드
		
		studentDao.insert(studentDto);
		
		//return "/WEB-INF/views/insert_success.jsp";
		return "insert_success";
	}

}
