package co.yedam.variable;

public class VariableExe2 {
	
	int num = 100;
	
	public void showInfo() {
		int num = 100 + this.num;  //클래스 내에 있는 변수 사용시에는 this를 붙여줘야 함. 
		System.out.println("num: " + num);
//		int num1 = 200;  //로컬 변수는 선언된 실행 블럭안에서만 유효값
	}
	
	public void helloMsg() {
		int num = 200;
		System.out.println("num: " + num);
	}
}