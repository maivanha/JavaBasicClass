package basicOOP.oopConcept;

public class Animal {
	private int tuoi;
	private int tuoiTrungBinh;
	private String moiTruongSong;
	private String ten;

	public Animal() {
		ten = "FISH";
		tuoi = 1;
		tuoiTrungBinh = 5;
		moiTruongSong = "Duoi nuoc";
	}

	public Animal(int tuoi, String ten) {
		tuoiTrungBinh = 5;
		moiTruongSong = "Duoi nuoc";
		this.tuoi = tuoi;
		this.ten = ten;
	}

	public Animal(int tuoi, String ten, String moiTruongSong, int tuoiTrungBinh) {
		this.tuoi = tuoi;
		this.ten = ten;
		this.moiTruongSong = moiTruongSong;
		this.tuoiTrungBinh = tuoiTrungBinh;
	}
	
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("Ten: ").append(this.ten).append("\n");
		message.append("Tuoi: ").append(this.tuoi).append("\n");
		message.append("Moi truong song: ").append(this.moiTruongSong).append("\n");
		message.append("Tuoi trung binh: ").append(this.tuoiTrungBinh).append("\n");
		message.append("###########################################################\n");
		return message.toString();
	}
	
	/**
	 * Hàm so sánh 02 objects cùng kiểu Animal với nhau xem
	 * con nào già hơn con nào.
	 * @param animal
	 */
	public void soSanh(Animal animal) {
		int soSanh = this.getTuoi() * animal.getTuoiTrungBinh() - 
							this.getTuoiTrungBinh() * animal.getTuoi();
		if(soSanh > 0) System.out.println(this.getTen() + " gia hon " + animal.getTen());
		else System.out.println(animal.getTen() + " gia hon " + this.getTen());
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public int getTuoiTrungBinh() {
		return tuoiTrungBinh;
	}

	public void setTuoiTrungBinh(int tuoiTrungBinh) {
		this.tuoiTrungBinh = tuoiTrungBinh;
	}

	public String getMoiTruongSong() {
		return moiTruongSong;
	}

	public void setMoiTruongSong(String moiTruongSong) {
		this.moiTruongSong = moiTruongSong;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
}
