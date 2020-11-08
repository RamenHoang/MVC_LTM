package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Wife;
import model.BO.CheckRegisterBO;
import model.BO.UserBO;
import model.DAO.UserDAO;

/**
 * Servlet implementation class SVSearch
 */
@WebServlet("/SVSearch")
public class SVSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private final String successPath = "/welcom.jsp";
    
    public SVSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strQuery = request.getParameter("falcuty");
		
		UserBO bo = new UserBO();
		ArrayList<Wife> wifies = new ArrayList<Wife>();
		
		wifies = bo.getWifes(strQuery);
		
		if (wifies.size() == 0) 
			request.setAttribute("new", "new");
		HttpSession ss = request.getSession();
		ss.setAttribute("users", wifies);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(successPath);
		rd.forward(request, response);
		System.out.println("Search Success");
	}

}
