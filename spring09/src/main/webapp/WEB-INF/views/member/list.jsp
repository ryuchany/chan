<%@page import="com.kh.spring09.entity.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>    

<h1>회원 목록</h1>

<%for(MemberDto memberDto : list){%>
	<div><%=memberDto%></div>
<%}%>