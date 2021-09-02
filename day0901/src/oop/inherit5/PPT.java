package oop.inherit5;

public class PPT extends File {

	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 0) {
			return;
		}
		this.pageSize = pageSize;
	}

	public void information() {
		System.out.println("<파일 정보 확인>");
		System.out.println("파일명 : " + super.getFileName()); // 내꺼에 없으므로 부모클래스 탐색
		System.out.println("파일크기 : " + super.getFileSize() + "bytes");
		System.out.println("프레제테이션 크기 : " + this.pageSize + "장"); //내꺼에 있다 this
	}

}
