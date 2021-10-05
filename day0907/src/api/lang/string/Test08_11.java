package api.lang.string;

public class Test08_11 {
	public static void main(String[] args) {
		// 필터링과 빈도측정을 결합
		SearchEngine engine = new SearchEngine();

		String keyword = "자바";

		String[] result = engine.search(keyword);

		// 처리 : 버블정렬
		for (int h = result.length - 1; h > 0; h--) {// 마지막 위치부터 1까지
			for (int k = 0; k < h; k++) {// h회차 반복문
				int freq1 = engine.frequency(result[k], keyword);// k위치의 빈도
				int index1 = result[k].indexOf(keyword);// k위치의 시작
				int freq2 = engine.frequency(result[k + 1], keyword);// k+1위치의 빈도
				int index2 = result[k + 1].indexOf(keyword);// k+1위치의 시작

				// 빈도가 낮은 경우에 뒤로 이동, 빈도가 같으면 위치가 큰 것을 뒤로 이동
				// if(빈도가 낮거나 또는 빈도가 같으면서 위치가 크다면) {
				if (freq1 < freq2 || (freq1 == freq2 && index1 > index2)) {
					String temp = result[k];
					result[k] = result[k + 1];
					result[k + 1] = temp;
				}
			}
		}

		for (int i = 0; i < result.length; i++) {
//			System.out.print("[빈도 : "+engine.frequency(result[i], keyword)+"] ");
//			System.out.print("[시작 : "+result[i].indexOf(keyword)+"]");
			System.out.println(result[i]);
		}
	}
}
