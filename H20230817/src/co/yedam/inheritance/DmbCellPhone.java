package co.yedam.inheritance;

public class DmbCellPhone extends CellPhone {
	private int channel;
	
	public void changeChannel(int channel) {
		this.channel = channel;
		
	}
	
	public void trunOnDmb() {
		System.out.println("DMB 폰을 켭니다.");
	}
	
	// 재정의 (overriding)
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
//		super.turnOn(); //부모를 가르킴
		System.out.println(getModel() + "의 전원을 켭니다.");
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
}
