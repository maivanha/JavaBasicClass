package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConnection;
import model.SanPham;

public class DAOSanPham {
	DBConnection dbConnect = new DBConnection();

	public List<SanPham> getAllSanPham() throws SQLException{
		List<SanPham> spList = new ArrayList<SanPham>();
		
		String sql = "select * from sanpham";
		
		Statement sta = dbConnect.getConnection().createStatement();
		ResultSet rs = sta.executeQuery(sql);
		
		SanPham sp;
		while(rs.next()) {
			sp = new SanPham();
			
			sp.setId(rs.getInt("id"));
			sp.setLoai(rs.getInt("loai"));
			sp.setGianhapve(rs.getInt("gianhapve"));
			sp.setGiabanra(rs.getInt("giabanra"));
			sp.setGiamgia(rs.getInt("giamgia"));
			sp.setTen(rs.getString("ten"));
			sp.setAnh(rs.getString("anh"));
			sp.setGioithieu(rs.getString("gioithieu"));
			sp.setHangsanxua(rs.getString("hangsanxua"));
			
			
			spList.add(sp);
		}
		
		return spList;
	}
	
	public void insertSanPham(SanPham sp) throws SQLException {
		String sql = "insert into sanpham(loai,gianhapve,giabanra,ten, anh, gioithieu, hangsanxua)"
				+ "values (?, ?,?,?,?,?,?)";
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setInt(1,sp.getLoai());
		preSta.setInt(2,sp.getGianhapve());
		preSta.setInt(3,sp.getGiabanra());
		preSta.setString(4, sp.getTen());
		preSta.setString(5, sp.getAnh());
		preSta.setString(6, sp.getGioithieu());
		preSta.setString(7, sp.getHangsanxua());
		
		preSta.executeUpdate();
	}
	
	public SanPham getSpById(int id) throws SQLException {
		SanPham sp = null;
		String sql = "SELECT * FROM sanpham WHERE "
				+ "id = ?";
		
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setInt(1, id);
		
		ResultSet rs = preSta.executeQuery();
		
		while(rs.next()) {
			sp = new SanPham();
			
			sp.setId(rs.getInt("id"));
			sp.setLoai(rs.getInt("loai"));
			sp.setGianhapve(rs.getInt("gianhapve"));
			sp.setGiabanra(rs.getInt("giabanra"));
			sp.setGiamgia(rs.getInt("giamgia"));
			sp.setTen(rs.getString("ten"));
			sp.setAnh(rs.getString("anh"));
			sp.setGioithieu(rs.getString("gioithieu"));
			sp.setHangsanxua(rs.getString("hangsanxua"));
		}
		System.out.println(sp.getTen());
		return sp;
	}
	
	public SanPham updateSP(SanPham sp) throws SQLException {
		String sql = "update sanpham set loai=?,ten=?,gianhapve=?,giabanra=?,giamgia=?,"
				+ "anh=?,gioithieu=?,hangsanxua=? where id=?";
		
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setInt(1, sp.getLoai());
		preSta.setString(2, sp.getTen());
		preSta.setInt(3, sp.getGianhapve());
		preSta.setInt(4, sp.getGiabanra());
		preSta.setInt(5, sp.getGiamgia());
		preSta.setString(6, sp.getAnh());
		preSta.setString(7, sp.getGioithieu());
		preSta.setString(8, sp.getHangsanxua());
		preSta.setInt(9, sp.getId());
		
		preSta.executeUpdate();
		return sp;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DAOSanPham spDao = new DAOSanPham();
		SanPham k = new SanPham(1,2,5000,7800,3000,"IP 123456","anhgiay1","mo1i","moi1" );
		spDao.updateSP(k);
		//spDao.insertSanPham(k);
		System.out.print("them xg");
		/*for(SanPham sp : spDao.getAllSanPham()) {
			System.out.println(sp.getTen());
		}*/
		
		/*SanPham sp = spDao.getSpById(2);
		System.out.println(sp.getLoai());
		System.out.println(sp.getGianhapve());
		System.out.println(sp.getGiabanra());
		System.out.println(sp.getGiamgia());
		System.out.println(sp.getTen());
		System.out.println(sp.getAnh());
		System.out.println(sp.getGioithieu());
		System.out.println(sp.getHangsanxua());*/
	}
}
