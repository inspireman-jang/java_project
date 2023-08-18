package co.yedam.array;

import java.util.Scanner;

class Member{
	String name;
	int score;
}

public class ScroeApp {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum =0;
//		int[] scores = null;
		
		Scanner scanner = new Scanner(System.in);	
		Member[] scores = new Member[studentNum];
		
		
		
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.이름 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {				
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
//				scores = new int[studentNum];
				
				//타입[] 변수 = new 타입[길이];
				scores = new Member[studentNum];
								
			} else if(selectNo == 2) {
				String[] data = scanner.nextLine().split(" ");
				
				Member s = new Member();
				s.name = data[0];
				s.score = Integer.parseInt(data[1]);
				
				for(int i=0; i < scores.length; i++) {
					if(scores != null) {
						scores[i] = s;	
						System.out.printf("scores[%d]> 이름:%s 점수:%d ",i,scores[i].name, scores[i].score);						
					}
				}				
				
			} else if(selectNo == 3) {
				for(int i=0; i < scores.length; i++) {
					if(scores != null) {
						System.out.printf("scores[%d]>이름:%s, 점수:%d\n",i,scores[i].name, scores[i].score);			
					}
				}
			} else if(selectNo == 4) {
				int max = 0;
				int sum = 0;
				double avg = 0.0;
				
				for(int i=0; i < scores.length; i++) {
					if(scores != null) {
						if (scores[i].score > max) {
							max = scores[i].score;		
						}
						sum += scores[i].score;					
					}
				}
				avg = sum / scores.length;
				
				System.out.printf("최고 점수: %d \n평균 점수%f\n",max , avg);	
				
			} else if(selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
