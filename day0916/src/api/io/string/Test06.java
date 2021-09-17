package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		File target = new File("sample", "user.txt");
		FileWriter out = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(out);
		PrintWriter printer = new PrintWriter(buffer);

		// [키보드] → System.in → sc → [프로그램] → printer → buffer → out → target → [user.kh]

		System.out.print("입력 : ");
		String line = sc.nextLine();
		printer.println(line);

		sc.close();
		printer.close();
	}
}
