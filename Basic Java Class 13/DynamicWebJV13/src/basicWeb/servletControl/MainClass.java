package basicWeb.servletControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainClass
 */
@WebServlet(name = "home", urlPatterns = { "/home" })
public class MainClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainClass() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter priWriter = response.getWriter();
		
		priWriter.append("<html>");
		priWriter.append("<head>");
		priWriter.append(	"<meta charset=\"UTF-8\" content=\"text/html\">");
		priWriter.append("</head>");
		priWriter.append("<body>");
		priWriter.append(	"<h1>").append("Hello, My name is....").append("</h1>");
		priWriter.append(	"<p style=\"border: 1px solid red; padding: 5px; width: 100%\">")
							.append("<a href=\"./home.jsp\">")
							.append(	"Xây dựng trang web Servlet đầu tiên")
							.append("</a>")
					.append("</p>");
		priWriter.append(	"<hr/>");
		priWriter.append(	"Served at: ").append(request.getContextPath());
		priWriter.append("</body>");
		priWriter.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
