package co.yedam.variable;

public class VariableExe1 {
	public static void main(String[] args) {
		int num1 = 10;
		String str = "홍길동";
		str = "김길동";
		
		// 홍길동, 20의 값을 담고 싶다.
		Person hong =  new Person();  //클래스를 hong 변수에 할당 받음
		hong.name = "홍길동";
		hong.age = 20;
		hong.weight = 67.8;
		
		hong = new Person();
		
		
		System.out.println("이름은 " + hong.name //
				+ ", 나이는 " + hong.age //
				+ ", 몸무게는 " + hong.weight);
		
		VariableExe2 exe2 = new VariableExe2();
		exe2.showInfo();
		exe2.helloMsg();
		
	}
}
