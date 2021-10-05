package oop.inherit5;

public class File {

	private String fileName;
	private long fileSize;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		if (fileSize < 0) {
			return;
		}
		this.fileSize = fileSize;
	}

	public void execute() {
		System.out.println("["+this.fileName+"] 파일 실행!");
	}



}
