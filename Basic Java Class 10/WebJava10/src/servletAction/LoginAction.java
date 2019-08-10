package servletAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println(userName + "/" + passWord);
		if(userName != null && userName.trim().length() > 0 &&
				passWord != null && passWord.trim().length() > 1) {
			if(userName.equals("admin") && passWord.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userName);
				
				response.sendRedirect("./home.jsp");
			}
		} else {
			response.sendRedirect("./login.jsp");
		}
	}

}
