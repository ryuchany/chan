<%@page import="home.beans.MemberProfileDto"%>
<%@page import="home.beans.MemberProfileDao"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@page import="home.beans.TotalHistoryDto"%>
<%@page import="home.beans.TotalHistoryDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.Format"%>
<%@page import="home.beans.HistoryDto"%>
<%@page import="home.beans.HistoryDao"%>
<%@page import="java.util.List"%>

<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력 : 현재 로그인한 회원ID - String memberId --%>
<%
	String memberId = (String) session.getAttribute("ses");
%>

<%-- 처리 : 회원정보(MemberDto) --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.get(memberId);

// 아래와 같이 조회하면 취소 여부를 알 수 없다.
//	HistoryDao historyDao = new HistoryDao();
//	List<HistoryDto> historyList = historyDao.findByMemberId(memberId);

// 새롭게 만든 뷰(total_history)를 이용하여 포인트 이력을 조회
	TotalHistoryDao historyDao = new TotalHistoryDao();
	List<TotalHistoryDto> historyList = historyDao.findByMemberId(memberId);
%>

<%
	//내가 작성한 글 보여주기
	BoardDao boardDao = new BoardDao();
	List<BoardDto> myBoardList = boardDao.searchEquals("board_writer", memberId);
%> 
	
<%
	//프로필 이미지 조회 : 아이디로 해도됨(1-1관계)
	MemberProfileDao memberProfileDao = new MemberProfileDao();
	MemberProfileDto memberProfileDto = memberProfileDao.get(memberId);
%>

<%-- 출력 --%>   
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 상세 정보</h2>

<%if(memberProfileDto == null){ %>
<img src="https://via.placeholder.com?text=User" width="150" height="150">
<%}else{ %>
<img src="profile.txt?memberProfileNo=<%=memberProfileDto.getMemberProfileNo()%>" width="150" height="150">
<%} %>

<table border="1" width="300">
	<tbody>
		<tr>
			<th width="25%">아이디</th>
			<td><%=memberDto.getMemberId()%></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><%=memberDto.getMemberNick()%></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=memberDto.getMemberBirthDay()%></td>
		</tr>	
		<tr>
			<th>이메일</th>
			<td><%=memberDto.getMemberEmailString()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=memberDto.getMemberPhoneString()%></td>
		</tr>		
		<tr>
			<th>가입일시</th>
			<td><%=memberDto.getMemberJoin()%></td>
		</tr>
		<tr>
			<th>포인트</th>
			<td><%=memberDto.getMemberPoint()%></td>
		</tr>
		<tr>
			<th>등급</th>
			<td><%=memberDto.getMemberGrade()%></td>
		</tr>							
	</tbody>
</table>

<h3><a href="password.jsp">비밀번호 변경</a></h3>
<h3><a href="edit.jsp">개인정보 변경</a></h3>
<h3><a href="check.jsp">회원 탈퇴</a></h3>

<hr>

<!-- 포인트 내역 출력 -->
<h2>포인트 상세 내역</h2>

<table border="1" width="500">
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
		<%Format f = new DecimalFormat("#,##0"); %>
		<%for(TotalHistoryDto historyDto : historyList) { %>
		<tr>
			<td align="center"><%=historyDto.getHistoryTime()%></td>
			<td align="right"><%=f.format(historyDto.getHistoryAmount())%></td>
			<td align="left"><%=historyDto.getHistoryMemo()%></td>
			<td><%=historyDto.getCancel()%></td>
			<td>
				<%if(historyDto.available()){ %>
<%-- 				<a href="../point/cancel.txt?historyNo=<%=historyDto.getHistoryNo()%>">취소</a> 상대경로 --%>
				<a href="<%=request.getContextPath()%>/point/cancel.txt?historyNo=<%=historyDto.getHistoryNo()%>">취소</a>
				<%} %>
			</td>
		</tr>
		<%} %>
	</tbody>
</table>

<hr>

<h2>내가 작성한 게시글</h2>

<table border="1" width="90%">
	<thead>
		<tr>
			<th>번호</th>
			<th width="60%">제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody align="center">
		<%for(BoardDto boardDto : myBoardList){ %>
		<tr>
			<td><%=boardDto.getBoardNo()%></td>
			<td align="left">

				<%-- 
					게시글의 제목을 출력하기 전에 차수에 따라 띄어쓰기를 진행한다
					띄어쓰기는 HTML 특수문자인 &nbsp; 을 사용한다.
					답변글에는 reply icon을 추가로 출력한다. 
				--%>
				<%
					//if(boardDto.getBoardDepth() > 0){
					if(boardDto.hasDepth()){ 
				%>
					<%for(int i=0; i < boardDto.getBoardDepth(); i++){ %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<%} %>

					<img src="<%=request.getContextPath()%>/resource/image/reply.png" width="15" height="15">
				<%} %>

				<a href="<%=request.getContextPath()%>/board/detail.jsp?boardNo=<%=boardDto.getBoardNo()%>">
					<%=boardDto.getBoardTitle()%>
				</a>

				<!-- 제목 뒤에 댓글 개수를 출력한다 -->
				<%
				//if(boardDto.getBoardReply() > 0){
				if(boardDto.isReplyExist()){
				%>
					[<%=boardDto.getBoardReply()%>]
				<%} %>
			</td>
			<td><%=boardDto.getBoardTime()%></td>
			<td><%=boardDto.getBoardRead()%></td>
		</tr>
		<%} %>
	</tbody>
</table>

<jsp:include page="/template/footer.jsp"></jsp:include>