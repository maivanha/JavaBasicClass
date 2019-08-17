package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConnection;
import model.KhachHang;
import model.NhanVien;
public class DAONhanVien {
	
	DBConnection dbConnect = new DBConnection();
	public List<NhanVien> getAllNhanVien() throws SQLException{
		List<NhanVien> nvList = new ArrayList<NhanVien>();
		
		String sql = "select * from nhanvien";
		
		Statement sta = dbConnect.getConnection().createStatement();
		ResultSet rs = sta.executeQuery(sql);
		
		NhanVien nv;
		while(rs.next()) {
			nv = new NhanVien();
			
			nv.setMaNV(rs.getInt("manv"));
			nv.setHoTen(rs.getString("hoten"));
			nv.setTenDangNhap(rs.getString("tendangnhap"));
			nv.setMatKhau(rs.getString("matkhau"));
			nv.setDiaChi(rs.getString("diachi"));
			nv.setDienThoai(rs.getString("dienthoai"));
			
			nvList.add(nv);
		}
		
		return nvList;
	}
	
	public void insertNhanVien(NhanVien nv) throws SQLException {
		String sql = "insert into nhanvien(hoten, tendangnhap, matkhau, diachi, dienthoai)"
				+ "values (?, ?, SHA(?,512), ?, ?)";
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1,nv.getHoTen());
		preSta.setString(2, nv.getTenDangNhap());
		preSta.setString(3, nv.getMatKhau());
		preSta.setString(4, nv.getDiaChi());
		preSta.setString(5, nv.getDienThoai());
		
		preSta.executeUpdate();
	}
	
	public NhanVien login(String username, String password) throws SQLException {
		NhanVien nv = null;
		String sql = "SELECT * FROM nhanvien WHERE "
				+ "tendangnhap = ? AND matkhau = SHA2(?, 512)";
		
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1, username);
		preSta.setString(2, password);
		
		ResultSet rs = preSta.executeQuery();
		
		while(rs.next()) {
			nv = new NhanVien();
			
			nv.setMaNV(rs.getInt("manv"));
			nv.setHoTen(rs.getString("hoten"));
			nv.setTenDangNhap(rs.getString("tendangnhap"));
			nv.setMatKhau(rs.getString("matkhau"));
			nv.setDiaChi(rs.getString("diachi"));
			nv.setDienThoai(rs.getString("dienthoai"));
		}
		return nv;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DAONhanVien nvDao = new DAONhanVien();
		/*KhachHang k = new KhachHang("Nguyen Van F", "fnv", "123456", "Ha NOi", "1235486971");
		khDao.insertKhachHang(k);*/
		
		/*for(KhachHang kh : khDao.getAllKhachHang()) {
			System.out.println(kh.getHoTen());
		}*/
		
		NhanVien nv = nvDao.login("fnv", "123456");
		System.out.println(nv.getTenDangNhap());

	}

}
