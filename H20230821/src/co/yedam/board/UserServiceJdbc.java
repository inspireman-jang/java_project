package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceJdbc implements UserService{
	
	// Connection 객체.
	// PreparedStatement 객체.
	// ResultSet 객체.
	// String 쿼리.

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String query;
	
	void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if(psmt !=null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkLogin(User user) {
		// TODO Auto-generated method stub
		
		query = "select user_id, user_pw\r\n"
				+ "from users\r\n"
				+ "where user_id = ? \r\n"
				+ "and user_pw = ?";
		
		conn = Dao.conn(); // DB연결
		
		try {
			psmt = conn.prepareStatement(query);		
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {				
					return true;		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

		return false;
	}

	@Override
	public String hellow(User user) {
		// TODO Auto-generated method stub
		
		query = "select *\r\n"
				+ "from users\r\n"
				+ "where user_id = ?\r\n"
				+ "and user_pw = ?";
		
		conn = Dao.conn(); // DB연결
		
		try {
			psmt = conn.prepareStatement(query);		
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("user_nm");		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return null;
	}

}
