<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>대표 결제 정보</h1>
<ul>
	<li>고유번호 : ${buyDto.no}</li>
	<li>거래번호 : ${buyDto.tid}</li>
	<li>거래명 : ${buyDto.itemName}</li>
	<li>거래금액 : ${buyDto.totalAmount}</li>
	<li>거래시각 : ${buyDto.buyTime}</li>
	<li>현재상태 : ${buyDto.status}</li>
</ul>

<c:if test="${buyDto.status != '전체취소'}">
<h2><a href="cancel_all?no=${buyDto.no}">전체 취소</a></h2>
</c:if>

<hr>

<ul>
<c:forEach var="buyDetailDto" items="${buyDetailList}">
	<li>
		${buyDetailDto}

		<c:if test="${buyDetailDto.status != '취소'}">
		<a href="cancel_part?buyNo=${buyDetailDto.buyNo}&productNo=${buyDetailDto.productNo}">해당항목 취소</a>
		</c:if>
	</li>
</c:forEach>
</ul>
<hr>
<ul>
	<li>tid : ${responseVO.tid}</li>
	<li>cid : ${responseVO.cid}</li>
	<li>status : ${responseVO.status}</li>
	<li>partner_order_id : ${responseVO.partner_order_id}</li>
	<li>partner_user_id : ${responseVO.partner_user_id}</li>
	<li>payment_method_type : ${responseVO.payment_method_type}</li>
	<li>amount : ${responseVO.amount}</li>
	<li>canceled_amount : ${responseVO.canceled_amount}</li>
	<li>cancel_available_amount : ${responseVO.cancel_available_amount}</li>
	<li>item_name : ${responseVO.item_name}</li>
	<li>item_code : ${responseVO.item_code}</li>
	<li>quantity : ${responseVO.quantity}</li>
	<li>created_at : ${responseVO.created_at}</li>
	<li>approved_at : ${responseVO.approved_at}</li>
	<li>canceled_at : ${responseVO.canceled_at}</li>
	<li>selected_card_info : ${responseVO.selected_card_info}</li>
	<li>
		payment_action_detail : ${responseVO.payment_action_details}
		<ul>
	