<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	//버튼을 누르면 /data/ 로 요청을 보냄
	//ajax 통신에서 사용하는 속성
	//= url : 요청을보낼주소
	//= type : 요청방식(get/post/put/delete)
	//= dataType : 기대하는결과 형태(text/html/xml/json/...)
	//= data : 전송할 데이터
	//= success : 성공 시 실행할 코드 함수
	//= error : 실패 시 실행할 코드 함수
	$(function(){
		$("button").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/data/",
				type:"get",
				dataType:"text",
				success:function(resp){
					console.log("성공", resp);
					$("#result").html(resp);
// 					$("#result").append(resp);
				},
				error:function(e){
					console.log("실패", e);
					//alert("통신 실패");
				}
			});
		});
	});
</script>


<h1>View 1</h1>

<button>click</button>

<div id="result"></div>