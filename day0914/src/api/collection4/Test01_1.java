package api.collection4;

import java.util.Stack;

public class Test01_1 {
	public static void main(String[] args) {
		//Stack과 Queue
		//= Queue : 대기열. 줄을 서서 기다리는 형태. FIFO(선입선출) 구조
		//= Stack :  출입구가 하나뿐인 저장소 형태. LIFO(후입선출) 구조
		//= 이러한 저장소들은 사용법이 정해져 있으므로 그 이외의 사용이 불가

		Stack<String> st = new Stack<>();

		st.push("아이유");
		st.push("공유");
		st.push("이동욱");
		st.push("한지민");
		st.push("전지현");

		while(!st.empty()) {
			System.out.println(st.pop());
		}

	}
}
