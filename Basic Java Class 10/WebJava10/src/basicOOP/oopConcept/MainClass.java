package basicOOP.oopConcept;

/**
 * Lớp chính để thao tác với các class được khai báo
 * @author HaMV
 *
 */
public class MainClass {
	public static void main(String[] args) {
		Fish fish = new Fish();
		fish.setTen("Ca Vang");
		fish.setMoiTruongSong("Nuoc ngot");
		System.out.println(fish);
		
		Dog dog = new Dog(4, "Lu Lu", "Thanh Pho", 10);
		System.out.println(dog);
		
		Cat cat = new Cat("Cate", 6, "Thanh Pho", 12);
		System.out.println(cat);
	}
}
