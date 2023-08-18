package co.yedam.variable;

import java.io.IOException;

public class VariableExe4 {
	public static void main(String[] args) {
		// 이름은 홍길동이고, 나이는 20살압니다.
		String name = "홍길동";
		int age = 20;
		double weight = 66.5;
		
		System.out.println("이름은 " + name + ", 나이는 " + age + "살 입니다." );
		System.out.printf("이름은 %s, 나이는 %06d살 %%\t입니다. 몸무게는 %.2f \n ", name, age, weight );
		
		try {
			System.out.println("값을 입력 >>>");
			while (true) {
				
				int result = System.in.read();	
					
				if(result == 113){
					break;
				}else if (result  == 10 || result == 13 || result  == 133 || result == 136) {
					continue;
				}else {
					System.out.println("키코드: " + result);	
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
}
