package home.servlet.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.BoardFileDao;
import home.beans.BoardFileDto;

/**
 *	파일 업로드를 적용한 서블릿
 * = 사용자의 요청 방식이 multipart/form-data 방식으로 변경되었다.
 * = request를 기존의 형태로 수신할 수 없으며, MultipartRequest(cos.jar)를 이용하여 수신하도록 수정
 * = 저장위치는 D:/upload
 * = 용량제한은 10MB
 * = 인코딩은 UTF-8
 * = 기본 파일 이름 재정의 객체를 적용
 * = req.getParameter()는 mRequest.getParameter()로 바꿔서 사용
 * = 파일 관련된 명령만 따로 존재
 * 		= 파일업로드명 : mRequest.getOriginalFileName()
 * 		= 저장된 파일명 : mRequest.getFileSystemName();
 * 		= 파일 유형 : mRequest.getContentType()
 * 		= 파일 반환 : mRequest.getFile()
 */
@WebServlet(urlPatterns = "/board/write.txt")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//multipart/form-data를 해석하기 위한 객체 생성
			String savePath = "C:/upload/board";
			int maxSize = 10 * 1024 * 1024;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mRequest = 
						new MultipartRequest(req, savePath, maxSize, encoding, policy);
		
			//입력 : BoardDto(boardTitle, boardContent)

			BoardDto boardDto = new BoardDto();
			boardDto.setBoardTitle(mRequest.getParameter("boardTitle"));
			boardDto.setBoardContent(mRequest.getParameter("boardContent"));

			//아이디는 세션에서 수집하여 추가
			boardDto.setBoardWriter((String)req.getSession().getAttribute("ses"));
			
			//새글인지 답글인지 판정 : 파라미터에 boardSuperno가 있으면 답글이다
			boolean answer = mRequest.getParameter("boardSuperno") != null;
			//답글일 경우에는 boardSuperno를 저장한다.
			if(answer) {
				boardDto.setBoardSuperno(Integer.parseInt(mRequest.getParameter("boardSuperno")));
			}

			//처리
			//(1) 일반적인 등록
			//BoardDao boardDao = new BoardDao();
			//boardDao.write(boardDto);

			//(2) 번호를 알아내면서 등록
			BoardDao boardDao = new BoardDao();
			int boardNo = boardDao.getSequence();//시퀀스 번호 생성
			boardDto.setBoardNo(boardNo);//게시글 데이터에 생성된 번호 추가
			//답글일 경우 등록될 글의 정보를 상위글 정보를 기준으로 계산해야 한다.
			if(answer) {
				//1. 상위글의 모든 정보를 불러온다
				BoardDto parentDto = boardDao.get(boardDto.getBoardSuperno());
				//2. 상위글의 정보를 토대로 등록될 글의 정보를 계산한다
				//= 그룹은 동일하게 유지하고 차수는 1 증가시켜서 설정한다
				boardDto.setBoardGroupno(parentDto.getBoardGroupno());
				boardDto.setBoardDepth(parentDto.getBoardDepth() + 1);
				boardDao.writeAnswer(boardDto);//게시글 등록(답글)
			}else{
				boardDao.write2(boardDto);//게시글 등록(새글)
			}

			/**
			 * 게시글 등록을 모두 마친 뒤에 파일 정보를 데이터베이스에 저장하도록 설정
			 * 파일이 존재할 경우만 실행해야 한다.
			 */
			if(mRequest.getFile("attach") != null) {//파일이 attach란 이름으로 올라왔다면
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardNo(boardNo);//게시글 번호
				boardFileDto.setBoardFileSavename(mRequest.getFilesystemName("attach"));//실제저장된이름
				boardFileDto.setBoardFileUploadname(mRequest.getOriginalFileName("attach"));//사용자가올린이름
				boardFileDto.setBoardFileType(mRequest.getContentType("attach"));//파일 유형
				File target = mRequest.getFile("attach");
				boardFileDto.setBoardFileSize(target == null ? 0L : target.length());

				BoardFileDao boardFileDao = new BoardFileDao();
				boardFileDao.insert(boardFileDto);
			}
			
			//출력
			//(1) list.jsp로 리다이렉트
			//resp.sendRedirect("list.jsp");

			//(2) detail.jsp로 리다이렉트
			resp.sendRedirect("detail.jsp?boardNo="+boardNo);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
