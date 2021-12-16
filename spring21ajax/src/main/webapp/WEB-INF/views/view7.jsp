<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.preview {
		width:150px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	//목표 : 파일이 선택되자마자 비동기 업로드
	//1. 파일을 ajax로 업로드할때는 FormData 라는 객체가 필요
	//2. multipart 방식으로 전송하기 위해 다음 옵션을 작성
	//	- processData:false
	//- contentType:false
	$(function(){
		$("input[name=attach]").on("input", function(e){
			
// 			파일이 선택되지 않은 경우는 차단
			if(!this.files || !this.files[0]) {
				return;
			}
// 			1. form을 통째로 업로드
// 			var formData = new FormData(폼 JS객체);
// 			var formData = new FormData($("#upload-form")[0]);
// 			2. 낱개 데이터를 업로드
			var formData = new FormData();
			formData.append("attach", this.files[0]);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data9",
				type:"post",
				data:formData,
				dataType:"text",
				processData:false,
				contentType:false,
				success:function(resp){
					console.log("성공", resp);
					
					//목표 : 업로드된 정보(파일번호)를 이용하여 이미지태그를 생성하고 #result에 추가
					//= 예상주소 - http://localhost:8080/spring21/data/data10?no=1
					var tag = $("<img>").attr("src", "${pageContext.request.contextPath}/data/data10?no="+resp)
													.addClass("preview");
					$("#result").append(tag);
				},
				error:function(e){
					console.log("실패", e);
				}
			});
		});
	});
</script>

<form id="upload-form">
	<input type="file" name="attach" accept="image/*">
</form>

<div id="result"></div>