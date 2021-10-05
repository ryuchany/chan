package api.lang.object;

//Q : 내가 만든 클래스와 Object의 관계
//= 내가 만든 클래스도 Object의 자식 클래스
//= 모든 Object의 기능을 가지며, 재정의 가능
public class Student /*extends Object*/ {
	private String name;
	private int score;

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
}
