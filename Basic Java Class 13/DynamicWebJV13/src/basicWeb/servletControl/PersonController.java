package basicWeb.servletControl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basicWeb.dao.PersonDao;
import basicWeb.model.Person;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String username = request.getParameter("username");
		String password = request.getParameter("passWord");
		
		Person p = new Person(lastName, firstName, address, city, username, password, "01235468790");
		System.out.println("\n\n\n\n>>>>>>Person: " + p);
		
		PersonDao perDao = new PersonDao();
		try {
			perDao.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("./home.jsp");
	}

}
