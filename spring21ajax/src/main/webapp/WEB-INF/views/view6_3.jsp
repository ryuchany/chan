<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//처음 들어오면 목록 출력
		loadList();
		
		//#insert-form이 전송되면 전송 못하게 막고 ajax로 insert
		$("#insert-form").submit(function(e){
			//this == #insert-form
			e.preventDefault();
			
			var dataValue = $(this).serialize();
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data7",
				type:"post",
				data : dataValue,
				//dataType 없음
				success:function(resp){
					console.log("성공", resp);
					
					//주의 : this 는 form이 아니다(this는 함수를 기준으로 계산)
					//jQuery는 reset() 명령이 없어서 get(0)으로 javascript 객체로 변경
					//$("#insert-form").get(0).reset();
					$("#insert-form")[0].reset();
					
					//성공하면 목록 갱신
					loadList();
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
	});
	
	function loadList(){
		//#result에 목록을 불러와서 출력
		
		$.ajax({
			url:"${pageContext.request.contextPath}/data/data4",
			type:"get",
			//data:{},
			dataType:"json",
			success:function(resp){
				//resp에 들어있는 데이터들을 #examdto-template에 넣어서 추가
				
				$("#result").empty();//내부영역 청소
				//$("#result").html("");
				//$("#result").text("");
				
				for(var i=0; i < resp.length; i++){
					var template = $("#examdto-template").html();
					
					template = template.replace("{{examId}}", resp[i].examId);
					template = template.replace("{{examId}}", resp[i].examId);
// 					template = template.replace(/\{\{examId\}\}/g, resp[i].examId);
					template = template.replace("{{student}}", resp[i].student);
					template = template.replace("{{subject}}", resp[i].subject);
					template = template.replace("{{type}}", resp[i].type);
					template = template.replace("{{score}}", resp[i].score);
					
					$("#result").append(template);
				}
			},
			error:function(e){}
		});
	}
	
	function deleteData(examIdValue){
		
		$.ajax({
// 			url:"${pageContext.request.contextPath}/data/data8?examId="+examIdValue,
			url:"${pageContext.request.contextPath}/data/data8?"+$.param({"examId":examIdValue}),
			type:"delete",
// 			data:{//delete일 경우 사용 불가
// 				examId : examIdValue
// 			},
			dataType:"text",
			success:function(resp){
				console.log("성공", resp);
				
				loadList();//데이터가 변하면 무조건 갱신
			},
			error:function(e){}
		});
	}
</script>
<template id="examdto-template">
	<div class="item">
		<span>{{examId}}</span>
		<span>{{student}}</span>
		<span>{{subject}}</span>
		<span>{{type}}</span>
		<span>{{score}}</span>
		<button onclick="deleteData({{examId}});">x</button>
	</div>
</template>

<h1>성적 관리</h1>

<form id="insert-form">
	이름 : <input type="text" name="student"><br>
	과목 : <input type="text" name="subject"><br>
	유형 : <input type="text" name="type"><br>
	점수 : <input type="text" name="score"><br>
	<button type="submit">등록</button>
</form>

<div id="result"></div>