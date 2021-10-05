package connect;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException {
		//Q : 오라클 데이터베이스로의 접속(로그인) 시도

		//자바에서는 데이터베이스가 꼭 오라클이 아니어도 상관이 없다.
		//= 자바에서 오라클 정보를 기본적으로 알아야 하나?
		//= 오라클에 관련된 정보를 자바에게 알려줄 필요가 있다.
		//= 프로젝트 우클릭 -> [build path] -> [configure build path] -> [libraries] -> [add JARs] -> ojdbc8.jar 추가

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("오라클 드라이버 설치 완료");

	}
}
