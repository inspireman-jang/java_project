package co.yedam.interfaces;

public interface Dao {
	// 규칙선언.
	// final = 값을 변경할 수 없음
	static final double pi = 3.14; // 상수 필드

	
	//abstract 를 붙이지 않아도 추상 메소드로 인식됨
	abstract void insert();
	void update();
	void delete();
	void select();
	
}
