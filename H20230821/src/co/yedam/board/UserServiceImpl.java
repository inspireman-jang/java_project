package co.yedam.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
	// user.txt에서 정보를 읽고 User정보를 List컬랙션에 저장.
	// User 클래스 생성

	List<User> userList = new ArrayList<>();

	File file = new File("c:/temp/user.txt");

	public UserServiceImpl() {
		init();
	}

	@Override
	public boolean checkLogin(User user) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(user.getId()) &&
					userList.get(i).getPw().equals(user.getPw())) {
				return true;
			}
		}
		return false;
	}

	private void init() {
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			while (true) {
//				String str = br.readLine();
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		while (scn.hasNext()) {
			String line = scn.nextLine();

			String[] data = line.split(" ");
			try {
				userList.add(new User(data[0], data[1], data[2]));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String hellow(User user) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(user.getId()) &&
					userList.get(i).getPw().equals(user.getPw())) {
				return userList.get(i).getName();
			}
		}
		return null;
	}

}
