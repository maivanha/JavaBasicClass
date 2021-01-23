package com.niit.java.DAO;

import com.niit.java.Entity.TaiKhoan;

public interface TaiKhoanDao {
	public void createAccount(TaiKhoan tk);
	public TaiKhoan CheckLogin(String tendangnhap,String matkhau);
    
}
