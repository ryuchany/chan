package oop.inherit5;

public class AVI extends MediaFile {

	private float speed;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		if (speed < 0 || speed > 2) {
			return;
		}
		this.speed = speed;
	}

}
