package co.yedam.api;

class Member {
	private int memberId;
	private String memberName;

	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}	

	
	@Override
	public String toString() {
		return super.toString();
//		return "Member [memberId=" + memberId + ", memberName=" + memberName + "]";
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}

	@Override
	//Object 클래스의 equals()로 클래스의 값을 논리적으로 비교 할 수 있는 메소드
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		return super.equals(obj);

		Member target = (Member) obj;
		if (this.memberId == target.memberId 
				&& this.memberName.equals(target.memberName)
				) {
			return true;
		} else {
			return false;
		}

	}
}

public class EqualsExe {
	public static void main(String[] args) {
		// new 인스턴스는 주소 값을 넣게 된다
		String str1 = new String("Hong");
		String str2 = new String("Hong");

		System.out.println(str1 == str2);
		// String 비교 하려면 equals
		System.out.println(str1.equals(str2));

//		String str1 = "Hong";
//		String str2 = "Hong";

		System.out.println(str1 == str2);

		Member mem1 = new Member(101, "Hong");
		Member mem2 = new Member(101, "Hong");

		System.out.println("이거슨?? " + mem1.equals(mem2));
	}
}
