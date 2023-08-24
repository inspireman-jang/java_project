package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScanExe {
	public static void main(String[] args) {
		File file = new File("src/co/yedam/friend/friends.txt");
		Scanner scn = null;
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		while (scn.hasNext()) {
//			String line = scn.next(); //공백 기준으로 읽기
//			System.out.println(line);
//		}

		List<Friend1> friends = new ArrayList<>();

		while (scn.hasNext()) {
//			try {
//				line = scn.nextLine();
//			} catch (NoSuchElementException e) {
//				break;
//			}

			 String line = scn.nextLine();

//			if (line.equals(" ")) {
//				break;
//			} else {

			String[] data = line.split(" ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				friends.add(new Friend1(data[0], data[1], sdf.parse(data[2])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		}

		for (Friend1 fnd : friends) {
			System.out.println(fnd.toString());
		}

	}
}
