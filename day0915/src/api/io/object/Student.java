package api.io.object;

import java.io.Serializable;

//POJO(Plain Old Java Object) 클래스
//파일입출력에 이 클래스를 활용할 계획이 있다면 java.io.Serializable을 상속받아 자격을 획득해야 한다
//= 마킹 인터페이스(Marking Interface)

//클래스에 부여할 수 있는 옵션
//1. transient 키워드를 이용해서 특정 필드를 입출력에서 제외할 수 있다.
//2. 클래스의 버전(SerialVersionUID)을 설정할 수 있다.
// = 클래스의 버전을 바꾸면 이전 버전의 모든 저장된 데이터를 사용할 수 없다.
// = 강제 업데이트를 시킬 수 있다.
public class Student implements Serializable {

	private static final long serialVersionUID = 2L;

	private String name;
	private int score;
	private transient String hobby;// 입출력 제외 설정(transient)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Student(String name, int score, String hobby) {
		super();
		this.name = name;
		this.score = score;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", hobby=" + hobby + "]";
	}
}
