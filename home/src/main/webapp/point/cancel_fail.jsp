<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>결제 취소 실패 - 이미 취소된 내역입니다.</h2>

<h5><a href="<%=request.getContextPath()%>">메인 페이지로</a></h5>
<h5><a href="<%=request.getContextPath()%>/member/mypage.jsp">내 정보 보기</a></h5>

<jsp:include page="/template/footer.jsp"></jsp:include>