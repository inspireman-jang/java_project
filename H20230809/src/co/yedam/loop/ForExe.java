package co.yedam.loop;

public class ForExe {
	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("숫자 %d\n", i);
		}
		
		
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.printf("합계는 %d 입니다.\n", sum);
		
		sum = 0;
		
		for(int i = 3; i <= 100; i += 3 ) {
			sum += i;
		}
		System.out.printf("1~100까지 3의 배수의 총합은 %d 입니다.\n", sum);		

		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {				
				if ((4 * x) + (5 * y) == 60) {					
					System.out.printf("(x=" + x + ", y="+ y + ")\n"); 
				}
			}
		}
		
	
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4 - i; j++) {				
				System.out.print(" ");
				}
			for(int k = 1; k <= i; k++){
				System.out.print("*");
		        }  		
			System.out.println();
			}	
		
	
	}
}


