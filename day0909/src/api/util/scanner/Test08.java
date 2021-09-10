package api.util.scanner;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) throws IOException {
		// Scanner를 이용하여 홈페이지 소스 읽기
		// (참고) : 정규표현식에서 .*? 이라는 표현은 뒤 글자가 나오기 전까지의 모든 글자를 의미한다.
		// = <span>(.*?)</span> 에서 (.*?)은 <span>과 </span>사이에 어떤 글자가 있어도 무관하다는 의미
		URL url = new URL("https://www.rottentomatoes.com/");

		Scanner sc = new Scanner(url.openStream(), "UTF-8");

		while (sc.hasNextLine()) {
//			<span class="dynamic-text-list__item-title clamp clamp-1">Cinderella</span>
			String line = sc
					.findInLine("<span\\s*class=\"dynamic-text-list__item-title\\sclamp\\sclamp-1\">(.*?)<\\/span>");// 원하는
																														// 부분
			if (line != null) {// 패턴과 일치하는 데이터를 찾은 경우
//				System.out.println(line);
//				첫 번째 > 와 마지막 < 의 위치를 찾아서 잘라내기
				int begin = line.indexOf(">") + 1;
				int end = line.lastIndexOf("<");
				System.out.println(line.substring(begin, end).replace("&#39;", "'"));
			} else {// 패턴과 일치하는 데이터를 못찾은 경우
				sc.nextLine();// 나머지 부분을 읽고 다음 줄로 이동
			}
		}

		sc.close();
	}
}
