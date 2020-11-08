package model.BO;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.BEAN.Wife;
import model.DAO.CheckLoginDAO;

public class CheckLoginBO {
	public boolean isValidUser(String username, String password, HttpSession ss) {
		return new CheckLoginDAO().isExistUser(username, password, ss);
	}
	
//	public ArrayList<Wife> getWifes() {
//		ArrayList<Wife> wifies = new ArrayList<Wife>();
//		new CheckLoginDAO().getWifies(wifies);
//		return wifies;
//	}
}
