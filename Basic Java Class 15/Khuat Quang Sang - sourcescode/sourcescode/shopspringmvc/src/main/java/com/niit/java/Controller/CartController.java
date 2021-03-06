package com.niit.java.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.java.Model.Cart;
import com.niit.java.Service.CartServiceImpl;
import com.niit.java.Service.danhmucService;

@Controller 
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl=new CartServiceImpl();
	@Autowired
	private danhmucService danhmucService;
	
	@RequestMapping(value="gio-hang")
	public String listCart(ModelMap modelMap) {
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		return "cart";
	}
	
	@RequestMapping(value="AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session,@PathVariable("id") long id,ModelMap modelMap ) {
		HashMap<Long, Cart> cart=(HashMap<Long, Cart>) session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Long,Cart>();
		}
		cart = cartServiceImpl.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		int soluong=(int) cartServiceImpl.TotalQuantity(cart);
		session.setAttribute("TotalQuantityCart",soluong);
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		return "redirect:"+request.getHeader("Referer");
		//return "cart";
	}
	@RequestMapping(value="TangCart/{id}")
	public String SubCart(HttpServletRequest request,HttpSession session,@PathVariable("id") long id,ModelMap modelMap ) {
		HashMap<Long, Cart> cart=(HashMap<Long, Cart>) session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Long,Cart>();
		}
		cart = cartServiceImpl.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		int soluong=(int) cartServiceImpl.TotalQuantity(cart);
		session.setAttribute("TotalQuantityCart",soluong);
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		return "redirect:"+request.getHeader("Referer");
		//return "cart";
	}
	@RequestMapping(value="GiamCart/{id}")
	public String GiamCart(HttpServletRequest request,HttpSession session,@PathVariable("id") long id,ModelMap modelMap ) {
		HashMap<Long, Cart> cart=(HashMap<Long, Cart>) session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Long,Cart>();
		}
		cart = cartServiceImpl.SubCart(id, cart);
		session.setAttribute("Cart", cart);
		int soluong=(int) cartServiceImpl.TotalQuantity(cart);
		session.setAttribute("TotalQuantityCart",soluong);
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		return "redirect:"+request.getHeader("Referer");
		//return "cart";
	}
	
    @RequestMapping(value="EditCart/{id}/{quantity}")
    public String EditCart(HttpServletRequest request,HttpSession session,@PathVariable("id") long id,@PathVariable("quantity") int quantity,ModelMap modelMap ) {
		HashMap<Long, Cart> cart=(HashMap<Long, Cart>) session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Long,Cart>();
		}
		cart = cartServiceImpl.EditCart(id, quantity, cart);
		session.setAttribute("Cart", cart);
		int soluong=(int) cartServiceImpl.TotalQuantity(cart);
		session.setAttribute("TotalQuantityCart",soluong);
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
		//return "cart";
	}
    @RequestMapping(value="DeleteCart/{id}")
    public String DeleteCart(HttpServletRequest request,HttpSession session,@PathVariable("id") long id,ModelMap modelMap ) {
		HashMap<Long, Cart> cart=(HashMap<Long, Cart>) session.getAttribute("Cart");
		if(cart==null) {
			cart=new HashMap<Long,Cart>();
		}
		cart = cartServiceImpl.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		int soluong=(int) cartServiceImpl.TotalQuantity(cart);
		session.setAttribute("TotalQuantityCart",soluong);
		session.setAttribute("TotalPriceCart",cartServiceImpl.TotalPrice(cart));
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		return "redirect:"+request.getHeader("Referer");
		//return "cart";
	}
    @RequestMapping(value="checkout")
    public String CheckOut(HttpServletRequest request,HttpSession session,ModelMap modelMap) {
    	
    	return "checkout";
    }
    
}
