package com.niit.java.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.java.Entity.DanhMuc;
import com.niit.java.Service.danhmucService;

@Controller
public class DanhmucController {
	@Autowired 
	danhmucService danhmucService;
	@RequestMapping("/danhmuc-list")
	public String loadDanhmuc(HttpServletRequest request,ModelMap modelMap) {
		List<DanhMuc> danhMucs =danhmucService.getAll(); 
	    //modelMap.addAttribute("listDM", danhmucService.getAll());
		PagedListHolder pagedListHolder = new PagedListHolder(danhMucs);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(4);
		modelMap.put("pagedListHolder", pagedListHolder);
		return "admin/danhsachdanhmuc";
	}
	@RequestMapping("/danhmuc-save")
	public String themdanhmuc(ModelMap map) {
		map.addAttribute("danhmuc",new DanhMuc());
		return "admin/themdanhmuc";
	}
	@RequestMapping("/themdanhmuc")
	public String xulythemdanhmuc(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("DanhMuc") DanhMuc danhmuc,ModelMap modelMap) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		danhmucService.themDanhMuc(danhmuc);
		modelMap.addAttribute("listDM", danhmucService.getAll());
		//return "admin/danhsachdanhmuc";
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping("/capnhatdanhmuc")
	public String capnhatdanhmuc(@ModelAttribute("DanhMuc") DanhMuc danhmuc,ModelMap modelMap) {
		danhmucService.updateDanhMuc(danhmuc);
		modelMap.addAttribute("listDM", danhmucService.getAll());
		return "admin/danhsachdanhmuc";
	}
	@RequestMapping("/danhmuc-update/{id}")
	public String layttdanhmuc(@PathVariable int id,ModelMap modelMap) {
		DanhMuc danhmuc=danhmucService.getById(id);
		modelMap.addAttribute("danhmuc", danhmuc);
		return "admin/capnhatdanhmuc";
	}
	@RequestMapping("/danhmuc-delete/{id}")
	public String xoattdanhmuc(@PathVariable int id,ModelMap modelMap) {
		danhmucService.deleteDanhMuc(id);
		modelMap.addAttribute("listDM", danhmucService.getAll());
		return "admin/danhsachdanhmuc";

	}

}
