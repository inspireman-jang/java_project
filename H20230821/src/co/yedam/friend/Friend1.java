package co.yedam.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend1 {
	private String name;
	private String phone;
	private Date birth;

	public Friend1(String name, String phone, Date birth) {
		super();
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdfPrint = new SimpleDateFormat("yyyy-MM-dd");
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" +sdfPrint.format(birth) + "]";
	}
	
	
}
