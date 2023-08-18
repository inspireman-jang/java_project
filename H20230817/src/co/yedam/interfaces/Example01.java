package co.yedam.interfaces;


//2차원배열의 해당 인덱스에 1씩 증가하는 값을 넣어라.

public class Example01 {
	public static void main(String[] args) {
		int[][] intAry = new int[5][5]; // intAry[0]의 값은 정수값

		//가로로 증감후 행바꿔서 값 입력하기
		int no = 1;
		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry.length; j++) {
				intAry[i][j] = no++;
			}
		}

		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry.length; j++) {
				System.out.print(intAry[i][j] + "\t");
//				System.out.printf("intAry[%d][%d] = %d" ,i, j, intAry[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();

		
		//세로로 증감후 열바꿔서 값 입력하기
		no = 1;
		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry.length; j++) {
				intAry[j][i] = no++;
			}
		}

		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry.length; j++) {
				System.out.print(intAry[i][j] + "\t");
//				System.out.printf("intAry[%d][%d] = %d" ,i, j, intAry[i][j]);
			}
			System.out.println();
		}
	}
}
