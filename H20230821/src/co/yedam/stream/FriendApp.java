package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import co.yedam.friend.Friend1;

public class FriendApp {
	List<Friend1> friends = new ArrayList<>();
	Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
	JFileChooser jfc = new JFileChooser();
//	File file = new File("c:/Users/Main/git/java_project/H20230821/src/co/yedam/stream/friends.txt");
	File file = null;
	
	public FriendApp() {
		fileSelect();
		loadFile();
		
	}	
	
	private void fileSelect() {
		int returnVal = jfc.showOpenDialog(null);
		if(returnVal==0)
		{
			file = jfc.getSelectedFile();
			System.out.println("파일 열기를 선택했습니다.");
		}else
		{
			System.out.println("파일 열기를 취소하였습니다.");
		}
//		File file = new File("c:/temp/friendList.txt");
	}

	public void start() {

		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				add();
			} else if (menu == 2) {
				list();
			} else {
				System.out.println("종료합니다.");
				saveFile();
				run = false;
			}
		}
	}

	

	private void add() {
		String name = printString("이름입력");
		String phone = printString("연락처입력");
		String birth = printString("생일입력(950603");
		

		try {
			Friend1 fnd = new Friend1(name.strip(), phone, sdf.parse(birth));
			friends.add(fnd);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void list() {

		for (Friend1 fnd : friends) {
			System.out.println(fnd);
		}

	}

	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// friends 컬랙션에 값 -> 텍스트로 저장.
		try {
			FileWriter fw = new FileWriter(file);

			for (Friend1 fnd : friends) {
				String line = fnd.getName() + " " + fnd.getPhone() //
						+ " " + sdf.format(fnd.getBirth());
				fw.write(line + "\n");
			}
			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (scn.hasNext()) {
			String line = scn.nextLine();

			String[] data = line.split(" ");
			try {
				friends.add(new Friend1(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String printString(String msg) {
		System.out.print(msg + " >>");
		return scn.nextLine();
	}

}
