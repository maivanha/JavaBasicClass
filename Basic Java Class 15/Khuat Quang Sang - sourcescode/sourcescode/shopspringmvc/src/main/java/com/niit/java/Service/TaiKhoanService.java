package com.niit.java.Service;

import org.springframework.stereotype.Service;

import com.niit.java.Entity.TaiKhoan;

@Service
public interface TaiKhoanService {
	public boolean createAccount(TaiKhoan tk);
	public TaiKhoan CheckLogin(String tendangnhap, String matkhau);
	public TaiKhoan CheckGetLogin(TaiKhoan tk);
}
