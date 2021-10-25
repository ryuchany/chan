<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>접근 권한이 없습니다</h2>

<img src="<%=request.getContextPath()%>/resource/image/403.jpg" width="700" height="400">

<jsp:include page="/template/footer.jsp"></jsp:include>