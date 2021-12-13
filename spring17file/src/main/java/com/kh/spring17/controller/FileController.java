package com.kh.spring17.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring17.vo.MemberUploadVO;

@Controller
public class FileController {
	
	@RequestMapping("/")
	public String home() {
		return "upload";
	}

	/**
	 *	Spring은 전송된 파일을 MultipartFile 형태로 가공하여 제공한다.
	 *	이 안에는 파일의 정보와 파일의 내용이 모두 포함되어 있다.
	 *	(중요) 파일이 첨부되지 않아도 정보는 들어오므로 파일 첨부 여부를 구분할 수 있어야 한다. 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("/upload")
	public String upload(
				@RequestParam String memberId,
				@RequestParam String memberPw,
				@RequestParam MultipartFile attach
			) throws IllegalStateException, IOException {
		System.out.println("memberId = " + memberId);
		System.out.println("memberPw = " + memberPw);

		System.out.println("empty? " + attach.isEmpty());
		System.out.println("originalFileName = " + attach.getOriginalFilename());
		System.out.println("contentType = " + attach.getContentType());
		System.out.println("size = " + attach.getSize());

		//실제 저장 : 저장할 위치를 파일 객체로 설정한 뒤 저장 명령을 호출하면 된다.
		File dir = new File("D:/upload");//기준 폴더 잡고
		File target = new File(dir, attach.getOriginalFilename());//저장할 파일 설정하고
		attach.transferTo(target);//저장!

		return "redirect:/";
	}

	/**
	 * 	파일이 여러 개 첨부될 경우(multiple)에 대한 처리
	 * (주의) 
	 * - 파일이 첨부되지 않아도 배열이나 리스트의 개수가 1개
	 * - 단순하게 반복으로 처리하지 말고 꼭! 파일이 있는지 확인을 해서 처리하도록 코드를 작성
	 */
	@PostMapping("/upload2")
	public String upload2(
			@RequestParam String memberId,
			@RequestParam String memberPw,
//			@RequestParam MultipartFile[] attach
			@RequestParam List<MultipartFile> attach
			) {
		System.out.println("memberId = " + memberId);
		System.out.println("memberPw = " + memberPw);		

//		System.out.println("파일개수 : "+attach.length);//배열
		System.out.println("파일개수 : "+attach.size());//List

		for(MultipartFile file : attach) {
			if(!file.isEmpty()) {
				System.out.println("originalFileName = " + file.getOriginalFilename());
				System.out.println("contentType = " + file.getContentType());
				System.out.println("size = " + file.getSize());
			}
		}

		return "redirect:/";
	}

	@PostMapping("/upload3")
	public String upload3(@ModelAttribute MemberUploadVO vo) {
		System.out.println(vo);
		return "redirect:/";
	}
}