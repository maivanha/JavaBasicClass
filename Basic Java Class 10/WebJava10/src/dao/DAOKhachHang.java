package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConnection;
import model.KhachHang;

public class DAOKhachHang {
	DBConnection dbConnect = new DBConnection();
	public List<KhachHang> getAllKhachHang() throws SQLException{
		List<KhachHang> khList = new ArrayList<KhachHang>();
		
		String sql = "select * from khachhang";
		
		Statement sta = dbConnect.getConnection().createStatement();
		ResultSet rs = sta.executeQuery(sql);
		
		KhachHang kh;
		while(rs.next()) {
			kh = new KhachHang();
			
			kh.setMakh(rs.getInt("makh"));
			kh.setHoTen(rs.getString("hoten"));
			kh.setTenDangNhap(rs.getString("tendangnhap"));
			kh.setMatKhau(rs.getString("matkhau"));
			kh.setDiaChi(rs.getString("diachi"));
			kh.setDienThoai(rs.getString("dienthoai"));
			
			khList.add(kh);
		}
		
		return khList;
	}
	
	public static void main(String[] args) throws SQLException {
		DAOKhachHang khDao = new DAOKhachHang();
		for(KhachHang kh : khDao.getAllKhachHang()) {
			System.out.println(kh.getHoTen());
		}
	}
}
