package dao;

import java.sql.PreparedStatement;
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
	
	public void insertKhachHang(KhachHang kh) throws SQLException {
		/*
		sql = "INSERT INTO nhanvien (hoten, tendangnhap, matkhau, dienthoai) "
				+ "VALUES (N'"+kh.getHoTen() + "', '"+ kh.getTenDangNhap() + 
					"', SHA2('"+"', 512), '"+"');";
		*/
		String sql = "INSERT INTO khachhang (hoten, tendangnhap, matkhau, diachi, dienthoai) "
				+ "VALUES (?, ?, SHA2(?, 512), ?, ?)";
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1, kh.getHoTen());
		preSta.setString(2, kh.getTenDangNhap());
		preSta.setString(3, kh.getMatKhau());
		preSta.setString(4, kh.getDiaChi());
		preSta.setString(5, kh.getDienThoai());
		
		preSta.executeUpdate();
	}
	
	public KhachHang login(String username, String password) throws SQLException {
		KhachHang kh = null;
		String sql = "SELECT * FROM khachhang WHERE "
				+ "tendangnhap = ? AND matkhau = SHA2(?, 512)";
		
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1, username);
		preSta.setString(2, password);
		
		ResultSet rs = preSta.executeQuery();
		
		while(rs.next()) {
			kh = new KhachHang();
			
			kh.setMakh(rs.getInt("makh"));
			kh.setHoTen(rs.getString("hoten"));
			kh.setTenDangNhap(rs.getString("tendangnhap"));
			kh.setMatKhau(rs.getString("matkhau"));
			kh.setDiaChi(rs.getString("diachi"));
			kh.setDienThoai(rs.getString("dienthoai"));
		}
		return kh;
	}
	
	public static void main(String[] args) throws SQLException {
		DAOKhachHang khDao = new DAOKhachHang();
		/*KhachHang k = new KhachHang("Nguyen Van F", "fnv", "123456", "Ha NOi", "1235486971");
		khDao.insertKhachHang(k);*/
		
		/*for(KhachHang kh : khDao.getAllKhachHang()) {
			System.out.println(kh.getHoTen());
		}*/
		
		KhachHang k = khDao.login("fnv", "123456");
		System.out.println(k.getTenDangNhap());
	}
}
