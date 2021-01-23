package com.niit.java.Controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.java.Entity.DanhMuc;
import com.niit.java.Entity.SanPham;
import com.niit.java.Service.danhmucService;
import com.niit.java.Service.sanphamService;


@Controller
public class TrangchuController {
	@Autowired
	danhmucService dmService;
	public danhmucService getDanhmucService() {
		return dmService;
	}

	public void setDanhmucService(danhmucService danhmucService) {
		this.dmService = danhmucService;
	}

	public sanphamService getSanphamService() {
		return sanphamService;
	}

	public void setSanphamService(sanphamService sanphamService) {
		this.sanphamService = sanphamService;
	}

	@Autowired
	sanphamService sanphamService;
	
	@RequestMapping("/")
	public String defaults(ModelMap modelMap,HttpServletRequest request) {
		/*modelMap.addAttribute("danhmucs",danhmucService.listDMByCha(0));*/
		modelMap.addAttribute("listSP", sanphamService.getAll());
		return "index";
	}

}
