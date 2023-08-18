package co.yedam.array;

import java.util.Scanner;

public class TodoApp {
//	static Todo[] todos = new Todo[100];
	static Scanner scn = new Scanner(System.in); // System.in은 키보드
	static int idx = 1;

	public static void TodoInsert(int num, String todo, String date) {

	}

	public static void TodoComplete() {

	}

	public static void TodoSearch() {

	}

	public static void TodoIncomplete() {

	}

	public static void main(String[] args) {
		// 등록/완료/조회(날짜)/미완료/

		// 등록 : 1번 할일 0812 미완료
		// 완료 : 1 2 4 엔터 치면 1 2 4번을 완료 상태로 변경
		// 조회(날짜) : 0812 입력하면 리스트 다 보여줘라
		// 미완료: done이 false인 녀석만 출력
		Todo[] todos = new Todo[100];
		boolean run = true;

		while (run) {

			System.out.println("----------------------------------------------");
			System.out.println("1.Todo 등록 | 2.Todo 완료 | 3.Todo 전체 조회 | 4.미완료 조회 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			if (selectNo == 1) {
				System.out.print("순번/할일/일자> ");
				String[] data = scn.nextLine().split(" ");

//				System.out.printf("data1:%s data2:%s data3:%s",data[0], data[1], data[2] );

				Todo d = new Todo();
				d.no = Integer.parseInt(data[0]);
				d.todo = data[1];
				d.dueDate = data[2];
				d.done = false;				


				for (int i = 0; i < todos.length; i++) {
					if (todos[i] == null) {
						todos[i] = d;
						break;
//						System.out.printf("scores[%d]> 이름:%s 점수:%d ",i,scores[i].name, scores[i].score);						
					}
				}
//				TodoInsert(Integer.parseInt(data[0]), data[1], data[2]);

			} else if (selectNo == 2) {
				System.out.print("완료한 번호 선택> ");
				String[] data = scn.nextLine().split(" ");				
				
				for (int i =0 ; i < data.length; i++) {
					if(todos[i] != null) {
						if(todos[i].no == Integer.parseInt(data[i])) {
							todos[i].done = true;
						}
					}
				}

			} else if (selectNo == 3) {
				// for()
				int lnth = 0;
				for (int i = 0; i < todos.length - 1; i++) {
					if (todos[i] != null) {
						lnth++;
					}
				}

				for (int i = 0; i < lnth - 1; i++) {
					if (todos[i] != null) {
						Todo tmp = new Todo();
						if (todos[i].no < todos[i + 1].no) {
							tmp = todos[i];
							todos[i] = todos[i + 1];
							todos[i + 1] = tmp;
						}
					}
				}
				
				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null) {
						System.out.printf("번호:%4d\t 할일:%s\n일자:%4s\t 상태:%s\n", todos[i].no, todos[i].todo,
								todos[i].dueDate, todos[i].done == false ? "미완료" : "완료");
					}
				}

			} else if (selectNo == 4) {

				for (int i = 0; i < todos.length; i++) {
					if (todos[i] != null) {
						System.out.printf("번호:%4d\t 할일:%s\n일자:%4s\t 상태:%s\n", todos[i].no, todos[i].todo,
								todos[i].dueDate, todos[i].done == false ? "미완료" : "완료");
					}
				}

			} else {
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		}

	}

	public static void sortSample() {
		int[] intAry = { 45, 23, 90, 77, 12 };

		int len = intAry.length - 1;
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < len; i++) {
				if (intAry[i] > intAry[i + 1]) {
					int tmp = intAry[i];
					intAry[i] = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = tmp;
				}
			}
		}
		System.out.println(intAry);

	}
}
