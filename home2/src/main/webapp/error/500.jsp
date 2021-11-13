<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<div class="container-600 container-center">
	<div class="row center">
		<h2>일시적인 서버 오류가 발생했습니다</h2>
	</div>
	<div class="row">
		<img src="<%=request.getContextPath()%>/resource/image/error.png" width="100%">		
	</div>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>