package oop.multi1;

//자바의 절대 규칙 : 클래스는 단 하나만 상속이 가능하다. 왜? 모호한 상황이 생기기 때문에!
//= 그렇다고 다중상속이 필요없다고 생각하는것은 아니다
//= 다중상속은 반드시 필요하지만 오류의 가능성(ex:모호성)이 매우 높은 방법

//사람 클래스

//public class Person extends Comedian{
//public class Person extends Mc {
//public class Person extends Comedian extends Mc {//에러
//public class Person extends Comedian, Mc {//에러
//	public Person(String name) {
//		super(name);//Q : super는 Comedian일까요? Mc일까요? (모호성)
//	}
//}
