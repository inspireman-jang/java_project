package co.yedam.array;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		//클래스를 활용하여 변수 선언 방법
		Student[] students = new Student[3];
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;		
		
		Student s2 = new Student();
		s2.name = "강감찬";
		s2.score = 88;		
		
		Student s3 = new Student();
		s3.name = "연개소문";
		s3.score = 81;
		
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		int max = 0;
		int idx = 0;
		
		for(int i = 0; i < students.length; i++ ) {			
			if (max < students[i].score) {
//				max = students[i].score;
				idx = i;
			}			
		}
		
		
		
		System.out.print(students[idx].name + students[idx].score + "\n");
		
		
		
		
		String[] names = {"홍길동", "강감찬", "연개소문", "메신저"};
		int[] scores = {85, 88, 100, 75};
		
		max = 0;
		idx = 0;
		
		for(int i = 0; i < scores.length; i++ ) {			
			if (max < scores[i]) {
				max = scores[i];
				idx = i;
			}			
		}
		
		System.out.printf("가장 높은 점수를 가진 사람은 %d점인, %s입니다.", max, names[idx]);
		
	}
}
