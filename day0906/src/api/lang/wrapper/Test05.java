package api.lang.wrapper;

public class Test05 {
	public static void main(String[] args) {
		// 원시형과 참조형의 비교 차이
		// = 원시형은 값만 보관하고 있기 때문에 비교연산은 값을 비교하게 되어 있다
		int a = 10;
		int b = 10;
		System.out.println(a == b);// 같은 값인가요?

		Integer c = new Integer(10);
		Integer d = new Integer(10);
		Integer e = c;
		System.out.println(c == d);// 같은 객체인가요?
		System.out.println(c == e);

		// 객체에서 일반적으로 "같음"은 동일한 객체인지를 말하는 것이다.(동일비교)
		// = 상황에 따라서는 객체가 아니라 속성이 같으면 같다고 보는 경우도 있다
		// = (ex) 서로 다른 휴대폰이 "같은 기종"과 "같은 색상"인 경우 나머지 정보가 달라도 같다고 본다(동등비교)
		// = 비교 연산은 "동일"함을 비교하도록 되어 있으므로 "동등"함을 비교하는 명령이 따로 필요
		// = equals 메소드를 이용하여 비교한다.
		System.out.println(c.equals(d));// 객체 구성요사가 같나요? (동등한가요?)

		// 결론 : 앞으로 객체는 특별한 사유가 없다면 equals() 메소드로 비교한다
	}
}
