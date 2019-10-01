package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOSanPham;
import model.SanPham;

/**
 * Servlet implementation class ShoppingCartAction
 */
@WebServlet(name = "shoppingCartAction", urlPatterns = { "/shoppingCartAction" })
public class ShoppingCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<Integer, SanPham> spMap ;
	public static final String SHOPPING_CART = "ShoppingCart";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/**
		 *  Lấy thông tin các sản phẩm đã chọn từ trong session
		 *  Nếu chưa chọn sản phẩm nào thì sOBject == null
		 */
		Object sObject = session.getAttribute(SHOPPING_CART);
		System.out.println(">>>>>" + sObject);
		
		// Lấy về ID của sản phầm mà người dùng đã chọn mua 
		Integer spId = Integer.parseInt(request.getParameter("id"));
		
		/**
		 *  nếu chưa có sản phẩm nào đc chọn, tức là giỏ hàng đang rỗng, thì sOBject == null 
		 *  hoặc đã có sản phẩm đc chọn (sObject != null) nhưng trong danh sách đã chọn không chứa sản phẩm người dùng vừa thêm vào (!= spId)
		 */
		if(sObject == null || ((Map<Integer, SanPham>) sObject).containsKey(spId) == false) {
			// giỏ hàng rống, nên spMap sẽ phải khởi tạo mới:
			spMap = (sObject == null)?(new HashMap<Integer, SanPham>()):(Map<Integer, SanPham> )sObject;
			
			// Gọi DAOSanPham để lấy thông tin sản phẩm theo ID 
			DAOSanPham spDao = new DAOSanPham();
			try {
				// Lấy sản phẩm theo ID, gán số lượng mua ban đầu = 1
				SanPham sp = spDao.getSpById(spId);
				sp.setSoLuongMua(1);
				
				// Đưa sản phẩm này vào giỏ hàng 
				spMap.put(spId, sp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// ép kiểu về Danh sách sản phẩm đã chọn từ session
			spMap = (Map<Integer, SanPham>) sObject;
			
			// Lấy ra sản phẩm theo spID 
			SanPham sp = spMap.get(spId);
			// tăng số lượng đã chọn lên 01
			sp.setSoLuongMua(sp.getSoLuongMua() + 1);
			
			// Đưa sản phẩm này vào giỏ hàng 
			spMap.put(spId, sp);
		}
		
		session.setAttribute(SHOPPING_CART, spMap);
		
		response.sendRedirect("./shoppingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
