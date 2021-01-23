package oop;

public abstract class Animal implements IAnimal {
	private String name;
	private int age;
	private String environment;
	
	public Animal(String name, int age, String environment) {
		super();
		this.name = name;
		this.age = age;
		this.environment = environment;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Thông tin của Dog:\n\t");
		sb.append("- Tên:\t").append(this.name).append("\n\t")
			.append("- Tuổi:\t").append(this.age).append("\n\t")
			.append("- Môi trường sống:\t").append(this.environment).append("\n\t")
			.append("- Tuổi thọ trung bình:\t").append(this.getAvgLifExp()).append("\n")
			.append("---------------------------------------------------------------");
		return sb.toString();
	}
	
	public int compare(Animal animal) {
		System.out.println("---> " + this.getName() + ":" + (this.getAge() / this.getAvgLifExp()));
		System.out.println("---> " + animal.getName() + ":" + (animal.getAge() / animal.getAvgLifExp()));
		double rs = (this.getAge() / this.getAvgLifExp()) - 
								(animal.getAge() / animal.getAvgLifExp());
		if(rs > 0) return 1;
		else if (rs < 0) return -1;
		return 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Môi trường sống của Dog
	 * @return môi trường sống của Chó
	 */
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}
