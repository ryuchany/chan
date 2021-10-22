<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.Format"%>
<%@page import="home.beans.HistoryDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.HistoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 입력 --%>
<%
	String memberId = request.getParameter("memberId");
%>

<%-- 처리 --%>
<%
	HistoryDao historyDao = new HistoryDao();
	List<HistoryDto> historyList = historyDao.findByMemberId(memberId);
%>

<%-- 출력 --%>
<table border="1" width="500">
	<thead>
		<tr>
			<th>일시</th>
			<th>금액</th>
			<th>메모</th>
		</tr>
	</thead>
	<tbody>
		<%Format f = new DecimalFormat("#,##0"); %>
		<%for(HistoryDto historyDto : historyList) { %>
		<tr>
			<td align="center"><%=historyDto.getHistoryTime()%></td>
			<td align="right"><%=f.format(historyDto.getHistoryAmount())%></td>
			<td align="left"><%=historyDto.getHistoryMemo()%></td>
		</tr>
		<%} %>
	</tbody>
</table>