package co.yedam.exceptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThrowExe {
	public static void main(String[] args) {
		
		try {
			dbSearch();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dbSearch() throws ClassNotFoundException , SQLException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = conn.createStatement();
		ResultSet rs =  stmt.executeQuery("select * from employees");
		while (rs.next()) {
			System.out.println("사원번호: " + rs.getInt("employee_id")//
			+ " 이름: " + rs.getString("first_name"));
		}
	}
}
