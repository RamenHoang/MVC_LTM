package model.BO;

import java.util.ArrayList;

import model.BEAN.Wife;
import model.DAO.CheckRegisterDAO;

public class CheckRegisterBO {
	public boolean register(String username, String password, String lastname) {
		return new CheckRegisterDAO().register(username, password, lastname);
	}
	
//	public ArrayList<Wife> getWifes() {
//		ArrayList<Wife> wifies = new ArrayList<Wife>();
//		new CheckRegisterDAO().getWifies(wifies);
//		return wifies;
//	}
}
