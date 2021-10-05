package oop.constructor3;

public class User {

	// 멤버 변수
	private String id;
	private String job;
	private int level;
	private int gold;

	// 세터 & 게터
	public void setId(String id) {
		this.id = id;
	}

	public void setJob(String job) {
		switch (job) {
		case "전사":
		case "마법사":
		case "궁수":
			this.job = job;
		}
	}

	public void setLevel(int level) {
		if (level < 1) {
			return;
		}
		this.level = level;
	}

	public void setGold(int gold) {
		if (gold < 0) {
			return;
		}
		this.gold = gold;
	}

	public String getId() {
		return this.id;
	}

	public String getJob() {
		return this.job;
	}

	public int getLevel() {
		return this.level;
	}

	public int getGold() {
		return this.gold;
	}

	// 생성자
	// [1] 아이디와 직업만 설정하는 생성자. 이 때 레벨은 1, 소지금은 0Gold
	// [2] 아이디, 직업, 레벨, 소지금을 설정할 수 있는 생성자
	public User(String id, String job) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(1);
//		this.setGold(0);
	}

	public User(String id, String job, int level, int gold) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setGold(gold);
	}

	public void showInfo() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.id);
		System.out.println("직   업 : " + this.job);
		System.out.println("레   벨 : " + this.level + " Lv");
		System.out.println("소지금 : " + this.gold + " Gold");
	}

}
