package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {
	// 추가, 수정, 삭제, 목록
	// 리스트 타입으로 Friend 인스턴스 생성을 할 것이다.
	// 변수 이름은 friends이다.
	List<Friend> friends = new ArrayList<Friend>();
	Map<String, String> userList = new HashMap<>();
	Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
	String name = "";
	String phone = "";
	Date dt;

	public FriendApp() {
		userList.put("user1", "1234");
		userList.put("user2", "2234");
		userList.put("user3", "3314");
	}

	private boolean userCheck() {
		System.out.print("id>> ");
		String id = scn.nextLine();

		if (userList.containsKey(id)) {
			System.out.print("pw>> ");
			String pw = scn.nextLine();
			if (userList.get(id).equals(pw)) {
				return true;
			} else {
				System.out.println("패스워드가 틀렸습니다.");
				return false;
			}
		} else {
			System.out.println("아이디가 없습니다.");
			return false;
		}

	}

	public void strat() {
		int menu = -1;
		boolean run = true;

		while (true) {
			if (userCheck()) {
				System.out.println("로그인 성공...");
				break;
			}
		}

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록");
			System.out.print("선택 >> ");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				del();
				break;
			case 4:
				list();
				break;
			default:
				System.out.println("메뉴를 선택 해 주세요.");
			}
		}
	}

	private void add() {

		System.out.print("이름입력>>");
		name = scn.nextLine();

		System.out.print("번호입력>>");
		phone = scn.nextLine();

		System.out.print("생년월일입력 (yymmdd)>>");
		try {
			dt = sdf.parse(scn.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		friends.add(new Friend(name, phone, dt));
	}

	private void edit() {
		if (friends.size() == 0) {
			System.out.println("친구 목록이 없습니다. 추가 해주세요.");
		} else {
			System.out.print("이름입력>>");
			name = scn.nextLine();

			for (int i = 0; i < friends.size(); i++) {
				if (friends.get(i).getName().equals(name)) {
					System.out.print("수정할 번호입력>>");
					phone = scn.nextLine();

					friends.get(i).setPhone(phone);

				}
			}
		}
	}

	private void del() {
		if (friends.size() == 0) {
			System.out.println("친구 목록이 없습니다. 추가 해주세요.");
		} else {
			System.out.print("이름입력>>");
			name = scn.nextLine();

			for (int i = 0; i < friends.size(); i++) {
				if (friends.get(i).getName().equals(name)) {
					friends.remove(i);
				}
			}
		}
	}

	private void list() {
		if (friends.size() == 0) {
			System.out.println("친구 목록이 없습니다. 추가 해주세요.");
		} else {
			for (Friend str : friends) {
				System.out.println(str.toString());
			}
		}
	}
}
