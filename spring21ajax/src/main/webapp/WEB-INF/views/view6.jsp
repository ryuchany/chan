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
					template = template.replace("{{examId}}", resp[i].examId);
// 					template = template.replace(/\{\{examId\}\}/g, resp[i].examId);
					template = template.replace("{{student}}", resp[i].student);
					template = template.replace("{{subject}}", resp[i].subject);
					template = template.replace("{{type}}", resp[i].type);
					template = template.replace("{{score}}", resp[i].score);
					
// 					버튼에 onclick을 작성할 경우
// 					$("#result").append(template);
					
// 					버튼에 class와 data-exam-id를 두고 이벤트를 jquery에서 부여하는 경우
					var tag = $(template);//template은 글자니까 jQuery로 감싸서 생성을 시키고
					tag.find(".remove-btn").click(function(){//tag에서 .remove-btn을 찾아서 클릭 이벤트 지정하고
						deleteData($(this).data("exam-id"));
					});
					tag.find(".edit-btn").click(function(){
						var examId = $(this).prevAll(".exam-id").text();
						var student = $(this).prevAll(".student").text();
						var subject = $(this).prevAll(".subject").text();
						var type = $(this).prevAll(".type").text();
						var score = $(this).prevAll(".score").text();
						
						var form = $("<form>");
						form.append("<input type='hidden' name='examId' value='"+examId+"'>");
						form.append("<input type='text' name='student' value='"+student+"'>");
						form.append("<input type='text' name='subject' value='"+subject+"'>");
						form.append("<input type='text' name='type' value='"+type+"'>");
						form.append("<input type='text' name='score' value='"+score+"'>");
						form.append("<button type='submit'>수정</button>");
						
						form.submit(function(e){
							e.preventDefault();
							
							//ajax...
						});
						
						var div = $(this).parent();
						div.html(form);
					});
					$("#result").append(tag);//추가!
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
		<span class="exam-id">{{examId}}</span>
		<span class="student">{{student}}</span>
		<span class="subject">{{subject}}</span>
		<span class="type">{{type}}</span>
		<span class="score">{{score}}</span>
		<button class="edit-btn" data-exam-id="{{examId}}">e</button>
		<button class="remove-btn" data-exam-id="{{examId}}">x</button>
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