<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블(표)</title>
</head>
<body>

	<!-- 
		table 태그 : 
		= 화면에 표를 만들고 싶을 경우 사용하는 태그
		= HTML에서 만드는 표는 줄 수와 칸 수를 지정하지 않고 만든다
		
		thead - 테이블 상단 제목 영역
		tbody - 테이블 중단 데이터 영역
		tfoot - 테이블 하단 영역
		tr - 줄 영역
		th - 칸 영역(bold + center)
		td - 칸 영역(plain + left)
	 -->
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>과목</th>
				<th>유형</th>
				<th>점수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>피카츄</td>
				<td>수학</td>
				<td>필기</td>
				<td>50</td>
			</tr>
			<tr>
				<td>2</td>
				<td>라이츄</td>
				<td>수학</td>
				<td>필기</td>
				<td>60</td>
			</tr>
			<tr>
				<td>3</td>
				<td>파이리</td>
				<td>수학</td>
				<td>필기</td>
				<td>55</td>
			</tr>
		</tbody>
		<tfoot>

		</tfoot>
	</table>

</body>
</html>