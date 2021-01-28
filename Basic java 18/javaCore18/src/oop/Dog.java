package oop;

/**
 * Lớp Chó (<i>Dog</i>) để quản lý đối tượng là <b>Dog</b>
 * @author Hà MV
 *
 */
public final class Dog extends Animal {
	public static int countObject = 0;
	public int count = 0;
	public final int fInt = 0;
	
	/**
	 * Tuổi thọ trung bình: Average Life Expectancy 
	 */
	private final float avgLifExp = 12; 
	
	public Dog(String name, int age, String environment) {
		super(name, age, environment);
		this.countObject ++;
		this.count ++;
	}

	public static int getCountObject() {
		return countObject;
	}
	
	/**
	 * Tuổi thọ trung bình: Average Life Expectancy 
	 * @return Tuổi thọ trung bình của loài chó
	 */
	public float getAvgLifExp() {
		return 12;
	}
	
	public float getAvgLifExp(float input) {
		return input;
	}
	
	/*
	 * public void setAvgLifExp(float avgLifExp) { this.avgLifExp = avgLifExp; }
	 */
	
	
}
