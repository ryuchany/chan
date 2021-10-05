package jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//최종 insert 형태
		//직접 구문을 더하여 만드는 방식의 문제점
		//1. 구문 형태를 보기 어렵다(문자열, 숫자, 날짜에 따른 표시 방식이 다르다)
		//2. 구문에서 사용하는 글자들을 값으로 추가할 수 없다. 혼선이 발생한다.(ex : KH's스페셜)
		//3. SQL Injection 공격이 발생할 수 있다.(입력값에 구문을 넣어서 정보를 탈취하는 기법)
		//=> 해결책 : 전송객체(PreparedStatement)에게 데이터 설정을 위임
		//=> 문제점 : 구문의 완성된 형태를 알 수 없다.
		
		String menuName= "팥빙수";
		int menuPrice = 5000;
		String menuType = "디저트";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","kh", "0000");
		
		//동적 SQL 생성 방식에서는 위치 홀더(?)를 사용하여 데이터가 들어갈 자리를 표시
		//-> PreparedStatement를 이용해서 위치 홀더에 어떤 형태의 데이터를 채울 것인지 명을 내린다
		String sql = "insert into menu(menu_name, menu_price, menut_type) values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, menuName);//1번 위치홀더(?)에 menuName을 String 형태로 채울거에요!
		ps.setInt(2, menuPrice);//2번 위치홀더(?)에 menuPrice를 int 형태로 채울거에요!
		ps.setString(3, menuType);//3번 위치홀더(?)에 menuType을 String 형태로 채울거에요!
		
		ps.execute();//시킨대로 가서 실행하세요!
		
		con.close();
	
	}
}
