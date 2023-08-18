package co.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringMethod {
	public static void main(String[] args) {
		String ssn = "010624-2230123";
		char sex = ssn.charAt(7); // 7번째 위치의 문자를 리턴해준다.

		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}

		// 비교연산자와 equals의 차이
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";

		if (strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}

		if (strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}

		// getBytes() 바이트 배열로 변환

		System.out.println("============getBytes() 바이트 배열로 변환=======");
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println("bytes.length: " + bytes1.length);// bytes.length: 16

		String str1 = new String(bytes1);
		System.out.println("bytes -> String: " + str1); // bytes -> String: 안녕하세요.

		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);

			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes -> String: " + str2);

			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);

			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes -> String: " + str3);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// indexOf 문자열 포함여부 조사

		System.out.println("============indexOf() 문자열 포함여부 조사=======");

		String subject = "자바 프로그래밍";

		int location = subject.indexOf("프로그래밍");
		System.out.println(location);

		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}

		// length() 문자열 길이
		System.out.println("============length() 문자열 길이=======");

		String ssn1 = "7306241230123";
		int length = ssn1.length();
		if (length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}

		// replace() 문자열 대치
		System.out.println("============replace() 문자열 대치=======");

		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);

		// subString() 문자열 잘라내기
		System.out.println("============subString() 문자열 잘라내기=======");

		String ssn2 = "880815-1234567";

		String firstNum = ssn2.substring(0, 6); // 0 ~ 6까지
		System.out.println(firstNum);

		String secondNum = ssn2.substring(7); // 7부터 끝까지
		System.out.println(secondNum);
		
		// toLowerCase(), toUpperCase() 소문자 대문자 변경
		System.out.println("============toLowerCase(), toUpperCase() 소문자 대문자 변경=======");
		
		String str5 ="Java Programming";
		String str6 ="JAVA Programming";
		
		System.out.println(str5.equals(str6));
		
		String lowerStr1 = str5.toLowerCase();
		String lowerStr2 = str6.toLowerCase();
		
		System.out.println(lowerStr1.equals(lowerStr2));
		
	}
}
