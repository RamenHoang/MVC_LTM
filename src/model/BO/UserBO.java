package model.BO;

import java.util.ArrayList;

import model.BEAN.Wife;
import model.DAO.UserDAO;

public class UserBO {
	public ArrayList<Wife> getWifes(String query) {
		ArrayList<Wife> wifies = new ArrayList<Wife>();
		new UserDAO().getWifies(wifies, query);
		return wifies;
	}
	
	public int updateWife(String MaSV, String Hoten, String Gioitinh, String Khoa) {
		int res = new UserDAO().updateWife(MaSV, Hoten, Gioitinh, Khoa);
		return res;
	}
	
	public int deleteWife(String MaSV) {
		int res = new UserDAO().deleteWife(MaSV);
		return res;
	}
	
	public int newWife(String MaSV, String Hoten, String Gioitinh, String Khoa) {
		int res = new UserDAO().newWife(MaSV, Hoten, Gioitinh, Khoa);
		return res;
	}
}
