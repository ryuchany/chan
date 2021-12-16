<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		var page = 1;
		var size = 10;
		
		$(".more-btn").click(function(){
			loadData(page, size);
			page++;
		});
		
		//더보기 버튼을 강제 1회 클릭(트리거)
		$(".more-btn").click();
		
		//내부적으로 사용할 함수(외부에서는 호출 불가)
		function loadData(pageValue, sizeValue){
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data6",
				type:"get",
				data:{
					page : pageValue,
					size : sizeValue
				},
				dataType:"json",
				success:function(resp){
					console.log("성공", resp);
					
					//데이터가 sizeValue보다 적은 개수가 왔다면 더보기 버튼을 삭제
					if(resp.length < sizeValue){
						$(".more-btn").remove();
					}
					
					//데이터 출력
					for(var i=0; i < resp.length; i++){
						var html = "<h2>"+resp[i].examId+"/"+resp[i].student+"</h2>";
						$("#result").append(html);
					}
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		}
	});
	
	
</script>

<h1>시험 점수 목록</h1>

<div id="result"></div>

<button class="more-btn">더보기</button>