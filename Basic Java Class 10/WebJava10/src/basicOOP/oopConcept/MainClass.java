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
		//System.out.println(fish);
		
		Dog dog = new Dog(4, "Lu Lu", "Thanh Pho", 10);
		//System.out.println(dog);
		
		Cat cat = new Cat("Cate", 6, "Thanh Pho", 12);
		//System.out.println(cat);
		
		/**
		 * Làm quen với UpCasting và DownCasting
		 */
		// Ép kiểu với object
		Animal aDog = new Dog(6, "Ki Ki", "Thanh Pho", 10);
		//System.out.println(aDog);
		
		// không thể khai báo: Cat aCat = new Animal();
		// Nhưng có thể khai báo theo cách:
		//Cat aCat = (Cat)new Animal(); // qua được giai đoạn biên dịch code, nhưng lỗi khi run
		
		Animal arAnimals[] = new Animal[]{dog, cat, fish, aDog}; 
		for(Animal a : arAnimals) {
			if(a instanceof Dog) {
				System.out.println("Day la Dog:");
				((Dog) a).monAnUaThich();
			}
			System.out.println(a);
		}
		
		// So sánh tuổi của các animal
		fish.soSanh(dog);
		fish.soSanh(cat);
		
		// So sánh sử dụng animal và ép kiểu object
		fish.soSanh(aDog);
		
		// so sánh sử dụng hàm của lớp Animal:
		dog.soSanh(cat);
		dog.soSanh(aDog);
		
	}
}
