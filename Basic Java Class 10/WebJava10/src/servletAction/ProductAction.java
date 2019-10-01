package servletAction;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		// TODO Auto-generated method stub
		DAOSanPham daoSP = new DAOSanPham();
		SanPham sp = null;

		String id = null;//= request.getParameter("iD");

		String loaiSP = null;//= request.getParameter("loaisanpham");
		String tenSP = null;//= request.getParameter("tensanpham");
		String giaBan = null;//= request.getParameter("giaban");
		String giaNhap = null;//= request.getParameter("gianhap");
		String giamGia = null;//= request.getParameter("giamgia");
		String anh = null;//= request.getParameter("anh");
		String gioiThieu = null;//= request.getParameter("gioithieu");
		String hangSX = null;//= request.getParameter("hangsx");

		FileItemFactory fif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fif);

		try {
			List itemList = sfu.parseRequest(request);
			FileItem fi;
			for (Object obj : itemList) {
				fi = (FileItem) obj;
				if (fi.isFormField()) {
					switch (fi.getFieldName()) {
					case "loaisanpham":
						loaiSP = fi.getString("UTF-8");
						break;
					case "tensanpham":
						tenSP = fi.getString("UTF-8");
						break;
					case "giaban":
						giaBan = fi.getString();
						break;
					case "gianhap":
						giaNhap = fi.getString();
						break;
					case "giamgia":
						giamGia = fi.getString();
						break;
					case "gioithieu":
						gioiThieu = fi.getString();
						break;
					case "hangsx":
						hangSX = fi.getString();
						break;
					case "iD":
						id = fi.getString();
						break;
					}
				} else {
					String filePath = "/media/maivanha/01D32B0929AA6810/My Projects/JavaBasicClass/"
							+ "JavaBasicClass/Basic Java Class 10/WebJava10/WebContent/img/sanpham";
					File uploadFolder = new File(filePath);
					if (uploadFolder.exists() == false) uploadFolder.mkdirs();
					String fileName = (new Date().getTime()) + Math.random() + fi.getName();
					filePath += "/" + fileName;
					File uploadedFile = new File(filePath);
					fi.write(uploadedFile);
					System.out.println(">>>>>> File:" + uploadedFile.getPath());
					anh = fileName;
				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (id == null || id.trim().length() < 1) {

			sp = new SanPham(Integer.parseInt(loaiSP), Integer.parseInt(giaNhap), Integer.parseInt(giaBan),
					Integer.parseInt(giamGia), tenSP, anh, gioiThieu, hangSX);
			try {
				daoSP.insertSanPham(sp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			sp = new SanPham(Integer.parseInt(id), Integer.parseInt(loaiSP), Integer.parseInt(giaNhap),
					Integer.parseInt(giaBan), Integer.parseInt(giamGia), tenSP, anh, gioiThieu, hangSX);
			try {
				daoSP.updateSP(sp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
