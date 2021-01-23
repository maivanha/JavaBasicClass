package oop;

public class Cat extends Animal {

	public Cat(String name, int age, String environment) {
		super(name, age, environment);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getAvgLifExp() {
		return 10;
	}

}
