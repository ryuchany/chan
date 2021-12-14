package com.kh.spring15.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring15.entity.MemberDto;
import com.kh.spring15.entity.MemberProfileDto;
import com.kh.spring15.repository.MemberDao;
import com.kh.spring15.repository.MemberProfileDao;
import com.kh.spring15.service.MemberService;
import com.kh.spring15.vo.MemberJoinVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberProfileDao memberProfileDao;

	@GetMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute MemberDto memberDto,//회원정보
			@RequestParam(required = false) String saveId,//아이디 저장(선택)
			HttpServletResponse response,//쿠키 생성을 위한 응답객체
			HttpSession session) {//세션객체
		//회원정보 단일조회 및 비밀번호 일치판정
		MemberDto findDto = memberDao.login(memberDto);
		if(findDto != null) {
			//세션에 ses, grade를 설정하고 root로 리다이렉트
			session.setAttribute("ses", findDto.getMemberId());
			session.setAttribute("grade", findDto.getMemberGrade());
			
			//쿠키와 관련된 아이디 저장하기 처리
			if(saveId != null) {//체크 했다면(saveId값이 전송되었다면)
				//생성
				Cookie c = new Cookie("saveId", findDto.getMemberId());
				//c.setMaxAge(2 * 7 * 24 * 60 * 60);//2주
				c.setMaxAge(4 * 7 * 24 * 60 * 60);//4주
				//c.setMaxAge(Integer.MAX_VALUE);//무한대
				response.addCookie(c);
			}
			else {//체크 안했다면(saveId값이 전송되지 않았다면)
				//삭제
				Cookie c = new Cookie("saveId", findDto.getMemberId());
				c.setMaxAge(0);
				response.addCookie(c);
			}
			
			return "redirect:/";
		}
		else {
			//로그인 페이지에 오류 표시와 함께 리다이렉트
			//return "redirect:/member/login?error";//절대
			return "redirect:login?error";//상대
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("ses");
		session.removeAttribute("grade");
		//session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberJoinVO memberJoinVO) throws IllegalStateException, IOException {
		memberService.join(memberJoinVO);
//		return "redirect:/member/join_success";
		return "redirect:join_success";
	}
	
	@RequestMapping("/join_success")
	public String joinSuccess() {
//		return "/WEB-INF/views/member/join_success.jsp";
		return "member/join_success";
	}
	
	//내정보
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("ses");
		MemberDto memberDto = memberDao.get(memberId);
		MemberProfileDto memberProfileDto = memberProfileDao.get(memberId);

		model.addAttribute("memberDto", memberDto);
		model.addAttribute("memberProfileDto", memberProfileDto);

//		return "/WEB-INF/views/member/mypage.jsp";
		return "member/mypage";
	}
	
//	비밀번호 변경
	@GetMapping("/password")
	public String password() {
//		return "/WEB-INF/views/member/password.jsp";
		return "member/password";
	}
	
	@PostMapping("/password")
	public String password(
			@RequestParam String memberPw, 
			@RequestParam String changePw, 
			HttpSession session) {
		String memberId = (String) session.getAttribute("ses");
		
		boolean result = memberDao.changePassword(memberId, memberPw, changePw);
		if(result) {
			return "redirect:password_success";
		}
		else {
			return "redirect:password?error";
		}
	}
	
	@RequestMapping("/password_success")
	public String passwordSuccess() {
//		return "/WEB-INF/views/member/password_success.jsp";
		return "member/password_success";
	}
	
	@GetMapping("/edit")
	public String edit(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("ses");
		MemberDto memberDto = memberDao.get(memberId);
		
		model.addAttribute("memberDto", memberDto);
		
//		return "/WEB-INF/views/member/edit.jsp";
		return "member/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto, HttpSession session) {
		String memberId = (String)session.getAttribute("ses");
		memberDto.setMemberId(memberId);
		
		boolean result = memberDao.changeInformation(memberDto);
		if(result) {
			return "redirect:edit_success";
		}
		else {
			return "redirect:edit?error";
		}
	}
	
	@RequestMapping("/edit_success")
	public String editSuccess() {
//		return "/WEB-INF/views/member/edit_success.jsp";
		return "member/edit_success";
	}
	
	@GetMapping("/quit")
	public String quit() {
//		return "/WEB-INF/views/member/quit.jsp";
		return "member/quit";
	}
	
	@PostMapping("/quit")
	public String quit(HttpSession session, @RequestParam String memberPw) {
		String memberId = (String)session.getAttribute("ses");
		
		boolean result = memberDao.quit(memberId, memberPw);
		if(result) {
			session.removeAttribute("ses");
			session.removeAttribute("grade");
			
			return "redirect:quit_success";
		}
		else {
			return "redirect:quit?error";
		}
	}
	
	@RequestMapping("/quit_success")
	public String quitSuccess() {
//		return "/WEB-INF/views/member/quit_success";
		return "member/quit_success";
	}

//	프로필 다운로드에 대한 요청 처리
//	= (주의) 뷰 리졸버가 적용되면 안된다. @ResponseBody 를 사용하면 무시 처리된다
//	= 문자열이 아니라 파일 정보를 반환해서 스프링으로 하여금 다운로드 처리할 수 있도록 부탁
//	= ResponseEntity는 데이터와 정보(헤더)를 같이 설정할 수 있도록 만들어진 Spring 도구
//	= ByteArrayResource는 바이트 배열 형태의 자원을 담을 수 있는 Spring 도구
	@GetMapping("/profile")
	@ResponseBody//이 메소드만큼은 뷰 리졸버를 쓰지 않겠다
	public ResponseEntity<ByteArrayResource> profile(
				@RequestParam int memberProfileNo
			) throws IOException {

		//프로필번호(memberProfileNo)로 프로필 이미지 파일정보를 구한다.
		MemberProfileDto memberProfileDto = memberProfileDao.get(memberProfileNo);

		//프로필번호(memberProfileNo)로 실제 파일 정보를 불러온다
		byte[] data = memberProfileDao.load(memberProfileNo);
		ByteArrayResource resource = new ByteArrayResource(data);

		String encodeName = URLEncoder.encode(memberProfileDto.getMemberProfileUploadname(), "UTF-8");
		encodeName = encodeName.replace("+", "%20");

		return ResponseEntity.ok()
									//.header("Content-Type", "application/octet-stream")
									.contentType(MediaType.APPLICATION_OCTET_STREAM)
									//.header("Content-Disposition", "attachment; filename=\""+이름+"\"")
									.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+encodeName+"\"")
									//.header("Content-Encoding", "UTF-8")
									.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
									//.header("Content-Length", String.valueOf(memberProfileDto.getMemberProfileSize()))
									.contentLength(memberProfileDto.getMemberProfileSize())
								.body(resource);			
	}
	
	/**
	 * 현재 컨트롤러에서 발생하는 예외를 처리하는 핸들러 매핑
	 * try {
	 * 		현재 컨트롤러의 모든 메소드들
	 * }
	 * catch(Exception e){
	 * 		이곳의 내용을 작성하는 느낌...
	 * }
	 */
//	@ExceptionHandler(Exception.class)
//	public String handler(Exception e) {
//		//로그(logging) 생성 또는 기타 처리 추가
//		return "error/500";
//	}
	
	
}