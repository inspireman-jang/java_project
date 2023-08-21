package co.yedam.generic;

public class Member {
	private int memberId;
	private String memeberName;
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memeberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemeberName() {
		return memeberName;
	}

	public void setMemeberName(String memeberName) {
		this.memeberName = memeberName;
	}
	
	
}
