package service.serviceImpl;

import java.sql.SQLException;

import dao.DAOSanPham;
import model.SanPham;
import service.SanPhamService;

public class SanPhamServiceImple implements SanPhamService {

	@Override
	public SanPham getSanPham(int id) {
		DAOSanPham spDao = new DAOSanPham();
		System.out.println("\n\n\n\n >>>> run here");
		try {
			return spDao.getSpById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new SanPham();
		}
	}

	@Override
	public String getAllSanPham() {
		// TODO Auto-generated method stub
		DAOSanPham spDao = new DAOSanPham();
		try {
			
			return spDao.getAllSanPham().toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ko co data";
		}
	}

}
