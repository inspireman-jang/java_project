package co.yedam.condition;

public class ConditionExe {
	public static void main(String[] args) {
		// 임의의 수
		int random = (int) (Math.random() * 3) + 1;
		
		if(random == 1) {
			System.out.printf("%d는 가위입니다.", random);
		}else if(random == 2) {
			System.out.printf("%d는 바위입니다.", random);
		}else {
			System.out.printf("%d는 보입니다.", random);
		}
		
		switch (random) {
			case 1 : System.out.printf("switch %d는 가위입니다.", random);
			break;
			case 2 : System.out.printf("switch %d는 바위입니다.", random);
			break;
			default : System.out.printf("switch %d는 보입니다.", random);
		}
		
		
		int num = 97;
		char chr = 65;
		System.out.println(chr);
		
		System.out.println("어떤 혜택을 원하세요?");
		char grade = (char) ((Math.random() * 4) + 65) ;
		
		System.out.println(grade);
		
		switch(grade) {
		case 'A' : System.out.println("VVIP혜택을 받으실 수 있습니다."); break;
		case 'B' : System.out.println("VIP혜택을 받으실 수 있습니다."); break;
		case 'C' : System.out.println("우수 회원 혜택을 받으실 수 있습니다."); break;
		case 'D' : System.out.println("일반 회원 혜택을 받으실 수 있습니다."); break;
		default : System.out.println("혜택이 없습니다."); 
		}
		
		System.out.println("감사합니다.");
		
	}
}
