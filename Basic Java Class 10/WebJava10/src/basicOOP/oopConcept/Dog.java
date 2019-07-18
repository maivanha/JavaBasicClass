package basicOOP.oopConcept;

public class Dog extends Animal{
	public Dog() {
		super();
	}
	
	public Dog(int tuoi, String ten) {
		super(tuoi, ten);
	}
	
	public Dog(int tuoi, String ten, String moiTruongSong, int tuoiTrungBinh) {
		super(tuoi, ten, moiTruongSong, tuoiTrungBinh);
	}
	
	public void monAnUaThich() {
		System.out.println("Thich gam xuong");
	}

	@Override
	public String hienThiThongTin() {
		// TODO Auto-generated method stub
		return "Dog's information: \n";
	}
}
