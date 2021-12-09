<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 출력 --%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
	.float-container > .float-item-left:nth-child(1) {
		width:25%;	
		padding:0.5rem;
	}
	.float-container > .float-item-left:nth-child(2) {
		width:75%;
		padding:0.5rem;
	}
	
	.link-btn {
		width:100%;
	}
</style>

<!-- 이 페이지를 2단으로 구현 -->
<div class="container-900 container-center">
	<div class="row">
		<h2>회원 상세 정보</h2>
	</div>
	<div class="row float-container">

		<!-- 1단 -->
		<div class="float-item-left">
			<!-- 회원 프로필 이미지 -->
			<div class="row">
				<c:choose>
					<c:when test="${memberProfileDto == null}">
					<img src="https://via.placeholder.com/300x300?text=User" width="100%" class="image image-round image-border">
					</c:when>
					<c:otherwise>
					<img src="profile.kh?memberProfileNo=${memberProfileDto.memberProfileNo}" width="100%" class="image image-round image-border">
					</c:otherwise>
				</c:choose>

			</div>

			<!-- 회원 아이디 -->
			<div class="row center">
				<h2>${memberDto.memberId}</h2>
			</div>

			<!-- 각종 메뉴들 -->
			<div class="row center">
				<a href="password" class="link-btn-block">비밀번호 변경</a>
			</div>
			<div class="row center">
				<a href="edit" class="link-btn-block">개인정보 변경</a>
			</div>
			<div class="row center">
				<a href="quit" class="link-btn-block">회원 탈퇴</a>
			</div>

		</div>

		<!-- 2단 -->
		<div class="float-item-left">

			<!-- 회원 정보 출력 -->
			<div class="row">
				<h2>회원 상세 정보</h2>
			</div>
			<div class="row">
				<table class="table table-stripe">
					<tbody>
						<tr>
							<th width="25%">아이디</th>
							<td>${memberDto.memberId}</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>${memberDto.memberNick}</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>${memberDto.getMemberBirthDay()}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${memberDto.memberEmail}</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td>${memberDto.memberPhone}</td>
						</tr>
						<tr>
							<th>가입일시</th>
							<td>${memberDto.memberJoin}</td>
						</tr>
						<tr>
							<th>포인트</th>
							<td>${memberDto.memberPoint}</td>
						</tr>
						<tr>
							<th>등급</th>
							<td>${memberDto.memberGrade}</td>
						</tr>
					</tbody>
				</table>
			</div>

			<!-- 포인트 내역 출력 -->
			<div class="row">
				<h2>포인트 상세 내역</h2>
			</div>

			<div class="row">
				<table class="table table-border table-hover">
					<thead>
						<tr>
							<th>일시</th>
							<th>금액</th>
							<th>메모</th>
							<th>cancel</th>
							<th>취소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="historyDto" items="${historyList}">
						<tr>
							<td>${historyDto.historyTime}</td>
							<td class="right">${historyDto.historyAmount}</td>
							<td class="left">${historyDto.historyMemo}</td>
							<td>${historyDto.cancel}</td>
							<td>
								<c:if test="${historyDto.available()}">
								<a href="${pageContext.request.contextPath}/point/cancel?historyNo=${historyDto.historyNo}">취소</a>
								</c:if>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- 내가 작성한 게시글 출력 -->
			<div class="row">
				<h2>내가 작성한 게시글</h2>
			</div>
			<div class="row">
				<table class="table table-border table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th width="50%">제목</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
<tbody>
						<c:forEach var="boardDto" items="${myBoardList}">
						<tr>
							<td>${boardDto.boardNo}</td>
							<td class="left">

								<%-- 
									게시글의 제목을 출력하기 전에 차수에 따라 띄어쓰기를 진행한다
									띄어쓰기는 HTML 특수문자인 &nbsp; 을 사용한다.
									답변글에는 reply icon을 추가로 출력한다. 
								--%>
								<c:if test="${boardDto.hasDepth()}">
									<c:forEach var="i" begin="1" end="${boardDto.boardDepth}" step="1">
										&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach>

									<img src="${pageContext.request.contextPath}/resources/image/reply.png" width="15" height="15">
								</c:if>

								<a href="${pageContext.request.contextPath}/board/detail?boardNo=${boardDto.boardNo}">
									${boardDto.boardTitle}
								</a>

								<!-- 제목 뒤에 댓글 개수를 출력한다 -->
								<c:if test="${boardDto.isReplyExist()}">
									[${boardDto.boardReply}]
								</c:if>
							</td>
							<td>${boardDto.boardTime}</td>
							<td>${boardDto.boardRead}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>