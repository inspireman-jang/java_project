package co.yedam.board;

import java.util.List;

public interface ReplyService {
	
	//댓글 생성
	public boolean add(Reply comm);	
	
	//댓글 목록
	public List<Reply> list(int page, int brdNo);
	public int getTotal(int brdNo);
	
	//댓글 삭제
	public boolean remove(int brdNo);

	public boolean listCheck(int brdNo);
	
	// 종료 될때 파일 저장.
	public void save();
	
	// 글번호 - 작성자 반환
	public String getResponseUser(int brdNo);
}
