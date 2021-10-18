<%--
	exam 테이블 데이터에 대한 단일 조회 페이지
 --%>
<%@page import="web09.beans.ExamDto"%>
<%@page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 : int examId --%>
<%
	int examId = Integer.parseInt(request.getParameter("examId"));
%>

<%-- 처리 --%>  
<%
	ExamDao examDao = new ExamDao();
	ExamDto examDto = examDao.select(examId);
%>
<%-- 출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정보 상세</title>
</head>
<body>

	<h1>시험 정보 상세</h1>

	<ul>
		<li>시험지번호 : <%=examDto.getExamId()%></li>
		<li>학생명 : <%=examDto.getStudent()%></li>
		<li>과목명 : <%=examDto.getSubject()%></li>
		<li>유형 : <%=examDto.getType()%></li>
		<li>점수 : <%=examDto.getScore()%> 점</li> 
	</ul>

	<h5><a href="test06_1.jsp">목록 보기</a></h5>

</body>
</html>

