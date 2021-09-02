package oop.keyword3;

//계산기 클래스 : 덧셈 전용
public class PlusCalculator {
	// 멤버 변수
	private int left; // 필수
	private int right; // 필수

	// 멤버 메소드
	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getLeft() {
		return this.left;
	}

	public int getRight() {
		return this.right;
	}

	public int getTotal() {
		return this.left + this.right;
	}

	// 생성자
	public PlusCalculator(int left, int right) {
		this.setLeft(left);
		this.setRight(right);
	}
}
