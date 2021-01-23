package com.niit.java.test;

import java.util.List;

import com.niit.java.DAO.danhmucDaoImpl;
import com.niit.java.DAO.sanphamDaoImpl;
import com.niit.java.Entity.DanhMuc;
import com.niit.java.Entity.SanPham;

public class MainClass {

	public static void main(String[] args) {
		danhmucDaoImpl danhmucDaoImpl=new danhmucDaoImpl();
		sanphamDaoImpl sanphamDaoImpl=new sanphamDaoImpl();
		//thêm danh mục
//		DanhMuc dm=new DanhMuc();
//		
//		DanhMuc dm1 = danhmucDaoImpl.getById(4);
//		System.out.println(dm1.getTendanhmuc());
//		dm1.setTendanhmuc("con chó");
//		danhmucDaoImpl.updateDanhMuc(dm1);
//		System.out.println(dm1.getTendanhmuc());
		
//		danhmucDaoImpl.deleteDanhMuc(dm1);
		//Hiển thị danh mục
		List<DanhMuc> list = danhmucDaoImpl.getAll();
		for(DanhMuc dMuc : list) {
			System.out.println(dMuc.getTendanhmuc());
		}
		List<SanPham> listsp =sanphamDaoImpl.getAll();
		for(SanPham sPham : listsp) {
			System.out.println(sPham.getTensanpham());
		}
		 

	}

}
