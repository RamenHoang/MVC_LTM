package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.BEAN.Wife;

public class CheckLoginDAO {
	private final String URL = "jdbc:mysql://localhost:3306/db01";
	private final String username = "ramen";
	private final String password = "ramen1999";
	
	
	public boolean isExistUser(String login, String pass, HttpSession ss) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
			if (conn != null) {
				System.out.println("Connected db");
				
				Statement stm = conn.createStatement();
				String query = "select * from thi_user where username='" + login +"' and password='" + pass + "'";
				ResultSet rs = stm.executeQuery(query);
				if (rs.next()) {
					ss.setAttribute("username", rs.getString(2));
					ss.setAttribute("role", rs.getInt(5));
					conn.close();
					return true;
				}
			}
			
			conn.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
//	public void getWifies(ArrayList<Wife> wifies) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
//			if (conn != null) {
//				System.out.println("Get user");
//				
//				Statement stm = conn.createStatement();
//				String query = "select * from thi_user";
//				ResultSet rs = stm.executeQuery(query);
//				while (rs.next()) {
//					wifies.add(new Wife(rs.getString(2), rs.getString(4), rs.getInt(5)));
//				}
//			}
//			
//			conn.close();
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
