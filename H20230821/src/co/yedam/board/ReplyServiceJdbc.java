package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReplyServiceJdbc implements ReplyService{
	
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
	public boolean add(Reply comm) {
		// TODO Auto-generated method stub		
		
		query = "insert into commboard (comm_no, brd_no, comm_content, comm_write)"
				+ "values ((select nvl(max(comm_no), 0) + 1 from commboard), ?, ?, ?) ";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, comm.getBrdNum());
			psmt.setString(2, comm.getCommContent());
			psmt.setString(3, comm.getCommWriter());

			int r = psmt.executeUpdate();
			if (r == 1) {
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
	public List<Reply> list(int page , int brdNo) {
		// TODO Auto-generated method stub
		
		List<Reply> list = new ArrayList<>();

		conn = Dao.conn(); // DB연결
//		query = "select * from board";
		query = "select * from (\r\n"
				+ "select rownum rn, a.* \r\n"
				+ "from (select * from commboard\r\n"
				+ "    order by comm_no) a\r\n"
				+ "where rownum <= (? *5)) b\r\n"
				+ "where b.rn > (? - 1 ) * 5";
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				// rs --> list로 전환
//				System.out.println(rs.getInt("brd_no"));
				if(rs.getInt("brd_no") == brdNo) {
					Reply comm = new Reply();
					comm.setCommNum(rs.getInt("comm_no"));
					comm.setBrdNum(rs.getInt("brd_no"));
					comm.setCommContent(rs.getString("comm_content"));
					comm.setCommWriter(rs.getString("comm_write"));
					comm.setCommWrDate(rs.getDate("comm_wr_date"));
					comm.setCommUpDate(rs.getDate("comm_up_date"));
					list.add(comm);
				}				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public int getTotal(int brdNo) {
		// TODO Auto-generated method stub
		query = "select count(*) as cnt from commboard where brd_no = "+ brdNo;
		conn = Dao.conn(); // DB연결
		
		try {
			psmt = conn.prepareStatement(query);				
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 1;
	}

	@Override
	public boolean remove(int brdNo) {
		// TODO Auto-generated method stub
		query = "delete from commboard where comm_no = " + brdNo;
		conn = Dao.conn();
		try {
			psmt = conn.prepareStatement(query);
			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	
	}
	
	public boolean listCheck(int brdNo) {
		query = "select brd_no from board where brd_no = ?";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery(); //select
			if (rs.next()) {
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
	public String getResponseUser(int brdNo) {
		// TODO Auto-generated method stub
		query = "select comm_write from commboard where brd_no = ?";
		conn = Dao.conn();
		
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery(); //select
			if (rs.next()) {
				return rs.getString("comm_write");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	

}
