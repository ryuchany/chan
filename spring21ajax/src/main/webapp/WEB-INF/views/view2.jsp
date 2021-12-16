<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		
		$("button").click(function(){
			//입력값을 가져와서 해당 id를 조회
			var examIdValue = $("input[name=examId]").val();
			
			//입력값이 부정적인 형태면 차단(자바스크립트에서만 가능.. false, 0, "", undefined, null, ...)
			if(!examIdValue) return;
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data5",
				type:"get",
				data:{
					examId:examIdValue
				},
				dataType:"json",
				success:function(resp){
					console.log("성공", resp);
					console.log(resp.examId, resp.student, resp.subject, resp.type, resp.score);
					
					$(".examId > span").text(resp.examId);
					$(".student > span").text(resp.student);
					$(".subject > span").text(resp.subject);
					$(".type > span").text(resp.type);
					$(".score > span").text(resp.score);
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
		
	});
</script>

<h1>View2</h1>

<input type="text" name="examId">
<button>click</button>

<div id="result">
	<h1 class="examId">번호 : <span>?</span></h1>
	<h1 class="student">이름 : <span>?</span></h1>
	<h1 class="subject">과목 : <span>?</span></h1>
	<h1 class="type">유형 : <span>?</span></h1>
	<h1 class="score">점수 : <span>?</span></h1>
</div>