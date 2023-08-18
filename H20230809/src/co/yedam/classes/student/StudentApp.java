package co.yedam.classes.student;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10]; //클래스 배열 생성		
		Student s1 = new Student();			  //클래스 인스턴스 생성
		s1.setStdNo(100);
		s1.setStdName("호앙웅");
		s1.setScore(250);
		students[0] = s1;
		
		students[1] = new Student(101, "김길동", 80);
		students[2] = new Student(102, "남길동", 82);
		students[3] = new Student(103, "주길동", 87);
		
		
		String searchName = "김길동";
		
		for(int i=0; i < students.length; i++) {
			if(students[i] != null && 
					students[i].getStdName().equals(searchName)) {
				System.out.println(students[i].getStdNo()+" 이고 " + students[i].getScore());				
			}
		}
		
//		System.out.println(students[0]);
	}
}
