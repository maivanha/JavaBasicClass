package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOKhachHang;
import model.KhachHang;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(userName + "/" + passWord);
		if(role.equals("client")) {
			DAOKhachHang daoKH = new DAOKhachHang();
			KhachHang kh;
			try {
				kh = daoKH.login(userName, passWord);
				if(kh != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", kh);
					
					response.sendRedirect("./home.jsp");
				} else {
					response.sendRedirect("./login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("./login.jsp");
		}
	}

}
