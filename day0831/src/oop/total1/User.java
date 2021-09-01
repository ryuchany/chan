package oop.total1;

public class User {
	// 멤버 변수
	private String id; // 사용자 입력(필수)
	private String password; // 사용자 입력(필수)
	private String nickname; // 사용자 입력(필수)
	private int point; // 사용자 미입력(기본값 100포인트)
	private String grade; // 사용자 미입력(기본값 준회원)

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPoint(int point) {
		if (point < 0) {
			return;
		}
		this.point = point;
	}

	public void setGrade(String grade) {
		switch (grade) {
		case "준회원":
		case "정회원":
		case "우수회원":
		case "특별회원":
		case "VVIP":
		case "관리자":
			this.grade = grade;
		}
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public int getPoint() {
		return this.point;
	}

	public String getGrade() {
		return this.grade;
	}

	// 생성자
	public User(String id, String password, String nickname) {
		this.setId(id);
		this.setPassword(password);
		this.setNickname(nickname);
		this.setPoint(100);
		this.setGrade("준회원");
	}

	public void showInfo() {
		System.out.println("<회원 정보>");
		System.out.println("아이디 : " + this.id);
		System.out.println("닉네임 : " + this.nickname);
		System.out.println("포인트 : " + this.point + " point");
		System.out.println("등   급 : " + this.grade);
	}
}
