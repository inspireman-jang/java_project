package co.yedam.variable;

import java.util.Scanner;

/*
 * Scanner 클래스 활용
 */

public class VariableExe5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 (키보드 입력)
		
		String numStr = "123";
		int num = Integer.parseInt(numStr); //문자열을 숫자로 변경해주는 클래스 Integer.parseInt
		
		System.out.println(num);
		
		int sum =0;
				
		while(true) {
			System.out.println("정수값을 입력: 종료하면 quit >>> ");
			String result = scan.nextLine(); // 입력값을 문자열로 반환
			System.out.printf("입력값은 %s입니다. \n", result);
			
			if (result.equals("quit")) { //문자 비교할때는 equals를 사용해야함
				break;
			}
						
			int numPaser = Integer.parseInt(result) ;
			
			if(  0 < numPaser || numPaser < 100) {
				continue;
			}else {
				sum += Integer.parseInt(result);
			}				
			
			if (sum >= 100) { //합계가 100이상이면 반복문 종료
				System.out.printf("합계는 100이상이므로 종료합니다.");
				break;
			}
		}
		System.out.printf("입력값의 합계는 " + sum + "\n");
		System.out.print("end of prog.");
	}
}
