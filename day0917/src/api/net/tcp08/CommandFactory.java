package api.net.tcp08;

public class CommandFactory {

	//명령을 이용하여 응답을 생성하는 메소드
	public static String create(String command) {
		switch(command) {
		case "$동기부여": return "넌 언젠가 지구최강의 개발자가 될거야!";
		case "$화이팅": return "우리모두 화이팅!";
		case "$링크": return "문서 사이트는 https://hiphop5782.github.io 입니다";
		default: return "지원하지 않는 명령입니다";
		}
	}
}
