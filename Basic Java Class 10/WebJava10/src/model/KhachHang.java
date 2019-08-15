package model;

public class KhachHang {
	private int makh;
	private String hoTen;
	private String tenDangNhap;
	private String matKhau;
	private String diaChi;
	private String dienThoai;
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String hoTen, String tenDangNhap, String matKhau, String diaChi, String dienThoai) {
		this.hoTen = hoTen;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
	}



	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
}
