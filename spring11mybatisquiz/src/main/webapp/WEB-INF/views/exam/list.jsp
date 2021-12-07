<%@page import="com.kh.spring11.entity.ExamDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ExamDto> list = (List<ExamDto>)request.getAttribute("list");
%>

<table border="1" style="border-collapse: collapse;">
	<thead>
		<tr>
			<th>응시번호</th>
			<th>학생명</th>
			<th>과목명</th>
			<th>유형</th>
			<th>점수</th>
			<th>메뉴</th>
		</tr>
	</thead>
	<tbody>
	<% for(ExamDto examDto : list) { %>
		<tr>
			<td><%=examDto.getExamId()%></td>
			<td><%=examDto.getStudent()%></td>
			<td><%=examDto.getSubject()%></td>
			<td><%=examDto.getType()%></td>
			<td><%=examDto.getScore()%></td>
			<td>
				<a href="detail?examId=<%=examDto.getExamId()%>">1</a>
				<a href="detail/<%=examDto.getExamId()%>">2</a>
			</td>
		</tr>
	<% } %>
	</tbody>
</table>
