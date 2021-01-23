package oop;

public class MainClass {
	public static void main(String[] args) {
		Dog dog = new Dog("Lulu", 5, "Thành phố");
		
		System.out.println(dog);
		System.out.println("Số object đc tạo ra của dog: " + dog.countObject);
		System.out.println("count của dog: " + dog.count);
		
		Dog dog2 = new Dog("Milu", 3, "Trang trại");
		System.out.println(dog2);
		System.out.println("Số object đc tạo ra của dog2: " + dog2.countObject);
		System.out.println("count của dog2: " + dog2.count);
		
		System.out.println("Số object đc tạo ra của Dog Class: " + Dog.countObject);
		System.out.println("Số object đc tạo ra của dog: " + dog.countObject);

		System.out.println("Số object đc tạo ra của Dog Class: " + Dog.getCountObject());
		
		Animal dog3 = new Dog("Dog 3", 6, "Đảo");
		
		Cat cat = new Cat("Cat1", 7, "Thành phố");
		Fish fish = new Fish("Cá Vàng", 3, "Nước ngọt");
		
		Animal[] aniAr = {dog, dog2, dog3, cat, fish};
		
		Dog d = null;
		Cat c = null;
		for(Animal a : aniAr) {
			if(a instanceof Dog){
				d = (Dog)a;
				System.out.println("Object là Dog");
				System.out.println(d.getCountObject());
			} else if (a instanceof Cat) {
				c = (Cat) a;
				System.out.println("Object là Cat");
			} else if( a instanceof Fish) {
				System.out.println("Object là Fish");
			}
			System.out.println(a);
		}
		System.out.println("So sanh dog3 va Fish");
		int compare = dog3.compare(fish);
		if(compare > 0) 
			System.out.println(dog3.getName() + " gia hon " + fish.getName());
		else if(compare < 0)  
			System.out.println(dog3.getName() + " tre hon " + fish.getName());
		else 
			System.out.println(dog3.getName() + " gia ngang voi " + fish.getName());
	}
}
