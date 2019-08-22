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
		return sp;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DAOSanPham spDao = new DAOSanPham();
		SanPham k = new SanPham(2,1000000,2000000,2000,"Giay","anhgiay","moi","moi" );
		
		/*spDao.insertSanPham(k);*/
		/*for(SanPham sp : spDao.getAllSanPham()) {
			System.out.println(sp.getTen());
		}*/
		
		SanPham sp = spDao.getSpById(2);
		System.out.println(sp.getLoai());
		System.out.println(sp.getGianhapve());
		System.out.println(sp.getGiabanra());
		System.out.println(sp.getGiamgia());
		System.out.println(sp.getTen());
		System.out.println(sp.getAnh());
		System.out.println(sp.getGioithieu());
		System.out.println(sp.getHangsanxua());
	}
}
