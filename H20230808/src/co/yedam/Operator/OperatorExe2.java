package co.yedam.Operator;

import java.util.Scanner;

/*
 * 은행 App.
 */

public class OperatorExe2 {
	public static void main(String[] args) {
		
		try (Scanner scn = new Scanner(System.in)) {
			int balance = 0;  // 0원 이상 10만원 미만, 
			
			boolean run = true;
			
			while(run) {
				
				System.out.println("1.예금 2.출금 3.잔고 4.종료");
				System.out.print("선택>> ");
				
				int menu = Integer.parseInt(scn.nextLine());
				if(menu == 1) {
					System.out.print("입금액 입력 >> ");
					int inNum = Integer.parseInt(scn.nextLine());
					if( balance + inNum > 100000) {
						System.out.printf("(잔액 + 입금) 금액이 10만원을 초과합니다. \n입금 가능 금액 %d \n", 100000 - balance);
						continue;
					}else if(inNum > 100000){
						System.out.println("10만원이상 입금 할수 없습니다.");
						continue;
					}
					else if(inNum < 0){
						System.out.printf("마이너스 값을 입력 했습니다.\n");
						continue;
					}
					else {
						balance += inNum;
						System.out.printf("입금액: %d원입니다.\n통장 잔액은 %d원입니다.\n", inNum, balance);					
						continue;
					}
				}else if(menu == 2) {
					System.out.print("출금액 입력 >> ");
					int outNum = Integer.parseInt(scn.nextLine());
					
					if(balance == 0){
						System.out.printf("출금 가능 잔액이 0원입니다.\n");
						continue;
					}
					
					if(balance - outNum < 0){
						System.out.printf("출금가능한 잔액이 입력한 금액보다 적습니다.\n출금 가능 금액 %d \n", balance);
						continue;
					}else if(outNum < 0){
						System.out.printf("마이너스 값을 입력했습니다.\n");
						continue;
					}else {
						balance -= outNum;
						System.out.printf("출금액: %d원입니다.\n통장 잔액은 %d원입니다.\n", outNum, balance);					
						continue;
					}
				}else if(menu == 3) {
					System.out.printf("현재 계좌 잔액은 %d원입니다.\n", balance);
					continue;
				}else if(menu == 4) {
					System.out.printf("프로그램을 종료합니다.\n");
					break;
				}else {
					System.out.printf("1~4에 해당 값을 입력 해 주세요.\n");
					continue;
				}			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
