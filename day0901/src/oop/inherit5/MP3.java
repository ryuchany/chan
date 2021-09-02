package oop.inherit5;

public class MP3 extends MediaFile {

	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration < 0) {
			return;
		}
		this.duration = duration;
		System.out.println("재생 시간 = " + duration + "초");
	}

}
