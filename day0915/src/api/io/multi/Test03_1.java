package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		//로또번호 6개를 sample/lotto.txt에 저장
		//-> 복원추출, 비복원추출

		List<Integer> numbers = new ArrayList<>();
		for(int i=1; i<=45; i++) {
			numbers.add(i);
		}

		Collections.shuffle(numbers);

		List<Integer> partList = numbers.subList(0, 6);
		Collections.sort(partList);

		System.out.println(partList);

		//멀티바이트 출력 준비
		File target = new File("sample", "lotto.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);

		for(int n : partList) {
			data.writeInt(n);
		}

		data.close();
	}
}
