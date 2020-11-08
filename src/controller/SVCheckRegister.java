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
import model.BO.CheckRegisterBO;

@WebServlet("/SVCheckRegister")
public class SVCheckRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String LOGIN = "username";
    private final String PASS = "password";
    private final String LAST = "lastname";
    private final String ROLE = "role";
    private final String successPath = "/welcom.jsp";
    private final String failurePath = "/register.jsp";
    
    public SVCheckRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter(LOGIN);
			String password = request.getParameter(PASS);
			String lastname = request.getParameter(LAST);
			
			CheckRegisterBO bo = new CheckRegisterBO();
//			ArrayList<Wife> wifies = new ArrayList<Wife>();
			
			if (bo.register(username, password, lastname)) {
//				wifies = bo.getWifes();
//				request.setAttribute("users", wifies);
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("role", 3);
				RequestDispatcher rd = getServletContext().getRequestDispatcher(successPath);
				rd.forward(request, response);
				System.out.println("Register Success");
				return;
			}
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher(failurePath);
			rd.forward(request, response);
			System.out.println("Login Failed");
		} catch(Exception e) {
			
		}
	}

}
