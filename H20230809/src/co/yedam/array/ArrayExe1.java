package co.yedam.array;

public class ArrayExe1 {
	public static void main(String[] args) {
		
		//배열선언
		int[] intArr = null;  //null 로 초기화 선언 가능
		intArr = new int[10]; // 정수 10개짜리 배열 선언
		intArr = new int[] { 12, 25, 67, 23};
		
		int[] intArr2 = { 55, 47, 90};
		
		System.out.println(intArr[0]);
		intArr[0] = 22;
		
		intArr = intArr2;
		
		
		int sum = 0;
		sum += intArr[0];
		sum += intArr[1];
		sum += intArr[2];
		sum += intArr[3];
		
		for (int i = 0; i < 4 ; i++) {
			sum += intArr[i];			
		}
	}
}
