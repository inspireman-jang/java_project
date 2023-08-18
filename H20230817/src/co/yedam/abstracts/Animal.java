package co.yedam.abstracts;

//추상 메소드
public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// 추상 메소드. 구현부분이 없는..
	// 하위클래스는 반드시 재정의해서 실행 내용을 채워야함
	public abstract void sound();
}
