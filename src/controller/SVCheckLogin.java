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
import model.BO.CheckLoginBO;


@WebServlet("/SVCheckLogin")
public class SVCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String LOGIN = "username";
    private final String PASS = "password";
    private final String successPath = "/welcom.jsp";
    private final String failurePath = "/again.jsp";
    
    public SVCheckLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(LOGIN);
		String password = request.getParameter(PASS);
		
		HttpSession session = request.getSession();
		
		CheckLoginBO bo = new CheckLoginBO();
		
		if (bo.isValidUser(username, password, session)) {
			request.setAttribute("new", "new");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(successPath);
			rd.forward(request, response);
			System.out.println("Login Success");
			return;
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(failurePath);
		rd.forward(request, response);
		System.out.println("Login Failed");
	}

}
