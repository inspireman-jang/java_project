package co.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		// cell이라는 변수에 CellPhone 인스턴스 생성
		CellPhone cell = new CellPhone();
		cell.setModel("SM1100");
		cell.setColor("black");
		cell.turnOn();
		cell.turnOff();
		
		System.out.printf("모델 : %s\n"
				+ "색상 : %s\n", cell.getModel(), cell.getColor());

		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("DMB1100");
		dmb.setColor("white");
		dmb.turnOn();
		dmb.trunOnDmb();
		dmb.turnOff();

		CellPhone cell2 = new DmbCellPhone(); // promotion
		cell2.setModel("!!1200");
		cell2.turnOn();
		System.out.println("asdasdf");
		// cell2.turnOnDmb(); 사용불가

		if (cell instanceof DmbCellPhone) {
			DmbCellPhone dmb2 = (DmbCellPhone) cell2; // casting (형전환)으로 가능
			dmb2.trunOnDmb();
		}

		if (cell instanceof DmbCellPhone) {
			DmbCellPhone dmb3 = (DmbCellPhone) cell;
			dmb3.trunOnDmb();
		}
		
		CellPhone[] phones = new CellPhone[5];
		phones[0] = cell;
		phones[1] = dmb; 

		phones[0].turnOn();  // CellPhone 인스턴스
		phones[1].turnOn();  // DmbCellPhone 인스턴스

	}
}
