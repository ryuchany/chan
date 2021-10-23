<%@page import="home.beans.GroupPointVO"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>사이트 통계</h2>

<h3>회원계층별 포인트 보유량</h3>
<%
	MemberDao memberDao = new MemberDao();
	List<GroupPointVO> list = memberDao.pointByGrade();
%>

<%for(GroupPointVO vo : list){ %>
	<h5>
		<%=vo.getMemberGrade()%> - <%=vo.getTotal()%> point
	</h5>
<%} %>


<jsp:include page="/template/footer.jsp"></jsp:include>