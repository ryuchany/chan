package com.kh.spring21.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kh.spring21.entity.ExamDto;
import com.kh.spring21.entity.TempDto;
import com.kh.spring21.repository.ExamDao;
import com.kh.spring21.repository.TempDao;
import com.kh.spring21.vo.ChartTotalVO;
import com.kh.spring21.vo.ChartVO;

//데이터를 반환하는 컨트롤러를 만들려면 매 요청마다 @ReponseBody를 추가해야 한다.
//@RestController를 이용하면 모든 요청이 @ResponseBody 처리된다.
@RestController
@RequestMapping("/data")
public class DataController {
	
	@GetMapping("/")
	public String home() {
		return "home";//home.jsp가 아니고 home이라는 String data가 사용자에게 출력된다
	}
	
	@GetMapping("/data1")
	public String data1() {
		return String.valueOf(100);//특별한 설정이 없다면 이 값은 반환되기 어렵다(통신은 바이트or문자열만 가능)
	}
	
	@Autowired
	private ExamDao examDao;
	
	//@GetMapping("/data2")//유니코드가 명시적으로 정의되지 않아서 해석의 오해가 발생할 수 있음
	@GetMapping(value="/data2", produces = "text/plain; charset=UTF-8")
	public String data2(){
		return examDao.list().toString();
	}
	
	@GetMapping("/data3")
	public int data3() {
		return 100;
	}
	
	@GetMapping("/data4")
	public List<ExamDto> data4(){
		return examDao.list();
	}
	
	@GetMapping("/data5")
	public ExamDto data5(int examId) {
		return examDao.get(examId);
	}
	
	//페이지네이션 기능
	@GetMapping("/data6")
	public List<ExamDto> data6(
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		int endRow = page * size;
		int startRow = endRow - (size - 1);
		return examDao.listByPage(startRow, endRow);
	}
	
	//등록 기능
	@PostMapping("/data7")
	public void data7(@ModelAttribute ExamDto examDto){
		examDao.insert(examDto);
	}
	
	//삭제 기능
	@DeleteMapping("/data8")
	public boolean data8(@RequestParam int examId) {
		return examDao.delete(examId);
	}

	/**
	 간단한 테이블을 만들어 비동기 업로드 처리를 확인
	 create table temp(
		no number primary key,
		name varchar2(256) not null
	);
	create sequence temp_seq;
	 */

	@Autowired
	private TempDao tempDao;

	//파일 업로드
	@PostMapping("/data9")
	public int data9(@RequestParam MultipartFile attach) throws IllegalStateException, IOException{
		if(attach.isEmpty()) {
			throw new FileNotFoundException("업로드된 파일이 존재하지 않습니다");
		}
		
		TempDto tempDto = new TempDto();
		tempDto.setName(attach.getOriginalFilename());
		int no = tempDao.save(tempDto);//등록

		File target = new File("D:/upload", String.valueOf(no));
		attach.transferTo(target);

		return no;
	}

	//파일 다운로드 : 기존과 동일
	@GetMapping("/data10")
	public ResponseEntity<ByteArrayResource> data10(@RequestParam int no) throws IOException{

		TempDto tempDto = tempDao.get(no);
		if(tempDto == null) {
			return ResponseEntity.notFound().build();//resp.sendError(404);
		}

		File target = new File("D:/upload", String.valueOf(no));
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);

		String encodeName = URLEncoder.encode(tempDto.getName(), "UTF-8");
		encodeName = encodeName.replace("+", "%20");

		return ResponseEntity.ok()
											.contentType(MediaType.APPLICATION_OCTET_STREAM)
											.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+encodeName+"\"")
											.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
										.body(resource);
	}
	
	@GetMapping("/data11")
	public List<ChartVO> data11(){
		return examDao.countBySubject();
	}

	@GetMapping("/data12")
	public List<ChartVO> data12(){
		return examDao.countByType();
	}	

	//13, 14번은 동일한 예제
		@GetMapping("/data13")
		public Map<String, Object> data13(){
			Map<String, Object> map = new HashMap<>();
			map.put("title", "과목 별 응시생 수");
			map.put("label", "응시생 수");
			map.put("dataset", examDao.countBySubject());
			return map;
		}

		@GetMapping("/data14")
		public ChartTotalVO data14() {
			ChartTotalVO vo = new ChartTotalVO();
			vo.setTitle("과목 별 응시생 수");
			vo.setLabel("응시생 수");
			vo.setDataset(examDao.countBySubject());
			return vo;
		}
	
}