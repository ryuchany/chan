<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$(".buy-btn").click(function(){
			//하나도 체크되지 않은 경우는 중지
			if($("input[name=no]:checked").length == 0) return;
			
			//form을 임시로 만들어서 body에 추가(전송용)
			//<form action="test" method="post"></form>
			var form = $("<form>").attr("action", "test").attr("method", "post").addClass("send-form");
			$("body").append(form);
			
			//모든 div를 돌면서 내부에 존재하는 checkbox와 수량을 조사한 뒤 체크된 항목에 대해서 번호와 수량을 별도의 form에 첨부
			var count = 0;
			$(".product").each(function(){
				//this == 현재 반복중인 div
				var checkbox = $(this).find("input[name=no]");
				var number = $(this).find("input[name=quantity]");
				console.log(checkbox, number);
				
				if(checkbox.prop("checked")){//체크박스가 체크된 경우
					//체크박스의 value가 상품번호이고 입력창의 숫자가 상품수량이므로 이 둘을 각각 별도의 form에 추가
					var no = checkbox.val();
					var quantity = number.val();
					
					$("<input type='hidden' name='list["+count+"].no'>").val(no).appendTo(".send-form");
					$("<input type='hidden' name='list["+count+"].quantity'>").val(quantity).appendTo(".send-form");
					count++;
				}
			});
			
			//전송
			form.submit();
		});
	});
</script>


<h1>결제 테스트</h1>

<c:forEach var="productDto" items="${list}">
	<div class="product">
		<!-- 체크박스를 선택하면 데이터가 이동하도록 처리 -->
		<input type="checkbox" name="no" value="${productDto.no}">
		${productDto.no} / ${productDto.name} / ${productDto.price}
		<input type="text" name="quantity" value="1" size="3">  
	</div>
</c:forEach>

<button class="buy-btn">구매하기</button>


<h1><a href="pay/history">결제 이력 보기</a></h1>