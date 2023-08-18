package co.yedam.array;

public class ArrayExe2 {
	public static void main(String[] args) {
		
		int num1, num2, num3;
		num1 = 56;
		num2 = 72;
		num3 = 67;
		
		//큰값
		if(num1 > num2) {
			if(num1 > num3) {
				System.out.printf("가장 큰 값은 num1의 %d입니다.\n", num1);
			}else {
				System.out.printf("가장 큰 값은 num3의 %d입니다.\n", num3);
			}
		}else {
			if(num2 > num3) {
				System.out.printf("가장 큰 값은 num2의 %d입니다.\n", num2);
			}else {
				System.out.printf("가장 큰 값은 num3의 %d입니다.\n", num3);
			}
		}
		
		int max = Math.max(num1, num2);
		System.out.println(Math.max(max, num3));
		
		int[] arry = { num1, num2, num3 };
		
		
		
		//배열에서 가장 큰 값
		for(int i = 0; i < arry.length; i++) {
			max = 0;
			if (max < arry[i]) {
				max = arry[i];
			}
		}
		System.out.printf("가장 큰 값은 %d입니다.\n", max);
		
		int[] ary = new int[5];		
		
		int sum = 0;
		double avg = 0.0;
		
		for (int i = 0; i <= 4; i++) {
			int ran = (int) (Math.random()*100) + 1;
			ary[i] = ran;
			sum += ran;
		}
		
		avg = sum / ary.length;
		
		System.out.printf("합계는 %d이고, 평균은 %.2f입니다.", sum, avg);
		
		
		
		
		
	}
}
