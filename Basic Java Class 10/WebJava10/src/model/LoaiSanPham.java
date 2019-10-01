package model;

public class LoaiSanPham {
	private int id;
	private String tenloai;
	private String ghichu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public LoaiSanPham(String tenloai, String ghichu) {
		super();
		this.tenloai = tenloai;
		this.ghichu = ghichu;
	}
	public LoaiSanPham() {
		super();
	}
	
	
}
