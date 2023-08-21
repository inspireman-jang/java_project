package co.yedam.generic;


// T: type parameter
// <T> 제네릭. 인스턴스 생성 시점에 데이터유형을 결정할 때 사용
public class Box<T> {
	T obj;
	
	T get() {
		return obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
}
