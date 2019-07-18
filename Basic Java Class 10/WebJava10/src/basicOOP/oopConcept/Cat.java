package basicOOP.oopConcept;

public class Cat extends Animal {
	public Cat(String ten, int tuoi, String moiTruongSong, int tuoiTrungBinh) {
		super(tuoi, ten, moiTruongSong, tuoiTrungBinh);
	}

	@Override
	public String hienThiThongTin() {
		// TODO Auto-generated method stub
		return "Cat's information:\n";
	}
}
