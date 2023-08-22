package co.yedam.board;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	
	static Connection conn;

	// 오라클 DB에 접속
	static Connection conn() {
				try {					
					Class.forName("oracle.jdbc.OracleDriver");
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "proj", "proj");					
				}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return conn;
		}
	
	
}