package api.util.calendar;

public class Test04 {
	public static void main(String[] args) {

		//입력
		int year = 2021;
		int month = 9;

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
				System.out.print("?");
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}

	}
}
