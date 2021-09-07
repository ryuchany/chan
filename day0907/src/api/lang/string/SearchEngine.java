package api.lang.string;

public class SearchEngine {

	private String[] db = new String[] {
		"자바로 배우는 프로그래밍 생활",
		"나의 자바 개발 노트",
		"자바를 위한, 자바에 의한 슬기로운 개발 블로그",
		"웹개발자가 꼭 알아야할 자바 기술 모음",
		"파이썬과 자바로 구현하는 하이엔드 프로그래밍"
	};

	public String[] search(String keyword) {
		int count = 0;
		for(int i=0; i < db.length; i++) {
			if(db[i].contains(keyword)) {//검색어가 포함되어 있다면
				count++;
			}
		}
	

		//db에 들어있는 데이터 중 keyword가 포함된 데이터만 result로 복사가 이루어진다
		String[] result = new String[count];//결과 수 만큼 배열을 만들고
		int index = 0;
		for(int i=0; i < db.length; i++) {
			if(db[i].contains(keyword)) {
				result[index] = db[i];
				index++;
			}
		}

		return result;
	}
	
   // 빈도 측정 추가
	
	public int frequency(String example, String word) {
		int index = 0;
		int count = 0;

		while(true) {
			index = example.indexOf(word, index);

			if(index == -1) {//-1이면 없다는 소리
				break;
			}
			count++;
			index++;
		}

		return count;
	}

}
