package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BO.UserBO;

@WebServlet("/SVCheckDelete")
public class SVCheckDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String successPath = "/welcom.jsp";
	
	
    public SVCheckDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaSV = (String)request.getParameter("MaSV");
		UserBO bo = new UserBO();
		int res = bo.deleteWife(MaSV);
		
		request.setAttribute("result_del", res);
		request.setAttribute("MaSV", MaSV);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(successPath);
		rd.forward(request, response);
		System.out.println("Search Success");
	}
}
