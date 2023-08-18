package co.yedam.loop;

public class WhileExe {
	public static void main(String[] args) {
		
//		boolean run = true;
//		while (run) {
//			int tmp =  (int) (Math.random() * 100);
//			
//			if(tmp > 90) {
//				// break;
//				run = false;
//			}
//			System.out.println(tmp);
//		}
//		System.out.println("end");
//		
		
		while (true) {
			int nun1 = (int) (Math.random()*4) + 1;
			int nun2 = (int) (Math.random()*4) + 1;
			
			int sum = nun1 + nun2;
			
			System.out.printf("nun1은 %d, nun2는 %d\n", nun1, nun2);
			
			if(sum == 5) {
				System.out.println("end");
				break;
			}
		}
	}
}
