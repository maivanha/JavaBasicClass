package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOSanPham;
import model.SanPham;

/**
 * Servlet implementation class ProductAction
 */
@WebServlet("/manage/productAction")
public class ProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		DAOSanPham spDao = new DAOSanPham();
		SanPham sp = null;
		String id = request.getParameter("id");
		if (id == null) {
			List<SanPham> spList = new ArrayList<SanPham>();
			try {
				spList = spDao.getAllSanPham();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("spList", spList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./productlist.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				sp = spDao.getSpById(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("product", sp);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./productform.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOSanPham daoSP = new DAOSanPham();
		SanPham sp = null;
		String id = request.getParameter("iD");
		if (id == null || id.trim().length() < 1) {

			String loaiSP = request.getParameter("loaisanpham");
			String tenSP = request.getParameter("tensanpham");
			String giaBan = request.getParameter("giaban");
			String giaNhap = request.getParameter("gianhap");
			String giamGia = request.getParameter("giamgia");
			String anh = request.getParameter("anh");
			String gioiThieu = request.getParameter("gioithieu");
			String hangSX = request.getParameter("hangsx");

			sp = new SanPham(Integer.parseInt(loaiSP), Integer.parseInt(giaNhap), Integer.parseInt(giaBan),
					Integer.parseInt(giamGia), tenSP, anh, gioiThieu, hangSX);
			try {
				daoSP.insertSanPham(sp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doGet(request, response);

		} else {
			String iD = request.getParameter("iD");
			String loaiSP = request.getParameter("loaisanpham");
			String tenSP = request.getParameter("tensanpham");
			String giaBan = request.getParameter("giaban");
			String giaNhap = request.getParameter("gianhap");
			String giamGia = request.getParameter("giamgia");
			String anh = request.getParameter("anh");
			String gioiThieu = request.getParameter("gioithieu");
			String hangSX = request.getParameter("hangsx");
			
			sp = new SanPham(Integer.parseInt(iD), Integer.parseInt(loaiSP), Integer.parseInt(giaNhap), Integer.parseInt(giaBan),
					Integer.parseInt(giamGia), tenSP, anh, gioiThieu, hangSX);
			try {
				daoSP.updateSP(sp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doGet(request, response);
		}
	}

}
