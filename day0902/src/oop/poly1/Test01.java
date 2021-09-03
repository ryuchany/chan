package oop.poly1;

public class Test01 {
	public static void main(String[] args) {
		//객체 생성 후 업캐스팅 처리

		GalaxyFold3 fold = new GalaxyFold3();		
		fold.call();
		fold.samsungPay();

		Phone phone = fold;//업캐스팅(아무런 변환 처리 없이 자동 변환 가능. 묵시적 형변환)
		phone.call();
//		phone.samsungPay();//있는데 못쓴다!

//		GalaxyFold3 fold2 = phone;//안된다(휴대폰이 갤럭시폴드3는 아니니까)
		GalaxyFold3 fold2 = (GalaxyFold3)phone;//다운캐스팅(업캐스팅이 선행되어야 한다)
		
		fold2.call();
		fold2.samsungPay();
	}
}
