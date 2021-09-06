package oop.multi6;

public class Test01 {
	public static void main(String[] args) {
		// all-in-one-box의 사용법

		// AllInOneBox의 E를 String으로 설정하여 생성
		AllInOneBox<String> box1 = new AllInOneBox<String>();
		box1.setValue("hello");
		System.out.println(box1.getValue());

	}

}