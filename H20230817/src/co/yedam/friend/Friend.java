package co.yedam.friend;

import java.util.Date;

public class Friend {
	
//	친구연락처 정보.
//	학교친구 -- 이름, 연락처, 학교, 전공
//	회사친구 -- 이름, 연락처, 회사이름, 부서
//	친구 -- 이름, 연락처
	
	private String name;
	private String phone;
	
	
	//생성자 메소드
	public Friend(String name, String phone, Date date) {
		this.name = name;
		this.phone = phone;
	}
		
	//getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String showInfo() {
		return "이름은 " + name + " 연락처는 " + phone;
	}
	
	@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
	
}
