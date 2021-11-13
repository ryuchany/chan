<%@page import="home.beans.BoardFileDto"%>
<%@page import="home.beans.BoardFileDao"%>
<%@page import="home.beans.ReplyDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.ReplyDao"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 번외 : 수정 버튼을 눌렀을 때 처리되도록 구현하는 스크립트(나중에 배움) --%>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		$(".view-row").find(".edit-btn").click(function(){
			$(this).parents("tr.view-row").hide();
			$(this).parents("tr.view-row").next("tr.edit-row").show();
		});
		
		$(".edit-row").find(".edit-cancel-btn").click(function(){
			$(this).parents("tr.edit-row").hide();
			$(this).parents("tr.edit-row").prev("tr.view-row").show();
		});
		
		$(".edit-row").hide();
	});
</script>     
    
<%-- 입력 : 게시글번호(boardNo) --%>
<%
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
%>

<%-- 처리 --%>
<%
String memberId = (String)session.getAttribute("ses"); 
BoardDao boardDao = new BoardDao();

/**
조회수 중복 방지에 대한 시나리오
1. 본인 글에 대한 조회 수 증가를 방지한다.
2. 한 번 읽은 글에 대한 추가 조회 수 증가를 방지한다.
	= 세션에 사용자가 읽은 글 번호를 추가하여 관리하도록 구현
3. IP를 이용한 조회 수 증가를 방지한다.
	= 접속자 IP 확인 명령을 통한 IP 비교
	= 사용자에게 반드시 이용 고지를 해야함(IP는 개인정보)
	= 전체 사용자에게 영항을 줄 수 있는 저장소가 필요
*/

//1. boardViewedNo 라는 이름의 저장소를 세션에서 꺼내어 본다.
Set<Integer> boardViewedNo = (Set<Integer>)session.getAttribute("boardViewedNo");

//2. boardViewedNo 가 null 이면 "처음 글을 읽는 상태"임을 말하므로 저장소를 신규로 생성
if(boardViewedNo == null){
boardViewedNo = new HashSet<>();
//System.out.println("처음으로 글을 읽기 시작했습니다(저장소 생성)");
}

//3. 현재 글 번호를 저장소에 추가해본다
//3-1. 추가가 된다면 이 글은 처음 읽는 글
//3-2. 추가가 안된다면 이 글은 두 번 이상 읽은 글
if (boardViewedNo.add(boardNo)) {//처음 읽은 글인 경우
boardDao.readUp(boardNo, memberId);//조회수 증가(남에 글일때만)
//System.out.println("이 글은 처음 읽는 글입니다");
} else {
//System.out.println("이 글은 읽은 적이 있습니다");
}

//System.out.println("저장소 : " + boardViewedNo);

//4. 저장소 갱신
session.setAttribute("boardViewedNo", boardViewedNo);

BoardDto boardDto = boardDao.get(boardNo);//단일조회

//본인 글인지 아닌지를 판정하는 변수
//boolean owner = 세션의ses 값과 게시글 작성자가 같은가?;

boolean owner = boardDto.getBoardWriter().equals(memberId);
%>

<%
	//현재 게시글에 대한 댓글을 조회
	ReplyDao replyDao = new ReplyDao();
	List<ReplyDto> replyList = replyDao.list(boardNo);
%>

<%
	//현재 게시글에 대한 파일정보를 조회
	BoardFileDao boardFileDao = new BoardFileDao();
	List<BoardFileDto> boardFileList = boardFileDao.find(boardNo);//파일이 여러 개일 경우
	//BoardFileDto boardFileDto = boardFileDao.find2(boardNo);//파일이 한 개일 경우
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include> 
<style>
	.flex-container > .reply-write-wrapper {
		width:80%;
	}
	.flex-container > .reply-send-wrapper {
		flex-grow:1;
	}
	.flex-container > .reply-send-wrapper > .form-btn,
	.flex-container > .reply-send-wrapper > .form-link-btn {
		width:100%;
		height:100%;
		display: flex;
		align-items:center;
		justify-content:center;
	}
</style>

