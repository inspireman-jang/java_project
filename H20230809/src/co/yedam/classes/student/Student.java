package co.yedam.classes.student;

public class Student {
	// 필드.
	// private 내부 클래스 에서 사용 가능
	private int stdNo;
	private String stdName;
	private int score;

	// 생성자. : 필드의 값 초기화.

	Student() {
		// 기본 생성자
	}

	Student(int stdNo, String stdName, int score /* 매개변수 */) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
	}

	// 메소드.
	void stdInfo() {
		System.out.println("학번:" + stdNo + ", 학생이름:" + stdName + ", 점수:" + score);
	}

	void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	void setStdName(String stdName) {
		this.stdName = stdName;
	}

	void setScore(int score) {
		if (score < 0) {
			this.score = 0;
		} else {
			this.score = score;
		}		
	}
	
	// getter  = 우측마우스 > Source > generate getter
	public int getStdNo() {
		return stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public int getScore() {
		return score;
	}
	
	
}
