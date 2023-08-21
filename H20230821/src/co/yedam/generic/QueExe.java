package co.yedam.generic;

import java.util.LinkedList;
import java.util.Queue;

//First in Frist out
public class QueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("One");
		que.offer("Two");
		que.offer("Three");

		while (!que.isEmpty()) {
			try {
				String val = que.poll();
				System.out.println(val);
			} catch (Exception e) {
				System.out.println("모든 예외 처리");
				System.out.println("에러코드:" + e);
			}
		}
	}
}
