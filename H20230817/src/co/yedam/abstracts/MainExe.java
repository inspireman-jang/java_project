package co.yedam.abstracts;

public class MainExe {
	public static void main(String[] args) {
		// 추상클래스는 인스턴스를 생성할 수 없다.
		// Animal animal = new Animal(); X
		Animal animal = new Dog("멍멍이");
		animal.sound();

		animal = new Cat("야옹이");
		animal.sound();
	}
}
