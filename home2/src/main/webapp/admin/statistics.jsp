<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.Format"%>
<%@page import="home.beans.GroupPointVO"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	MemberDao memberDao = new MemberDao();
	List<GroupPointVO> list = memberDao.pointByGrade();
	
	Format f = new DecimalFormat("#,##0");
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-300 container-center">
	<div class="row center">
		<h2>사이트 통계</h2>		
	</div>
	<hr>
	<div class="row center">
		<h3>회원계층별 포인트 보유량</h3>		
	</div>
	<div class="row">
		<table class="table table-stripe table-border">
			<thead>
				<tr>
					<th>회원그룹</th>
					<th>포인트 보유량</th>
				</tr>
			</thead>
			<tbody>
				<%for(GroupPointVO vo : list){ %>
				<tr>
					<td><%=vo.getMemberGrade()%></td>
					<td class="right"><%=f.format(vo.getTotal())%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</div>


<jsp:include page="/template/footer.jsp"></jsp:include>