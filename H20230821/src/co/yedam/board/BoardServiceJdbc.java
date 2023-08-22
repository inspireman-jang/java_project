package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService {
	
	// Connection 객체.
	// PreparedStatement 객체.
	// ResultSet 객체.
	// String 쿼리.
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	
	@Override
	public boolean add(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Board> list(int page) {
		// TODO Auto-generated method stub
		
		List<Board> list = new ArrayList<>();
		
		conn = Dao.conn(); //DB연결
		query = "select * from board";
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				// rs --> list로 전환
//				System.out.println(rs.getInt("brd_no"));
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));				
				board.setBrdContent(rs.getString("brd_content"));	
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				list.add(board);				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean modify(Board board) {
		// TODO Auto-generated method stub
		conn = Dao.conn(); //DB연결
		query = "update board set brd_content = " + board.getBrdContent()  +" where brd_no = "+ board.getBrdNo();
		
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		// TODO Auto-generated method stub
		query = "delete from board where brd_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board search(int brdNo) {
		// TODO Auto-generated method stub	
		query = "select * from board where brd_no = " + brdNo;
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery(); //select
			if(rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));				
				board.setBrdContent(rs.getString("brd_content"));	
				board.setBrdWriter(rs.getString("brd_writer"));
				board.setWriteDate(rs.getDate("write_date"));
				board.setUpdateDate(rs.getDate("update_date"));
				
				return board;
			}

		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
