package basicWeb.servletControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "changeLanguage", urlPatterns = { "/changeLanguage" })
public class ChangeLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeLanguage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedLang = request.getParameter("lang");
		switch (selectedLang) {
		case "vi_VN":
			request.getSession().setAttribute("seletedLang", "vi_VN");
			break;
		case "en_US":
			request.getSession().setAttribute("seletedLang", "en_US");
			break;
		default:
			request.getSession().setAttribute("seletedLang", "vi_VN");
			break;
		}
		response.sendRedirect("PersonController");
	}
}
