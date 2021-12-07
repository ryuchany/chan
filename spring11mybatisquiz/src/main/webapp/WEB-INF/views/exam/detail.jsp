<%@page import="com.kh.spring11.entity.ExamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ExamDto examDto = (ExamDto) request.getAttribute("examDto");
%>

<h1>시험 상세 정보</h1>

<ul>
	<li>응시번호 : <%=examDto.getExamId()%></li>
	<li>학생명 : <%=examDto.getStudent()%></li>
	<li>과목명 : <%=examDto.getSubject()%></li>
	<li>유형 : <%=examDto.getType()%></li>
	<li>점수 : <%=examDto.getScore()%>점</li>
</ul>