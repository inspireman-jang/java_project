package co.yedam.classes.student;

public class Calculator {
	double pi = 3.14;  //인스턴스 멤버

	//인스턴스 멤버
	public double sum(double n1, double n2) {
		return n1 + n2;
	}

	public double minus(double n1, double n2) {
		return n1 - n2;
	}
	
	//static은 클래스가 실행 될 때 메모리에 기본으로 생성되어 있음
	public static double multi(double n1, double n2) {
		return n1 * n2;
	}
}
