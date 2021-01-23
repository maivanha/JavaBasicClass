package genericAndCollection;

import entiy.Animal;
import entiy.Cat;
import entiy.Dog;
import entiy.Fish;

public class GenericReturn {
	public <T extends Animal> T olderAnimal(T a, T b) {
		if (a.compareTo(b) > 0)
			return a;
		else
			return b;
	}

	public static void main(String[] args) {
		Animal cat = new Cat("Lisa", "Meo yeu", "LISA123456", "CAT_2020525");
		Dog dog = new Dog("Lulu", "Cho yeu", "LuLu125346", "C_20200822_DOG");
		Fish fish = new Fish("GoldFish", "Con ca vang", "GF_123456");
		
		fish.setAvrAge(5);
		fish.setCurAge(3);
		
		dog.setAvrAge(12);
		dog.setCurAge(6);
		
		cat.setAvrAge(10);
		cat.setCurAge(6);
		
		GenericReturn gr = new GenericReturn();
		Animal reAni = gr.olderAnimal(fish, dog);
		fish.compare(dog);
		System.out.println(reAni.getName());
	}
}