<div class="container-800 container-center">

	<div class="row center">
		<h2><%=boardDto.getBoardNo()%>번 게시글</h2>		
	</div>

	<div class="row">
		<hr>
		<h3><%=boardDto.getBoardTitle()%></h3>
		<hr>
	</div>

	<div class="row">
		등록일 : <%=boardDto.getBoardTime()%>
		|
		작성자 : <%=boardDto.getBoardWriter()%>
		|
		조회수 : <%=boardDto.getBoardRead()%>
	</div>

	<div class="row" style="min-height:250px;">
		<pre><%=boardDto.getBoardContent()%></pre>
	</div>

	<div class="row right">
		<a href="write.jsp" class="link-btn">글쓰기</a>
		<a href="write.jsp?boardSuperno=<%=boardDto.getBoardNo()%>" class="link-btn">답글쓰기</a>
		<a href="list.jsp" class="link-btn">목록보기</a>

		<%if(owner){ %>
		<a href="edit.jsp?boardNo=<%=boardDto.getBoardNo()%>" class="link-btn">수정하기</a>
		<a href="delete.txt?boardNo=<%=boardDto.getBoardNo()%>" class="link-btn">삭제하기</a>
		<%} %>
	</div>

	<hr>

	<!-- 댓글 작성 영역 -->
	<form action="./reply/insert.txt" method="post">
	<input type="hidden" name="boardNo" value="<%=boardDto.getBoardNo()%>">

	<div class="row flex-container">
		<div class="reply-write-wrapper">
			<textarea name="replyContent" required rows="4" class="form-input"></textarea>
		</div>
		<div class="reply-send-wrapper">
			<input type="submit" value="댓글작성" class="form-btn">
		</div>
	</div>

	</form>

	<!-- 댓글 목록 -->
	<%if(replyList.isEmpty()){ %>	
	<div class="row center">
		<h3>작성된 댓글이 없습니다</h3>
	</div>
	<%} else { %>
	<div class="row center">
		<table class="table table-stripe">
			<tbody>
				<%for(ReplyDto replyDto : replyList){ %>
				<%
					//본인 댓글인지 판정 : 세션의 회원아이디와 댓글의 작성자를 비교
					//작성자 댓글인지 판정 : 게시글 작성자와 댓글의 작성자를 비교
					boolean myReply = memberId.equals(replyDto.getReplyWriter());
					boolean ownerReply = boardDto.getBoardWriter().equals(replyDto.getReplyWriter());
				%>
				<tr class="view-row">
					<td width="20%">
						<%=replyDto.getReplyWriter()%>
						<%-- 게시글 작성자의 댓글에는 표시 --%>
						<%if(ownerReply){ %>
							<span class="error">(작성자)</span>
						<%} %>

						<br>
						(<%=replyDto.getReplyFullTime()%>)
					</td>
					<td class="left">
						<pre><%=replyDto.getReplyContent()%></pre>
					</td>
					<td width="20%">
					<%-- 현재 사용자가 작성한 글에만 수정, 삭제를 표시 --%>
					<%if(myReply){ %>
					<a class="edit-btn link-btn">수정</a>
					<a href="reply/delete.txt?boardNo=<%=replyDto.getBoardNo()%>&replyNo=<%=replyDto.getReplyNo()%>" class="link-btn">삭제</a>
					<%} %>
					</td>
				</tr>

				<%-- 본인 글일 경우 수정을 위한 공간을 추가적으로 생성 --%>
				<%if(myReply){ %>
				<tr class="edit-row">
					<td colspan="3">
						<form action="reply/edit.txt" method="post">
						<input type="hidden" name="replyNo" value="<%=replyDto.getReplyNo()%>">
							<input type="hidden" name="boardNo" value="<%=replyDto.getBoardNo()%>">

						<div class="flex-container">
							<div class="reply-write-wrapper">
								<textarea name="replyContent" required rows="4" cols="80" class='form-input'><%=replyDto.getReplyContent()%></textarea>
							</div>
							<div class="reply-send-wrapper">
								<input type="submit" value="수정" class="form-btn">
							</div>
							<div class="reply-send-wrapper">
								<a class="edit-cancel-btn form-link-btn">취소</a>
							</div>
						</div>

						</form>
					</td>
				</tr>
				<%} %>

				<%} %>
			</tbody>
		</table>
	</div>	
	<%} %>

	<%-- 첨부파일이 있다면 첨부파일을 다운받을 수 있는 링크를 제공 --%>
	<%if(!boardFileList.isEmpty()){ %>
	<%for(BoardFileDto boardFileDto : boardFileList){ %>
		<div class="row">
			<h3>
				<%=boardFileDto.getBoardFileUploadname() %>
				(<%=boardFileDto.getBoardFileSize()%> bytes)
				<a href="file/download.txt?boardFileNo=<%=boardFileDto.getBoardFileNo()%>">
					다운로드
				</a>
			</h3>
		</div>
		<%} %>
	<%} %>	

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>