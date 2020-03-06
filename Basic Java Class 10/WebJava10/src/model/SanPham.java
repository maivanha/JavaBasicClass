package model;

import java.io.Serializable;

public class SanPham implements Serializable {
	private static final long serialVersionUID = 2265925902724958281L;
	
	private int id;
	private int loai;
	private int gianhapve;
	private int giabanra;
	private int giamgia;
	private String ten;
	private String anh;
	private String gioithieu;
	private String hangsanxua;
	
	private int soLuongMua;
	
	public SanPham() {
		
	}
	
	
	public SanPham(int loai, int gianhapve, int giabanra, int giamgia, String ten, String anh, String gioithieu,
			String hangsanxua) {
		super();
		this.loai = loai;
		this.gianhapve = gianhapve;
		this.giabanra = giabanra;
		this.giamgia = giamgia;
		this.ten = ten;
		this.anh = anh;
		this.gioithieu = gioithieu;
		this.hangsanxua = hangsanxua;
	}
	
	public SanPham(int id, int loai, int gianhapve, int giabanra, int giamgia, String ten, String anh, String gioithieu,
			String hangsanxua) {
		super();
		this.id = id;
		this.loai = loai;
		this.gianhapve = gianhapve;
		this.giabanra = giabanra;
		this.giamgia = giamgia;
		this.ten = ten;
		this.anh = anh;
		this.gioithieu = gioithieu;
		this.hangsanxua = hangsanxua;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	public int getGianhapve() {
		return gianhapve;
	}
	public void setGianhapve(int gianhapve) {
		this.gianhapve = gianhapve;
	}
	public int getGiabanra() {
		return giabanra;
	}
	public void setGiabanra(int giabanra) {
		this.giabanra = giabanra;
	}
	public int getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getGioithieu() {
		return gioithieu;
	}
	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}
	public String getHangsanxua() {
		return hangsanxua;
	}
	public void setHangsanxua(String hangsanxua) {
		this.hangsanxua = hangsanxua;
	}


	public int getSoLuongMua() {
		return soLuongMua;
	}


	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "SanPham:" + this.ten + "\tid:" + this.id + "\n";
	}
}
