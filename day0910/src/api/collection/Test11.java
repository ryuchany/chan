package api.collection;

public class Test11 {
	public static void main(String[] args) {

		Artist a = new Artist("대니구", "바이올린");
		System.out.println(a);

		// 투표 수 1 증가
		// a.count++;
		int count = a.getCount();
		a.setCount(count + 1);
		System.out.println(a);

		// vote() 메소드를 부르면 투표수가 1 증가
		a.vote();
		System.out.println(a);

	}
}
