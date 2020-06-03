package niit.java.mvcProject.servletControl;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.java.mvcProject.dao.PersonDao;
import niit.java.mvcProject.model.Person;

@ManagedBean(name = "userAction", eager = true)
public class PersonController {
	private Person editedUser;
	private PersonDao perDao = new PersonDao();

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

	public String save()
			throws ServletException, IOException {

		try {
			if (editedUser.getPersonId() == 0)
				perDao.save(editedUser);
			else
				perDao.update(editedUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	public Person getEditedUser() {
		return editedUser;
	}

	public void setEditedUser(Person editedUser) {
		this.editedUser = editedUser;
	}

}
