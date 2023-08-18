package co.yedam.interfaces;

public class MysqlDao implements Dao {
	// Add unimplemented methods 클릭
	
	@Override
	public void insert() {
		System.out.println("Mysql 생성기능");
		
	}

	@Override
	public void update() {
		System.out.println("Mysql 수정기능");
		
	}

	@Override
	public void delete() {
		System.out.println("Mysql 삭제기능");
		
	}

	@Override
	public void select() {
		System.out.println("Mysql 조회기능");
		
	}
	// Add unimplemented methods 클릭
}
