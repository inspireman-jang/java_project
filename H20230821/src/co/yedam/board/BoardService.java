package co.yedam.board;

import java.util.List;

// 파일저장, DB저장.
public interface BoardService {
	// 등록 (추가) Create
	
	public boolean add(Board board); 
	
	// 목록 보기 Read	
	public List<Board> list(int page);
	public int getTotal();
	
	// 수정(글내용만 수정) Update
	
	public boolean modify(Board board);
	
	// 삭제 Delete
	
	public boolean remove(int brdNo);
	
	// 상세조회
	
	public Board search(int brdNo);
	
	// 종료 될때 파일 저장.
	public void save();
}
