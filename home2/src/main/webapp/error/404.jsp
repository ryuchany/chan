<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<div class="container-600 container-center">
	<div class="row center">
		<h2>페이지를 찾을 수 없습니다</h2>
	</div>
	<div class="row">
		<img src="<%=request.getContextPath()%>/resource/image/error.png" width="100%">		
	</div>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>