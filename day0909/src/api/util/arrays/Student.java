package api.util.arrays;

//비교 기준을 클래스에 내장시킬 수 있다.
//= java.lang.Comparable 인터페이스를 상속받고 compareTo 메소드를 재정의
public class Student implements Comparable<Student>{
	private String name;
	private int score;
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
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		//o1 == this , o2 == o
		if(this.getName().equals(o.getName())) {
			return o.getScore() - this.getScore();
		}
		else {
			return this.getName().compareTo(o.getName());
		}
	}
}
