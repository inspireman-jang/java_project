package co.yedam.generic;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		// Stack : 마지막에 들어 온 값이 제일 먼저 출력 됨

		Stack<String> stack = new Stack<>();

		stack.push("One");
		stack.push("Two");
		stack.push("Three");

		while (!stack.isEmpty()) {
			String val = stack.pop();
			System.out.println(val);
		}

	}
}
