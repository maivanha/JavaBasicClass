package basicWeb.servletControl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

		String lastName = null; //= request.getParameter("lastName");
		String firstName = null; //= request.getParameter("firstName");
		String address = null; //= request.getParameter("address");
		String city = null; //= request.getParameter("city");
		String username = null; //= request.getParameter("username");
		String password = null; //= request.getParameter("passWord");
		String avatar = null; //= null;
		String pId = null; //= null;
		
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		
		try {
			List itemList = servletFileUpload.parseRequest(request);
			FileItem fileItem;
			for(Object obj : itemList) {
				fileItem = (FileItem)obj;
				if (fileItem.isFormField()) {
					switch (fileItem.getFieldName()) {
					case "lastName":
						lastName = fileItem.getString("UTF-8");
						break;
					case "firstName":
						firstName = fileItem.getString("UTF-8");
						break;
					case "address":
						address = fileItem.getString();
						break;
					case "city":
						city = fileItem.getString();
						break;
					case "username":
						username = fileItem.getString();
						break;
					case "passWord":
						password = fileItem.getString();
						break;
					case "personId":
						pId = fileItem.getString();
						break;
					}
				} else {
					String filePath = "E:\\Study\\MaiVanHa\\My book\\Java\\"
							+ "Java coures\\Classes\\Basic Java Class 13\\"
							+ "DynamicWebJV13\\WebContent\\imgs\\";
					
					avatar = (new Date()).getTime() + "_" + fileItem.getName();
					
					File uploadFile = new File(filePath + avatar);
					fileItem.write(uploadFile);
					System.out.println(">>>>>>" + uploadFile.getPath());
				}
			}
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Person p = new Person(lastName, firstName, address, city, username, 
				password, "01235468790",avatar);
		System.out.println("\n\n\n\n>>>>>>Person: " + p);
		p.setPersonId(Integer.parseInt(pId));

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
