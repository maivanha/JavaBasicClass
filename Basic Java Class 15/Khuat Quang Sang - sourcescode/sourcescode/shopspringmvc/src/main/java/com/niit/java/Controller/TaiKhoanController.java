package com.niit.java.Controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.java.Entity.TaiKhoan;
import com.niit.java.Service.TaiKhoanService;
import com.niit.java.Service.TaiKhoanServiceImpl;
import com.niit.java.Service.danhmucService;
import com.niit.java.Service.sanphamService;
import com.niit.java.test.MaHoa;

@Controller
public class TaiKhoanController {
	@Autowired
	danhmucService danhmucService;
	@Autowired
	TaiKhoanService TaiKhoanService=new TaiKhoanServiceImpl();
	@Autowired
	SessionFactory SessionFactory;
	@Autowired
	sanphamService sanphamService;
	
	@RequestMapping("/dang-ky-form")
	public String Dangki(ModelMap modelMap) {
		modelMap.addAttribute("taikhoan",new TaiKhoan());
		return "account";
	}
	@RequestMapping("/dang-ky")
	public String createAccount(HttpServletRequest request,@ModelAttribute("taikhoan") TaiKhoan taikhoan,ModelMap modelMap) {
		boolean kt=TaiKhoanService.createAccount(taikhoan);
		String massages="";
		if(kt==true) {
			System.out.println("đăng ký ko thành công");
			modelMap.addAttribute(massages, "đăng ký ko thành công");
			return "redirect:"+request.getHeader("Referer");
		}else {
			System.out.println("đăng ký tài khoản thành công");
			modelMap.addAttribute(massages, "đăng ký tài khoản thành công");
			//return "redirect:"+request.getHeader("Referer");
			return "account";
		}
	}
	@RequestMapping("/dang-nhap")
	public String Login(@ModelAttribute("taikhoan") TaiKhoan taikhoan,HttpSession session,ModelMap modelMap) {
		try {
			modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
			modelMap.addAttribute("listSP", sanphamService.getAll());
			TaiKhoan kt = TaiKhoanService.CheckGetLogin(taikhoan);
		    if(kt!=null) {
		    	System.out.println("đăng nhập thành công");
		    	session.setAttribute("logininfo", kt);
		    	return "index";
		    }
				
		    } catch (NoResultException e) {
		    	System.out.println("đăng nhập thất bại");
				e.getMessage();
				modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
				modelMap.addAttribute("listSP", sanphamService.getAll());
				modelMap.addAttribute("status", "đăng nhập thất bại");
				return "account";
			}
		return null;
	}
	@RequestMapping("/dang-xuat")
	public String logout(@ModelAttribute("taikhoan") TaiKhoan taikhoan,HttpSession session,ModelMap modelMap,HttpServletRequest request) {
		session.removeAttribute("logininfo");
		modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));
		modelMap.addAttribute("listSP", sanphamService.getAll());
		//return "redirect:"+request.getHeader("Referer");
		return "index";
	}
	

}
