package co.yedam.board;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Reply {
	private int commNum;
	private int brdNum;
	private String commContent;
	private String commWriter;
	private Date commWrDate;
	private Date commUpDate;
	
	

	public Date getCommWrDate() {
		return commWrDate;
	}

	public void setCommWrDate(Date date) {
		this.commWrDate = date;
	}

	public Date getCommUpDate() {
		return commUpDate;
	}

	public void setCommUpDate(Date commUpDate) {
		this.commUpDate = commUpDate;
	}

	private SimpleDateFormat sdf = new SimpleDateFormat("MM월dd일 HH시mm분");
	
	public Reply() {
		
	}
	
	public Reply(int commNum, int brdNum, String commContent, String commWriter) {
		super();
		this.commNum = commNum;
		this.brdNum = brdNum;
		this.commContent = commContent;
		this.commWriter = commWriter;
	}
	
	public Reply(int brdNum, String commContent, String commWriter) {
		super();
		this.brdNum = brdNum;
		this.commContent = commContent;
		this.commWriter = commWriter;
	}

	public int getCommNum() {
		return commNum;
	}

	public void setCommNum(int commNum) {
		this.commNum = commNum;
	}

	public int getBrdNum() {
		return brdNum;
	}

	public void setBrdNum(int brdNum) {
		this.brdNum = brdNum;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public String getCommWriter() {
		return commWriter;
	}

	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}
	
	public String listInfo() {
		return "--------------------------"
				+"번호: " + commNum + "\n"
				+"댓글내용: " + commContent + "\n"
				+"글쓴이: "+ commWriter + "\n"
				+"작성일자: " + sdf.format(commWrDate);
	}
}
