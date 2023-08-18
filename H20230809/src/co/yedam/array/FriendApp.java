package co.yedam.array;

import java.util.Scanner;

public class FriendApp {
	
	static Friend[] friends = new Friend[10];
	static Scanner scn = new Scanner(System.in); //System.in은 키보드
	static String name ;
	static String phone ;
	static Gender gender;
	
	public static void init() {
		//초기값
		for(int i =0; i <5; i++) {
			Friend f = new Friend();
			f.name = "test" + i;
			f.phone = "010-2222-456"+ i;
			f.gender = Gender.MEN;
			
			friends[i] = f;
		}	
	}
	
	public static void add() {
		Boolean ex = true;
		
		for(int i =0; i < friends.length; i++) {
			if(friends[i] == null) {
				ex = false;
				break;
			}else {
				ex = true;
			}					
		}
		if(ex == true) {
			System.out.print("목록이 가득차서 추가할 수 없습니다.\n"
					+ "수정 및 삭제만 가능 합니다.\n");
		}
		
		System.out.print("이름>> ");
		name =  scn.nextLine();
		
		System.out.print("연락처>> ");
		phone = scn.nextLine();
		
		System.out.print("성별(1:남자,2:여자>> ");
		gender = null;
		
		int choice = Integer.parseInt(scn.nextLine());
		
		if (choice == 1) {
			gender = Gender.MEN;
		} else {
			gender = Gender.WOEMN;
		}
		
		Friend fnd = new Friend();
		fnd.name = name;
		fnd.phone = phone;
		fnd.gender = gender;
		
		for(int i =0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fnd;
				break;
			}
		}
		System.out.println("OK");
	}
	
	public static void edit() {
		System.out.print("이름>> ");
		name =  scn.nextLine();
		
		System.out.println(name);
		
		if(!checkFriend(name)) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		
		System.out.print("연락처>> ");
		phone = scn.nextLine();
		
		for(int i =0; i < friends.length; i++) {
			if(friends[i] != null) {
				if(friends[i].name.equals(name)) {
					friends[i].phone = phone;
					break;			
				}						
			}
		}
	}
	
	public static void del() {
		System.out.print("이름>> ");
		name =  scn.nextLine();
		
		for(int i =0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				friends[i] = null;
				return;
			}
		}
	}
	
	public static void search() {
		System.out.print("이름>> ");
		name =  scn.nextLine();				
		
		for(int i =0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(name)) {
				friends[i].showInfo(); // 클래스에 정의된 함수 호출
				return;
			}
		}
	}
	
	public static void list() {
		for(int i =0; i < friends.length; i++) {
			if(friends[i] != null) {						
				friends[i].friendInfo(); //클래스에 정의된 함수 호출
			}
		}
	}
	
	// boolean checkFriend(String name) {}
	
	public static boolean checkFriend(String name) {
		for(int i=0; i < friends.length; i++) {
			if(friends != null && friends[i].name.equals(name)) {
				return true;
			}	
		}
		return false;
	}

	
	
	public static void main(String[] args) {
		//추가, 수정, 삭제, 조회, 목록		
		init();
		
		boolean run = true;		
		

		
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.목록 6.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:	
				add(); break;
	
			case 2: 				
				edit(); break;
				
			case 3: 	
				del(); break;
				
			case 4: 
				search(); break;
	
			case 5: 
				list(); break;
				
			case 6:
				System.out.println("프로그램 종료");
				run = false;
				break;
				
			default: System.out.println("메뉴를 다시 선택 하세요.");
			}
		}
		System.out.println("end");
	}
}
