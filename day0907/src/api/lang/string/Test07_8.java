package api.lang.string;

public class Test07_8 {
	public static void main(String[] args) {
//		문자열 덧셈 (원하는 개수만큼 별 문자열 만들기)
//		= StringBuffer 또는 StringBuilder를 이용하여 처리를 하면 카피 없이 빠르게 처리가 가능!
//		= 문자열 덧셈 특화 도구

		int size = 50000;

		StringBuilder builder = new StringBuilder();//비어있는 저장소 생성

		long a = System.currentTimeMillis();//기준시(1970.01.01 자정)부터 지금까지 흘러온 밀리초(ms)

		for(int i=0; i < size; i++) {
			builder.append("*");
		}

		long b = System.currentTimeMillis();
		long ms = b - a;

		System.out.println(ms+" ms");

//		System.out.println(builder.toString());
	}
}
