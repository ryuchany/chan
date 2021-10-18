<%@page import="web09.beans.ExamDto"%>
<%@page import="java.util.List"%>
<%@page import="web09.beans.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 프로그래밍 영역 --%>
<%
	ExamDao examDao = new ExamDao();
	List<ExamDto> list = examDao.select();
%>

<%-- 화면 영역 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 정보 목록</title>
</head>
<body>

	<h1>시험 정보 목록</h1>

	<!-- 표 -->
	<table border="1" width="700">
		<!-- 제목 -->
		<thead>
			<tr>
				<th>번호</th>
				<th>학생명</th>
				<th>과목명</th>
				<th>유형</th>
				<th>점수</th>
			</tr>
		</thead>

		<!-- 데이터 -->
		<tbody align="center">
			<%for(ExamDto examDto : list){ %>
			<tr>
				<td><%=examDto.getExamId()%></td>
				<td><%=examDto.getStudent()%></td>
				<td><%=examDto.getSubject()%></td>
				<td><%=examDto.getType()%></td>
				<td><%=examDto.getScore()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>

</body>
</html>

