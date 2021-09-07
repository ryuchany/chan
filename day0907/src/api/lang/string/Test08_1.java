package api.lang.string;

public class Test08_1 {
	public static void main(String[] args) {
		//입력
		String[] db = new String[] {
			"자바로 배우는 프로그래밍 생활",
			"나의 자바 개발 노트",
			"자바를 위한, 자바에 의한 슬기로운 개발 블로그",
			"웹개발자가 꼭 알아야할 자바 기술 모음",
			"파이썬과 자바로 구현하는 하이엔드 프로그래밍"
		};

		String keyword = "개발";

		//출력
		for(int i=0; i < db.length; i++) {
			if(db[i].contains(keyword)) {//검색어가 포함되어 있다면
				System.out.println(db[i]);
			}
		}
	}
}
