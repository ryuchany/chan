<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.Format"%>
<%@page import="home.beans.CoinDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.CoinDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	CoinDao coinDao = new CoinDao();
	List<CoinDto> list = coinDao.list();
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-600 container-center">

	<div class="row center">
		<h2>포인트 상품 관리</h2>	
	</div>

	<div class="row right">
		<a href="add.jsp" class="link-btn">상품등록</a>
	</div>

	<div class="row">
		<table class="table table-border table-hover">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>상품금액</th>
					<th>관리메뉴</th>
				</tr>
			</thead>
			<tbody align="center">
				<%Format f = new DecimalFormat("#,##0"); %>
				<%for(CoinDto coinDto : list){ %>
				<tr>
					<td><%=coinDto.getCoinNo()%></td>
					<td class="left"><%=coinDto.getCoinName()%></td>
					<td class="right"><%=f.format(coinDto.getCoinAmount())%></td>
					<td> 
						<a href="./edit.jsp?coinNo=<%=coinDto.getCoinNo()%>" class="a-link-btn">수정</a>
						<a href="./delete.txt?coinNo=<%=coinDto.getCoinNo()%>" class="a-link-btn">삭제</a>
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>

	<div class="row right">
		<a href="add.jsp" class="link-btn">상품등록</a>
	</div>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>