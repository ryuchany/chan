<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%-- 입력 : memberId (parameter) --%>
<%
	String memberId = request.getParameter("memberId");
%>

<%-- 처리 --%>
<%
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.get(memberId);
%>

<%-- 출력 --%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>회원 정보 수정</h2>

<form action="edit.kh" method="post">

	<table border="0">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
<%-- 					<input type="text" name="memberId" required value="<%=memberDto.getMemberId()%>" readonly> --%>
					<input type="hidden" name="memberId" required value="<%=memberDto.getMemberId()%>">
					<%=memberDto.getMemberId()%>
				</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" name="memberNick" required value="<%=memberDto.getMemberNick()%>">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="date" name="memberBirth" required value="<%=memberDto.getMemberBirthDay()%>">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="memberEmail" value="<%=memberDto.getMemberEmailString()%>">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="memberPhone" value="<%=memberDto.getMemberPhoneString()%>">
				</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=memberDto.getMemberJoin()%></td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>
					<input type="number" name="memberPoint" value="<%=memberDto.getMemberPoint()%>">
				</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
<%-- 					<input type="text" name="memberGrade" value="<%=memberDto.getMemberGrade()%>"> --%>
					<select name="memberGrade">
						<%if(memberDto.getMemberGrade().equals("정회원")){ %>
						<option>준회원</option>
						<option selected>정회원</option>
						<option>우수회원</option>
						<%}else if(memberDto.getMemberGrade().equals("우수회원")){ %>
						<option>준회원</option>
						<option>정회원</option>
						<option selected>우수회원</option>
						<%}else { %>
						<option selected>준회원</option>
						<option>정회원</option>
						<option>우수회원</option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
				</td>
			</tr>
		</tbody>
	</table>

</form>

<jsp:include page="/template/footer.jsp"></jsp:include>