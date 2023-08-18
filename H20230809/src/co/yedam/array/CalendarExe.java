package co.yedam.array;

public class CalendarExe {
	public static void main(String[] args) {
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		//달력. 31까지
		int month = 2;
		
		
		
		for (int i=0; i < days.length; i++) {
			System.out.printf("%4s",days[i]);			
		}
		System.out.println();
		
		int space = getFristDay(month);
		
		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		for(int i=1; i<=getLastDate(month); i++) {
			System.out.printf("%4d",i);
			if( (i+space) % 7 == 0) {
				System.out.println();
				System.out.println();
			}
		}		
	}
	
	public static int getFristDay(int month) {
		int day = 0;
		int totalDays = 0;
	
		
		for(int i = 1; i <= month -1 ; i++) {
			totalDays += getLastDate(i);
		}
		
		day =  day +  (totalDays % 7);		

		return day;
		

	}
	
	public static int getLastDate(int month) {
		// 1-31, 2-28, 3-31, 4-30......

		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			return 28;
		default : return 31;
		}
	}
}
