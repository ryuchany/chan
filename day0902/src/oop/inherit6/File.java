package oop.inherit6;

//Q : File과 같은 "슈퍼클래스"에서 구성요소를 만들 때 고려해야할 사항
//-> 변수를 만들 때 고려해야할 사항 (접근 제한)
//		1. private 설정 시 "자식 클래스"가 접근할 수 없음
//		2. protected 설정 시 "자식 클래스"는 제한 없이 접근할 수 있음
//		- private 설정 시 "자식 클래스"가 접근할 수 없음
//		- protected 설정 시 "자식 클래스"는 제한 없이 접근할 수 있음
//-> 메소드를 만들 때 고려해야할 사항
//		- "재정의(Override)" 여부를 고려해야 한다.
//		- 재정의를 금지시킬 경우에는 final 키워드를 사용한다.
//-> 생성자를 만들 때 고려해야할 사항
//		- 객체 생성을 위한 데이터 설정(초기화)을 수행하는 구문
//		- 자식 클래스에서도 부모 클래스의 생성자를 맞춰야한다
public class File {
	// 변수
	protected String fileName;
	protected long fileSize;

	// 생성자
	public File(String fileName, long fileSize) {
		this.setFileName(fileName);
		this.setFileSize(fileSize);
	}

	// 메소드
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void execute() {// super
		System.out.println("파일을 실행합니다");
	}

}
