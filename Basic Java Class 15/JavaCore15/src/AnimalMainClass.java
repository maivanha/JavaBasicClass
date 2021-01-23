import entiy.Animal;
import entiy.AnimalInterface;
import entiy.Cat;
import entiy.Dog;
import entiy.Fish;

public class AnimalMainClass {
	public static void main(String[] args) {
		/*
		 * Animal animal = new Animal("Lisa", "Meo yeu", "LISA123456");
		 * System.out.println("Ten cua con meo: " + animal.getName());
		 */
		
		Animal cat = new Cat("Lisa", "Meo yeu", "LISA123456", "CAT_2020525");
		
		Dog dog = new Dog("Lulu", "Cho yeu", "LuLu125346", "C_20200822_DOG");
		
		System.out.println("Ten cua con cho: " + dog.getName());
		
		Animal dog2 = new Dog("Milu", "Cun Yeu", "Milu231654", "Khong co");
		System.out.println("Ten cua con cho thu 2: " + dog2.getName());
		
		/*
		 * Dog dog3 = (Dog)new Animal("dads", "dafdsf", "afasf");
		 * System.out.println("Ten cua con cho thu 3: " + dog3.getName());
		 */
		
		if(dog instanceof Animal) System.out.println(dog.getName() + 
									" la mot the hien cua " + Animal.class);
		
		dog.screenPrint();
		
		dog.screenPrint("Message");
		
		Fish fish = new Fish("GoldFish", "Con ca vang", "GF_123456");
		fish.setAvrAge(5);
		fish.setCurAge(3);
		
		dog.setAvrAge(12);
		dog.setCurAge(6);
		
		cat.setAvrAge(10);
		cat.setCurAge(6);
		
		fish.compare(dog);
		fish.compare(cat);
		
		dog.compare(cat);
	}
}
