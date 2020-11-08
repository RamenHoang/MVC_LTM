package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.BEAN.Wife;

public class UserDAO {
	private final String URL = "jdbc:mysql://localhost:3306/db01";
	private final String username = "ramen";
	private final String password = "ramen1999";
	
	public boolean getWifies(ArrayList<Wife> wifies, String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
			if (conn != null) {
				System.out.println("Get");
				
				Statement stm = conn.createStatement();
				String squery = "select * from _user where Khoa='" + query + "'";
				ResultSet rs = stm.executeQuery(squery);
				while (rs.next()) {
					System.out.println("Get user");
					wifies.add(new Wife(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4)));
					
				}
				conn.close();
				return true;
			}
			
			conn.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public int updateWife(String MaSV, String Hoten, String Gioitinh, String Khoa) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
			if (conn != null) {
				System.out.println("Update");
				
				Statement stm = conn.createStatement();
				String squery = "update _user set Hoten=" + "'" + Hoten + "', Gioitinh='" + Gioitinh + "', Khoa='" + Khoa + "' where MaSV=" + Integer.parseInt(MaSV) + "";
				int rs = stm.executeUpdate(squery);
				
				conn.close();
				return rs;
			}
			
			conn.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteWife(String MaSV) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
			if (conn != null) {
				System.out.println("Delete");
				
				Statement stm = conn.createStatement();
				String squery = "delete from _user where MaSV=" + Integer.parseInt(MaSV) + "";
				int rs = stm.executeUpdate(squery);
				
				conn.close();
				return rs;
			}
			
			conn.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int newWife(String MaSV, String Hoten, String Gioitinh, String Khoa) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(this.URL, this.username, this.password);
			if (conn != null) {
				System.out.println("Delete");
				
				Statement stm = conn.createStatement();
				String squery = "insert into _user (MaSV, Hoten, Gioitinh, Khoa) values (" + MaSV + ",'" + Hoten + "','" + Gioitinh + "', '" + Khoa + "')";
				int rs = stm.executeUpdate(squery);
				
				conn.close();
				return rs;
			}
			
			conn.close();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
