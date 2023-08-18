package co.yedam.api;

public class StringUtilsExe {
	public static void main(String[] args) {
		
		String file ="C:/Dev/temp/file/212121/플라워.jpg";
		
		String ssn = "881122  -    4610223";
		
		System.out.println(StringUtils.checkGender(ssn));
		
		System.out.println(StringUtils.getFileName(file));
	}
}
