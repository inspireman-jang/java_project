package co.yedam.friend;

import java.util.InputMismatchException;
//컨트롤 + 쉬프트 + o (임포트 단축키)
import java.util.Scanner;

public class FriendApp {
	// 배열 > 컬랙션 > 파일 > DB에 저장하는 순서로 작업할 예정

	Friend1[] friends = new Friend1[10];
	Scanner scn = new Scanner(System.in);

	// 컨트롤
	public void start() {
		boolean run = true;
		int menu = -1;

		while (run) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택>> ");
			try {
				menu = scn.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요");
				continue;
			} finally {
				scn.nextLine();
			}

			switch (menu) {
			case 1:
				addFriend();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.println("종료");
				run = false;
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}

	}

	private String printString(String msg) {
		System.out.print(msg + " >>");
		return scn.nextLine();
	}

	// 등록
	private void addFriend() {

		int subMenu = -1;

		while (true) {
			System.out.println("1.학교 2.회사 3.기타");
			System.out.print("선택>> ");
			try {
				subMenu = scn.nextInt();

				if (subMenu < 1 || subMenu > 3) {
					System.out.println("1 2 3 중에 선택해 주세요.");
					continue;
				}
				break;

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				continue;
			} finally {
				scn.nextLine();

			}
		}

		Friend1 friend = null;

		String name = printString("이름입력");
		String phone = printString("연락처입력");

		if (subMenu == 1) {
			String univ = printString("학교입력");
			String major = printString("전공입력");

			friend = new UnivFriend(name, phone, univ, major);

		} else if (subMenu == 2) {
			String comp = printString("학교입력");
			String dept = printString("부서입력");

			friend = new CompFriend(name, phone, comp, dept);

		} else {
			friend = new Friend1(name, phone);
		}

		//
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
	}

	// 조회 : 이름이 일치할때는 해당하는 이름만 / 엔터만 입력되었을때는 전체 조회
	private void search() {
		boolean cnt = false;
		String name = printString("이름입력");

		if (name.equals("")) {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] != null) {
					System.out.println(friends[i].showInfo());
				}
			}
		} else {
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] != null) {
					if (friends[i].getName().equals(name)) {
						System.out.println(friends[i].showInfo());
						cnt = false;
						break;
					} else {
						cnt = true;
					}
				}
			}
			if (cnt == true) {
				System.out.println("해당 이름이 없습니다.");
			}

		}

	}

	// 수정 : 이름 기준으로 연락처를수정
	private void modify() {
		boolean cnt = false;
		String name = printString("이름입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (friends[i].getName().equals(name)) {
					String phone = printString("연락처입력");
					friends[i].setPhone(phone);
					cnt = false;
					break;
				} else {
					cnt = true;
				}
			}
		}
		if (cnt == true) {
			System.out.println("해당 이름이 없습니다.");
		}
	}

	// 삭제 : 이름을 기준으로 삭제
	private void remove() {
		boolean cnt = false;
		String name = printString("이름입력");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (friends[i].getName().equals(name)) {
					friends[i] = null;
					cnt = false;
					break;
				}
			} else {
				cnt = true;
			}
		}

		if (cnt == true) {
			System.out.println("해당 이름이 없습니다.");
		}
	}
}
