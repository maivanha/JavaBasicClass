package com.niit.java.Service;

import javax.validation.constraints.Null;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.java.DAO.TaiKhoanDao;
import com.niit.java.Entity.TaiKhoan;
import com.niit.java.test.MaHoa;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
	@Autowired
	private TaiKhoanDao taiKhoanDao;

	@Override
	public boolean createAccount(TaiKhoan tk) {
		//tk.setMatkhau(BCrypt.hashpw(tk.getMatkhau(),BCrypt.gensalt(12)));
		tk.setMatkhau(MaHoa.encryption(tk.getMatkhau()));
		taiKhoanDao.createAccount(tk);
		return false;
	}

	@Override
	public TaiKhoan CheckLogin(String tendangnhap, String matkhau) {
		// TODO Auto-generated method stub
		return taiKhoanDao.CheckLogin(tendangnhap, matkhau);
	}
	public TaiKhoan CheckGetLogin(TaiKhoan tk) {
		String tendangnhap=tk.getTendangnhap();
		String matkhau=tk.getMatkhau();
		TaiKhoan results=CheckLogin(tendangnhap, matkhau);
		if (results!=null) {
			return results;
		}
		return null;
	}
	

	

}
