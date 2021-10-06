package jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09_1 {
	public static void main(String[] args) throws Exception {
		// Q : product 테이블에서 원하는 항목에 맞는 검사를 수행
		// = 원하는 항목은 이름, 분류

		// 입력
		String kind = "name";// 검색할 컬럼명
		String keyword = "과자";// 검색할 키워드

		// 처리
		// (1) 구문에 직접 항목을 더하여 완성
		String sql = "select * from product where instr(" + kind + ", ?) > 0";
		System.out.println(sql);
	}
}