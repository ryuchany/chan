package oop.keyword2;

public class Screen {

	// 멤버 변수
	private String title; // 사용자 입력(필수)
	private final int width; // 사용자 입력(필수)
	private final int height; // 사용자 입력(필수)

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// 생성옵션 1 : 아무것도 설정하지 않고 설정
	public Screen() { //기본 생성자 : 외부에서 어떠한 값도 받지 않는 생성자
		this.setTitle("Untitle");
		this.width = 600;
		this.height = 400;
	}

	// 생성옵션 2 : 제목만 설정
	public Screen(String title) {
		this.setTitle(title);
		this.width = 600;
		this.height = 400;
	}

	// 생성옵션 3 : 크기만 설정
	public Screen(int width, int height) {
		this.setTitle("Untitle");
		this.width = width;
		this.height = height;
	}

	// 생성옵션 4 : 제목, 크기 설정
	public Screen(String title, int width, int height) {
		this.setTitle(title);
		this.width = width;
		this.height = height;
	}

	public void showInfo() {
		System.out.println("<화면 정보>");
		System.out.println("제목 : " + this.title);
		System.out.println("폭 : " + this.width);
		System.out.println("높이 : " + this.height);
	}
}
