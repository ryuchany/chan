<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		//#insert-form이 전송되면 전송 못하게 막고 ajax로 insert
		$("#insert-form").submit(function(e){
			//this == #insert-form
			e.preventDefault();
			
			var studentValue = $(this).find("input[name=student]").val();
			var subjectValue = $(this).find("input[name=subject]").val();
			var typeValue = $(this).find("input[name=type]").val();
			var scoreValue = $(this).find("input[name=score]").val();
			
			if(!studentValue || !subjectValue || !typeValue || !scoreValue){
				return;
			}
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data7",
				type:"post",
				data:{
					student : studentValue,
					subject : subjectValue,
					type : typeValue,
					score : scoreValue
				},
				//dataType 없음
				success:function(resp){
					console.log("성공", resp);
					
					//주의 : this 는 form이 아니다(this는 함수를 기준으로 계산)
					$("input[name=student]").val("");
					$("input[name=subject]").val("");
					$("input[name=type]").val("");
					$("input[name=score]").val("");
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
	});
</script>

<h1>성적 관리</h1>

<form id="insert-form">
	이름 : <input type="text" name="student"><br>
	과목 : <input type="text" name="subject"><br>
	유형 : <input type="text" name="type"><br>
	점수 : <input type="text" name="score"><br>
	<button type="submit">등록</button>
</form>