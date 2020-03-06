package service;

import java.io.Serializable;
import java.util.List;

import model.SanPham;

public class AllSanPham implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<SanPham> spList;

	public List<SanPham> getSpList() {
		return spList;
	}

	public void setSpList(List<SanPham> spList) {
		this.spList = spList;
	}
	
}
