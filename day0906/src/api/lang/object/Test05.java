package api.lang.object;

public class Test05 {
	public static void main(String[] args) {
		// 내가 만든 클래스 "Student"의 객체 비교는 어떻게 하나?
		Student a = new Student();
		Student b = new Student();

		System.out.println(a == b);// 객체 비교

		// 재정의를 통해서 비교 기준을 원하는 대로 수정할 수 있다.
		// = 동등 비교를 수정하지 않으면 작동하지 않음
		// = 전체가 같은 경우 또는 일부가 같은 경우 등 원하는 기준에 의해 객체 비교 결과가 나오도록 설정가능
		// = 딱 하나만 정할 수 있으므로 상황에 따라 바꾸는 일은 없어야 한다.
		System.out.println(a.equals(b));
	}
}
