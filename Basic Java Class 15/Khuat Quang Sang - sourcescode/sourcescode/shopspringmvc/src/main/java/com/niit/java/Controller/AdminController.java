package com.niit.java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.java.Entity.DanhMuc;
import com.niit.java.Service.danhmucService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	danhmucService danhmucService;
	
	@GetMapping
	public String defaults() {
		List<DanhMuc> list=danhmucService.getAll();
		for(DanhMuc dMuc :list) {
			System.out.println(dMuc.getTendanhmuc());
		}
		return "admin/index";
	}

}
