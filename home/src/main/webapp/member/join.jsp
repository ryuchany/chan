<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>>

<h1>회원가입</h1>

<!-- 
	form 전송방식
	= form은 데이터 전송방식을 GET/POST 중에서 고를 수 있다.
	= 적지 않으면 GET 형태로 전송한다.
	= GET은 주소 뒷부분에 ?를 시작으로 한 파라미터 문자열(Query String) 형태로 데이터를 첨부
		= 장점 : 편하다. form이 아니어도 a태그 등으로도 데이터를 전달할 수 있다.
		= 단점 : 데이터가 주소에 노출, 주소는 256byte까지 밖에 작성이 안되므로 크기 제한이 있음
	= POST는 주소 뒷부분이 아닌 HTTP Body에 데이터를 첨부
		= 장점 : 데이터가 주소에 노출되지 않음. 첨부 데이터 길이가 무제한
		= 단점 : 불편하다. form이 있어야 전송이 가능하며, 데이터가 ASCII로 변환되어 전송된다.
	= GET/POST는 보안과 관계가 없다.	
 -->
<form action="join.txt" method=post>
	
	<table border="0">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="memberId" required>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="memberPw" required>
				</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" name="memberNick" required>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="date" name="memberBirth" required>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="memberEmail">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="memberPhone">
				</td>
			</tr>
			<tr>
				<!-- 
					colspan을 사용하면 셀 1개를 특정 칸 수만큼 늘릴 수 있다.
					rowspan을 사용하면 셀 1개를 특정 줄 수만큼 늘릴 수 있다.
					두 개를 동시에 사용하진 않는다 
				-->
				<td colspan="2" align="right">
					<input type="submit" value="가입">
				</td>
			</tr>
		</tbody>
	</table>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>