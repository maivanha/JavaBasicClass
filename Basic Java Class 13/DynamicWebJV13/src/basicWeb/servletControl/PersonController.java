package basicWeb.servletControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

	PersonDao perDao = new PersonDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		RequestDispatcher rd = null;
		if (userId == null) {
			try {
				List<Person> perList = perDao.getAll();
				System.out.println(perList);
				request.setAttribute("userList", perList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("./home.jsp");
		} else {
			try {
				Person per = perDao.getPerById(Integer.parseInt(userId));
				System.out.println(per);
				request.setAttribute("editedUser", per);
			} catch (Exception e) {
				e.printStackTrace();
			}
			rd = request.getRequestDispatcher("./userinfor.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String username = request.getParameter("username");
		String password = request.getParameter("passWord");

		Person p = new Person(lastName, firstName, address, city, username, password, "01235468790");
		p.setPersonId(Integer.parseInt(request.getParameter("personId")));
		System.out.println("\n\n\n\n>>>>>>Person: " + p);

		try {
			if(p.getPersonId() == 0)
				perDao.save(p);
			else 
				perDao.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//response.sendRedirect("PersonController");
		doGet(request, response);
	}

}
