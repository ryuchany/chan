<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.detail-view {
		position:fixed;
		top:0;
		right:0;
		bottom:0;
		width:400px;
	}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$(".detail-btn").click(function(){
			//this == 클릭한 버튼
			//var examIdValue = $(this).prev().prev().text();
			//var examIdValue = $(this).attr("data-exam-id");
			var examIdValue = $(this).data("exam-id");
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data5",
				type:"get",
				data:{
					examId : examIdValue
				},
				dataType:"json",
				success:function(resp){
					console.log("성공");
					
					$(".examId > span").text(resp.examId);
					$(".student > span").text(resp.student);
					$(".subject > span").text(resp.subject);
					$(".type > span").text(resp.type);
					$(".score > span").text(resp.score);
				},
				error:function(e){
					console.log("실패");
				}
			});
		});
	});
</script>

<h1>학생 시험 정보</h1>

<c:forEach var="examDto" items="${list}">
	<h3>
		<span>${examDto.examId} </span>
		<span>${examDto.student}</span>
		<button class="detail-btn" data-exam-id="${examDto.examId}">상세보기</button>
	</h3>
</c:forEach>

<div class="detail-view">
	<h3 class="examId">번호 : <span>?</span></h3>
	<h3 class="student">이름 : <span>?</span></h3>
	<h3 class="subject">과목 : <span>?</span></h3>
	<h3 class="type">유형 : <span>?</span></h3>
	<h3 class="score">점수 : <span>?</span>점</h3>
</div>