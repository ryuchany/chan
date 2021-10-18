<%@page import="web09.beans.ExamDto"%>
<%@page import="java.util.List"%>
<%@ page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	exam 테이블의 데이터들을 조회하여 화면에 HTML 방식으로 출력
	= 프로그래밍 조회 코드 + HTML 출력 코드
 --%>

<%
	//프로그래밍 조회 코드
	ExamDao examDao = new ExamDao();
	List<ExamDto> list = examDao.select();
%>

<!-- HTML 출력코드 : 조회한 list에서 ExamDto의 이름만 출력 -->
<% for(ExamDto examDto : list){ %>
	<h3><%=examDto.getStudent()%></h3>
<% } %>