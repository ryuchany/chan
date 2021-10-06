package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09_2 {
	public static void main(String[] args) throws Exception {
		// Q : product 테이블에서 원하는 항목에 맞는 검사를 수행
		// = 원하는 항목은 이름, 분류

		// 입력
		String kind = "name";// 검색할 컬럼명
		String keyword = "과자";// 검색할 키워드

		// 처리
		// (2) 구문에 replace 명령을 사용하여 치환 처리
		String sql = "select * from product where instr(#1, ?) > 0";
		sql = sql.replace("#1", kind);
		System.out.println(sql);
	}
}
