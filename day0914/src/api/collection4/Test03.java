package api.collection4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test03 {
	public static void main(String[] args) {
		// Queue : FIFO(선입선출) 저장소
		// = 등록한 순서대로 추출이 가능하므로 작업 순서등을 설정할 때 유리

		Queue<String> q = new ArrayBlockingQueue<>(10);

		q.add("아이유");
		q.add("공유");
		q.add("이동욱");
		q.add("한지민");
		q.add("전지현");

		System.out.println(q.peek());// 조회(누가 나올 차례인가요?)
		System.out.println(q);// 데이터 변화 없음
		System.out.println(q.poll());// 추출(나오세요!)
		System.out.println(q);// 데이터 사라짐
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
	}
}
