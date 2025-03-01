package javaCore.oopExample;

public class Animals {
	private String name;
	private int age;
	private int tuoiTB;
	private String moiTruong;

	public Animals(String name, int age, int tuoiTB, String moiTruong) {
		this.name = name;
		this.age = age;
		this.tuoiTB = tuoiTB;
		this.moiTruong = moiTruong;
	}



	@Override
	public String toString() {
		return "Animals [name=" + name + ", age=" + age + ", tuoiTB=" + tuoiTB + ", moiTruong=" + moiTruong + "]";
	}


	/**
	 * 
	 * @param other
	 * @return 0 nếu già như nhau, +1 nếu con hiện tại già hơn con được so với nó và -1 nếu ít tuổi/ trẻ hơn.
	 */
	public String compareAge(Animals other) {
		if (this.getClass() == other.getClass()) {
			if (this.age > other.age) {
				return this.name + " gia hon " + other.name;
			} else if (this.age < other.age) {
				return this.name + " tre hon " + other.name;
			} else {
				return this.name + " va " + other.name + " cung tuoi";
			}
		} else {
			double tuoiTB_1 = (double) this.age / this.tuoiTB;
			double tuoiTB_2 = (double) other.age / other.tuoiTB;

			if (tuoiTB_1 > tuoiTB_2) {
				return this.name + " tuoi trung binh cao hon " + other.name;
			} else if (tuoiTB_1 < tuoiTB_2) {
				return this.name + " tuoi trung binh trẻ hon " + other.name;
			} else {
				return this.name + " va " + other.name + " tuong duong nhau";
			}
		}
	}
	
	public static void main(String[] args) {
		Dog dog1 = new Dog("Rex", 5);
		Dog dog2 = new Dog("Buddy", 7);
		Cat cat1 = new Cat("Whiskers", 3);

		System.out.println(dog1.toString());
		System.out.println(dog2.toString());
		System.out.println(cat1.toString());

		System.out.println(dog1.compareAge(dog2));	
		System.out.println(dog1.compareAge(cat1));

	}

}
