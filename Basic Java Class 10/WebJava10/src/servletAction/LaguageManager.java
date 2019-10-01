package servletAction;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.ResourceReader;

/**
 * Servlet implementation class LaguageManager
 */
@WebServlet("/laguagemanager")
public class LaguageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LaguageManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Object lg = new Object();
		String lVn = request.getParameter("VN");
		String lEn= request.getParameter("EN");
		if(lVn.equals("VN")) {
			HttpSession session = request.getSession();
			session.setAttribute("VN",lg);
			response.sendRedirect("./home.jsp");
			
		}
		else if(lVn.equals("EN")) {
			HttpSession session = request.getSession();
			session.setAttribute("EN", lg);
			response.sendRedirect("./home.jsp");
		}
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
