<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.editor{
		box-sizing:border-box;
		width:100%;
		border:1px solid black;
		min-height:150px;
	}
	
	textarea[name=content] {
		width:1px;
		height:1px;
		resize:none;
		
		position:fixed;
		top:0;
		left:-5px;
	}
</style>    
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	//목표 : 파일이 선택되면 비동기 업로드를 통해 미리보기를 .editor에 추가
	$(function(){
		$(".upload-input").on("input", function(){
			//this == 파일선택창
			if(!this.files || !this.files[0]) return;
			
			var formData = new FormData();
			formData.append("attach", this.files[0]);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/data/data9",
				type:"post",
				data:formData,
				dataType:"text",
				processData:false,
				contentType:false,
				success:function(resp){//resp = 업로드된 파일 번호
					var tag = $("<img>").attr("src", "${pageContext.request.contextPath}/data/data10?no="+resp)
												.css("width", "150px");
					$(".editor").append(tag);
					
					//copy
					copyText();
				},
				error:function(e){}
			});
		});
		
		$(".editor").on("input", function(){
			//copy
			copyText();
		});
		
		function copyText(){
			var origin = $(".editor").html();
			$("textarea[name=content]").val(origin);
		}
	});
</script>

<h1>상용 에디터 원리 파헤치기</h1>

<!-- file 태그를 숨기고 이미지로 대체 -->
<label>
	<img src="${pageContext.request.contextPath}/resources/image/image-upload.jpg" width="50" height="50">
	<input type="file" class="upload-input" style="display:none">
</label>

<br>

<!-- 보여주기용 -->
<div class="editor" contenteditable="true"></div>

<!-- 전송용 -->
<textarea name="content"></textarea>