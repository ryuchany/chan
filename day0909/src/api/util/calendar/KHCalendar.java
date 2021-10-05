package api.util.calendar;

import java.util.Calendar;

//연도와 월을 이용하여 달력을 출력하는 클래스
public class KHCalendar {
	private Calendar c = Calendar.getInstance();

	public void setYear(int year) {
		this.c.set(Calendar.YEAR, year);
	}
	public void setMonth(int month) {
		if(month < 1 || month > 12) {
			return;
		}
		this.c.set(Calendar.MONTH, month - 1);
	}
	public int getYear() {
		return this.c.get(Calendar.YEAR);
	}
	public int getMonth() {
		return this.c.get(Calendar.MONTH) + 1;
	}
	public int getDay() {
		return this.c.get(Calendar.DATE);
	}

	public void prev() {
		this.c.add(Calendar.DATE, -1);
	}
	public void prev(int size) {
		this.c.add(Calendar.DATE, -size);
	}
	public void next() {
		this.c.add(Calendar.DATE, 1);
	}
	public void next(int size) {
		this.c.add(Calendar.DATE, size);
	}

	public KHCalendar(int year, int month) {
		this.setYear(year);
		this.setMonth(month);
	}

	public void print() {
		int year = this.getYear();
		int month = this.getMonth();

		c.set(Calendar.DATE, 1);

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		int beforeDays = dayOfWeek - 1;//뒤로 이동해야할 날짜
		//c.add(Calendar.DATE, -beforeDays);
		this.prev(beforeDays);

		//출력
		System.out.print("<");
		System.out.print(year);
		System.out.print("년");
		System.out.print(" ");
		System.out.print(month);
		System.out.print("월");
		System.out.print(">");
		System.out.println("\n");

		System.out.println("일\t월\t화\t수\t목\t금\t토\n");

		for(int i=0; i < 6; i++) {
			for(int k=0; k < 7; k++) {
				System.out.print(this.getDay());
				System.out.print("\t");

				this.next();//c.add(Calendar.DATE, 1);
			}
			System.out.println();
			System.out.println();
		}
	}
}
