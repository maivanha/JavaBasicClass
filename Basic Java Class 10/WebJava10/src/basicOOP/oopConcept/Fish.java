package basicOOP.oopConcept;

/**
 * Lớp FISH
 * @author HaMV
 *
 */
public class Fish extends Animal {
	public Fish() {
		super();
	}
	
	public Fish(int tuoi, String ten) {
		super(tuoi, ten);
	}
	
	public Fish(int tuoi, String ten, String moiTruongSong, int tuoiTrungBinh) {
		super(tuoi, ten, moiTruongSong, tuoiTrungBinh);
	}
	
	/**
	 * So sánh tuổi của Fish với Dog xem object nào già hơn<br/>
	 * Để so sánh cần chuyển cả 2 object về cùng hệ quy chiếu tuổi trung bình<br/>
	 * [So sánh] = [Tuổi của Fish] * [Tuổi trung bình của dog] -
	 * 				[Tuổi của Dog] * [Tuổi trung bình của Fish]<br/>
	 * Nếu:<br/>
	 * <ul>
	 * 	<li>[So sánh] > 0 thì Fish già hơn Dog
	 * 	<li>[So sánh] < 0 thì Fish trẻ hơn Dog
	 * </ul>
	 * @param dog
	 */
	public void soSanh(Dog dog) {
		int soSanh = this.getTuoi() * dog.getTuoiTrungBinh() - 
							this.getTuoiTrungBinh() * dog.getTuoi();
		if(soSanh > 0) System.out.println(this.getTen() + " gia hon " + dog.getTen());
		else System.out.println(dog.getTen() + " gia hon " + this.getTen());
	}
	
	public void soSanh(Cat cat) {
		int soSanh = this.getTuoi() * cat.getTuoiTrungBinh() - 
							this.getTuoiTrungBinh() * cat.getTuoi();
		if(soSanh > 0) System.out.println(this.getTen() + " gia hon " + cat.getTen());
		else System.out.println(cat.getTen() + " gia hon " + this.getTen());
	}
}
