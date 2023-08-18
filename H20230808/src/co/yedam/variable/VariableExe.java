package co.yedam.variable;

public class VariableExe {
	public static void main(String[] args) {
		//변수 선언
		//정수형 변수의 유형 : byte, short, int , long
		//byte : -128 ~ 127
		//short : -32768 ~ 32767
		//int : -2147483648 ~ -2147483647 
		int num1 = 1;  //초기화
		int num2  = 2147483647;  // 연산결과가 넘어서면 - 부호 붙여서 더해진다.
		
		num1 = 10;
		num2 = 20;
		
		int result = num1 + num2;
		
		System.out.println("result: " +  result);
		
		byte b1 = 10;
		byte b2 = 20;
		
		//왼쪽과 오른쪽의 타입이 일치 해야 됨
		int b3 = b1 + b2; //Type mismatch: cannot convert from int to byte (연산이 되면 int로 바뀐다.)
		
		int i1  = 100;
		byte b4 = 10;
		
		b3 = i1 + (int) b4; // 자동형번환해서 연산 됨
		
		//실수타입
		// float, double
		// 기본 값은 double
		double dbl1 = 10.1;
		double dbl2 = 10.001;
		
		double dbl3 = dbl1 + dbl2;
		System.out.println("dbl3: " + dbl3);
		
		float f1 = 10.1F;  //float으로 선언할 때는 숫자뒤에 F, f를 붙여줘야 함
		float f2 = 10.001f;
		float f3 = f1 + f2;
		System.out.println("f3: " + f3);
	}
}
