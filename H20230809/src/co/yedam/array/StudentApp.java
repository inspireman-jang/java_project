package co.yedam.array;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		
		
		//초기값
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.score = 85;
		s1.height =178.9;
		s1.gender = Gender.MEN;
		
		Student s2 = new Student();
		s2.name = "남길순";
		s2.score = 85;
		s2.height =178.9;
		s2.gender = Gender.WOEMN;
		
		Student s3 = new Student();
		s3.name = "김길남";
		s3.score = 85;
		s3.height =178.9;
		s3.gender = Gender.MEN;

		
		Scanner scn = new Scanner(System.in); //System.in은 키보드
		boolean run = true;
		//1.등록(학생 이름, 점수 등록) 
		//2.조회(학생 이름 입력 시 점수 출력) 
		//3.목록 (학생 전체 목록 출력)
		//4.키가 제일 큰 학생의 이름 출력
		//5. 종료

		int idx = 0;
		
		while (run) {
			System.out.println("1.등록 2.조회 3.목록 4.키큰학생 5.종료");
			System.out.print("선택하세요>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
				case 1 : 
		
						Student s = new Student();
						
						System.out.print("이름 입력>> ");
						s.name =  scn.nextLine();
						
						System.out.print("점수 입력>> ");
						s.score = Integer.parseInt(scn.nextLine());
						
						System.out.print("키를 입력>> ");
						s.height = Double.parseDouble(scn.nextLine());
						
						students[idx] = s;
						idx++;
								
						break;
			
				case 2 :					
					
					if(students[0] == null) {
						System.out.println("조회가능한 목록이 없습니다.");						
					} else {
						String name = "";
						System.out.print("이름 입력>> ");
						name =  scn.nextLine();
						
						boolean isExist = false;
						
						for(int i = 0; i < students.length; i++) {	
							if(students[i] != null) {
								if(students[i].name.equals(name)) {
									System.out.printf("이름: %s 점수: %d 키: %.1f입니다.\n",
											students[i].name, students[i].score, students[i].height);
									isExist = true;
								}
							}
						}
						if (!isExist) {								
							System.out.printf("%s의 이름은 목록에 없습니다.\n", name);						
						}
					}					
					break;				
					
				case 3 :
					if(students[0] == null) {
						System.out.println("조회가능한 목록이 없습니다.");				
					}
					else {
						for(int i = 0; i < students.length; i++) {	
							if(students[i] != null &&  
									students[i].gender == Gender.MEN) {
								System.out.printf("%d번의 이름: %s 점수는 %d점입니다.\n",
										i+1,students[i].name, students[i].score);
							}														
						}				
					}
					break;
			
				case 4:
					double height = 0.0;
					int idx1 = 0;
					
					if(students[0] == null) {
						System.out.println("조회가능한 목록이 없습니다.");				
					}else {						
						for(int i = 0; i < students.length; i++) {	
							if(students[i] != null) {
								if (students[i].height > height) {
									height = students[i].height;
									idx1 = i;
								}							
							}				
						}
						System.out.printf("키가 제일 큰 학생의 이름: %s 입니다.\n",
								students[idx1].name);
					}					
					break;
				case 5: System.out.println("프로그램을 종료합니다.");
						run = false;
						break;
					
				default : System.out.println("1~4번을 입력해주세요.");
						  
			}
		}
		
	
		
	}
}
