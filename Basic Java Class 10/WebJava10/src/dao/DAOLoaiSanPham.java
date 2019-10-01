package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import jdbc.DBConnection;
import model.LoaiSanPham;

public class DAOLoaiSanPham {

	DBConnection dbConnect = new DBConnection();

	public Map<Integer, LoaiSanPham> getAllLoaiSanPhams() throws SQLException{
		Map<Integer, LoaiSanPham> loaiSPMap = new HashMap<Integer, LoaiSanPham>();

		String sql = "select * from loaisanpham";

		Statement sta = dbConnect.getConnection().createStatement();
		ResultSet rs = sta.executeQuery(sql);
		LoaiSanPham loaisp;
		while(rs.next()) {
			loaisp = new LoaiSanPham();
			loaisp.setTenloai(rs.getString("tenloai"));
			loaisp.setGhichu(rs.getString("ghichu"));
			loaisp.setId(rs.getInt(1));

			loaiSPMap.put(rs.getInt(1), loaisp);
		}

		return loaiSPMap;
	}

	public void insertLoaiSanPham(LoaiSanPham loaisp) throws SQLException {
		String sql = "insert into Loaisanpham(tenloai,ghichu)"
				+ "values (?, ?,)";
		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1, loaisp.getTenloai());
		preSta.setString(2,loaisp.getGhichu());
		preSta.executeUpdate();


	}

	public LoaiSanPham getLoaiSpById(int id) throws SQLException {
		LoaiSanPham Loaisp = null;
		String sql = "SELECT * FROM loaisanpham WHERE "
				+ "id = ?";

		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setInt(1, id);

		ResultSet rs = preSta.executeQuery();

		while(rs.next()) {
			Loaisp = new LoaiSanPham();

			Loaisp.setId(rs.getInt("id"));
			Loaisp.setTenloai(rs.getString("tenloai"));
			Loaisp.setGhichu(rs.getString("ghichu"));

		}
		System.out.println(Loaisp.getTenloai());
		return Loaisp;
	}
	public LoaiSanPham updateLoaiSP(LoaiSanPham sp) throws SQLException {
		String sql = "update loaisanpham set tenloai=?,ghichu=?, where id=?";

		PreparedStatement preSta = dbConnect.getConnection().prepareStatement(sql);
		preSta.setString(1, sp.getTenloai());
		preSta.setString(2, sp.getGhichu());
		preSta.setInt(3, sp.getId());

		return sp;
	}

}
