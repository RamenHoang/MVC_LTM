package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BO.UserBO;

@WebServlet("/SVCheckUpdate")
public class SVCheckUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String successPath = "/welcom.jsp";
	
	
    public SVCheckUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaSV = (String)request.getParameter("MaSV");
		String Hoten = (String)request.getParameter("Hoten");
		String Gioitinh = (String)request.getParameter("Gioitinh");
		String Khoa = (String)request.getParameter("Khoa");
		
		int role 		= request.getParameter("role") == null ? -1 : Integer.parseInt((String)request.getParameter("role"));

		UserBO bo = new UserBO();
		int res = bo.updateWife(MaSV, Hoten, Gioitinh, Khoa);
		request.setAttribute("result_mod", res);
		request.setAttribute("MaSV", MaSV);
		request.setAttribute("Hoten", Hoten);
		request.setAttribute("Gioitinh", Gioitinh);
		request.setAttribute("Khoa", Khoa);
		request.setAttribute("role", role);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(successPath);
		rd.forward(request, response);
		System.out.println("Search Success");
	}
}
