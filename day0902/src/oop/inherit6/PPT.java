package oop.inherit6;

public class PPT extends File{

	private int pageSize; 

	public PPT(String fileName, long fileSize) {
		super(fileName, fileSize);
	}
	public PPT(String fileName, long fileSize, int pageSize) {
		super(fileName, fileSize);
		this.pageSize = pageSize;
	}

	public void information() {
		//protected 항목은 자식 클래스에서 직접 접근이 가능하다.
		System.out.println("[파일 정보 출력]");
		System.out.println("파일 이름 : " + this.fileName);
		System.out.println("파일 크기 : " + this.fileSize);
		System.out.println("파일 크기 : " + super.fileSize);
	}
}
