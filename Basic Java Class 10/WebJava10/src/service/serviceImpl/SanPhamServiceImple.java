package service.serviceImpl;

import java.sql.SQLException;

import dao.DAOSanPham;
import model.SanPham;
import service.SanPhamService;

public class SanPhamServiceImple implements SanPhamService {

	@Override
	public SanPham getSanPham(int id) {
		DAOSanPham spDao = new DAOSanPham();
		try {
			return spDao.getSpById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new SanPham();
		}
	}

}
