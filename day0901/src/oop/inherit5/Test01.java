package oop.inherit5;

public class Test01 {
	public static void main(String[] args) {

		MP3 f1 = new MP3();
		f1.setFileName("aaa");
		System.out.println("파일명 = " + f1.getFileName() + ".mp3");
		f1.setFileSize(12345L);
		System.out.println("파일크기 = " + f1.getFileSize() + "bytes");
		f1.setDuration(1000);

		f1.execute();
		f1.forward();
		f1.rewind();

		System.out.println();

		AVI f2 = new AVI();
		f2.setFileName("bbb");
		System.out.println("파일명 = " + f2.getFileName() + ".avi");
		f2.setFileSize(678910L);
		System.out.println("파일크기 = " + f2.getFileSize() + "bytes");
		f2.setSpeed(1.5f);
		System.out.println("재생 속도 = x" + f2.getSpeed());
		
		f2.execute();
		f2.forward();
		f2.rewind();

		System.out.println();

		PPT f3 = new PPT();
		f3.setFileName("ccc");
		System.out.println("파일명 = " + f3.getFileName() + ".ppt");
		f3.setFileSize(123456789L);
		System.out.println("파일크기 = " + f3.getFileSize() + "bytes");
		f3.setPageSize(3);
		System.out.println("페이지 수 = " + f3.getPageSize());
		
		f3.execute();
		f3.information();

	}
}
