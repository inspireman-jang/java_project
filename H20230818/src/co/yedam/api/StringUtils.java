package co.yedam.api;

public class StringUtils {
	static String checkGender(String ssn) {
		// 주민번호 구분해서 남자, 여자, 오류 케이스 판별
		
		String result = "";
		String ssnCheck = ssn.strip().replaceAll("[^0-9]", "");
		
//		System.out.println(ssn);
//		System.out.println(ssnCheck);		
//		System.out.println(sex);

		if (ssnCheck.length() == 13) {
			
			char sex = ssnCheck.charAt(6); // 6번 인덱스의 문자를 리턴해준다.

			switch (sex) {
			case '1':
			case '3':
				return result = "남자입니다.";
			case '2':
			case '4':
				return result = "여자입니다.";
			default:
				return result = "주민번호 숫자가 1~4를 벗어납니다.";
			}
		} else {
			return result = "주민번호 자리수가 틀립니다.";
		}	
	}

	static String getFileName(String filePath) {
		// 전체경로에서 파일명만 추출
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}
}
