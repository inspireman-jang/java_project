package co.yedam.classes.friend;

import java.util.Date;

public class Friend extends Object {
	private String name;
	private String phone;
	private Date birth;

	public Friend(String name, String phone, Date birth) {
		super(); // 부모가 가지고 있는 생성자를 호출하겠다.
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
		return "Friend [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}

}
