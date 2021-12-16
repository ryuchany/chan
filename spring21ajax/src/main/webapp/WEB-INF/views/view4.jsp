<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	//tern-eclipse 플러그인을 설치하면 자바스크립트 자동완성이 어느정도 지원됨
	$(function(){
		$("button").click(function(){
			//목록을 불러와서 #result에 출력
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data4",
				type:"get",
				//data:{}
				dataType:"json",
				success:function(resp){
					console.log("성공", resp);
					
					for(var i=0; i < resp.length; i++){
						var template = $("#examdto-template").html();
						
						template = template.replace("{{examId}}", resp[i].examId);
						template = template.replace("{{student}}", resp[i].student);
						template = template.replace("{{subject}}", resp[i].subject);
						template = template.replace("{{type}}", resp[i].type);
						template = template.replace("{{score}}", resp[i].score);
						
						$("#result").append(template);
					}
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
	});
</script>

<h1>ajax 목록</h1>

<button>보기</button>

<div id="result"></div>

<template id="examdto-template">
	<div class="item">
		<span>{{examId}}</span>
		<span>{{student}}</span>
		<span>{{subject}}</span>
		<span>{{type}}</span>
		<span>{{score}}</span>
	</div>
</template>