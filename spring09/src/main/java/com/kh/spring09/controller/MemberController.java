package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.MemberDto;
import com.kh.spring09.repository.MemberDao;

//회원과 관련된 연결을 처리하는 컨트롤러
@Controller
@RequestMapping("/member")//컨트롤러 공용 주소
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";//뷰리졸버 적용 전
		return "member/join";//뷰리졸버 적용 후
	} 

	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		//DB 등록 코드
		memberDao.join(memberDto);
		
		//등록을 마치고 JSP를 연결(forward, 포워드)하면 새로고침에 속수무책으로 당한다.
				//return "/WEB-INF/views/member/join_success.jsp";//뷰리졸버 적용 전
				//return "member/join_success";//뷰리졸버 적용 후

				//새로고침을 대비해서 이 기능이 다시 실행되지 않도록 다른 기능으로 강제이동(redirect)
				//= redirect: 로 시작하는 주소를 반환
				return "redirect:/";//root 페이지로 리다이렉트(뷰리졸버 무시)
	}

	//회원목록
		@RequestMapping("/list")
		public String list(Model model) {

			List<MemberDto> list = memberDao.list();
			model.addAttribute("list", list);

//			return "/WEB-INF/views/member/list.jsp";//뷰리졸버 전
			return "member/list";//뷰리졸버 후
		}
	
	
}