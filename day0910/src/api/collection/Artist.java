package api.collection;

import java.util.Objects;

public class Artist implements Comparable<Artist> {
	// 멤버 변수(필드)
	private String name;
	private String position;
	private int count;

	// setter & getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Artist(String name, String position) {
		super();
		this.name = name;
		this.position = position;
//		this.count = 0;
	}

	@Override
	public String toString() {
		return "Artist [name=" + name + ", position=" + position + ", count=" + count + "]";
	}

	public void vote() {
		this.count++;
	}

//	이름이 같으면 같은 대상이라는 비교기준을 설정하고 싶으면
//	--> equals & hashCode
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return Objects.equals(name, other.name);
	}

	public Artist(String name) {
		super();
		this.name = name;
	}

//	정렬 기준을 내장시키고 싶다면
//	--> Comparable 상속 후 compareTo 재정의
	@Override
	public int compareTo(Artist other) {
		if (this.getCount() == other.getCount()) {// 투표수가 같으면
			return this.getName().compareTo(other.getName());// 이름 오름차순
		} else {// 투표수가 다르면
			return other.getCount() - this.getCount();// 투표수 내림차순
		}
	}

}
