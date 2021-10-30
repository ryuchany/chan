<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 파일 업로드 처리 페이지 -->

<%
	//기존 요청 방식일 경우의 수신 코드
	request.setCharacterEncoding("UTF-8");
	String attach = request.getParameter("attach");
%>

<h3>attach = <%=attach%></h3>

<%
	//Multipart 요청 방식일 경우의 수신 코드
	//1. cos.jar 라이브러리를 이용하여 파일 업로드 및 저장을 수행
	//- 장점 : 편하고 코드가 비교적 간단하다.
	//- 단점 : 파일을 같은 이름으로 1개만 수신할 수 있다.
	//2. apache-commons-fileupload 라이브러리를 이용하여 파일 업로드 및 저장을 수행
	//- 장점 : 같은 이름으로 다중 선택하여 전송되는 파일을 처리할 수 있다.
	//- 단점 : 코드가 상대적으로 복잡하다.
	
	//cos.jar에서는 MultipartRequest라는 클래스를 제공하며 이를 통해 multipart 요청을 처리
	//= multipart/form-data 방식에서는 99.999% 확률로 "파일"이 전송된다.
	//= 따라서 파일의 처리(저장)와 관련된 값들을 설정해야 요청을 수신할 수 있다.
	//= (1) 해석할 요청 객체 : request
	//= (2) 저장될 위치 : savePath
	//= (3) 허용할 업로드 제한크기(byte) : maxSize
	//= (4) 해석할 Encoding 방식 : encoding
	//= (5) [선택] 작명정책 객체 : policy
	
	String savePath = "c:/upload";
	int maxSize = 1 * 1024 * 1024;//1MB
	String encoding = "UTF-8";
	DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	//요청 해석 및 파일 저장
	MultipartRequest mRequest = 
			new MultipartRequest(request, savePath, maxSize, encoding, policy);
	
	//데이터베이스에 저장하기 위하여 정보를 추출
	String uploadName = mRequest.getOriginalFileName("attach");//원래이름
	String saveName = mRequest.getFilesystemName("attach");//저장된이름
	String contentType = mRequest.getContentType("attach");//파일의 MIME-TYPE
	
	File target = mRequest.getFile("attach");//저장된 파일의 객체 반환(없으면 null)
	long fileSize = target == null ? 0L : target.length();
%>

<h3>uploadName = <%=uploadName%></h3>
<h3>saveName = <%=saveName%></h3>
<h3>contentType = <%=contentType%></h3>
<h3>target = <%=target%></h3>
<h3>fileSize = <%=fileSize%></h3>