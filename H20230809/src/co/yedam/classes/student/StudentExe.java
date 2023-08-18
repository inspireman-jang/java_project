package co.yedam.classes.student;

public class StudentExe {
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setStdNo(100);		
		s1.setStdName("홍길동");
		s1.setScore (-80);
		s1.stdInfo();
		
		Student s2 = new Student(101, "Hwang", 25);
		s2.stdInfo();
		
		System.out.println(s1.getStdName());
	}
}
