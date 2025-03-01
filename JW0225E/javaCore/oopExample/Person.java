package javaCore.oopExample;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Person {
	private String name;
	private int age;
	private String address;
	private String gender;
	private String code;
	private int salary;
	
	private static final int tuoiTrungBinh;
	private final String vidu;

	static Scanner scanner = new Scanner(System.in);
	
    // Static variable to count number of objects created
    private static int count = 0;
    
    static {
    	tuoiTrungBinh = 75;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		Person.scanner = scanner;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Person.count = count;
	}

	public static int getTuoitrungbinh() {
		return tuoiTrungBinh;
	}

	public String getVidu() {
		return vidu;
	}

	// Constructor
	public Person(String name, int age, String addres, String gender, int salary) {
		this.name = name;
		this.address = addres; 
		this.gender = gender;
		this.salary = salary;
		this.age = generateRandomAge(gender); 
		
		count++;  // Tăng số lượng mỗi khi một đối tượng được tạo
		
		vidu = "Khoi tao gia tri tu Constructor";
	}

	public Person (int i ) {
		Random rd = new Random();
		this.name = "Nhan Vien - " + i;
		this.address = "Dia chi nhan vien " + i; 
		this.gender = (rd.nextBoolean()) ? "Female" : "Male";
		this.salary = (rd.nextInt(30) + 1) * 1000000;
		this.code = "NV_" + (new Date()).getTime() + "_" + (rd.nextInt(10) + 1);
		this.age = generateRandomAge(gender); 
		
		count++;  // Tăng số lượng mỗi khi một đối tượng được tạo
		vidu = "Khoi tao gia tri tu Constructor";
		System.out.println("Toi la object thu: " + count);
	}

	public void inputDetails() {
		System.out.print("Enter name: ");
		name = scanner.nextLine();

		System.out.print("Enter address: ");
		address = scanner.nextLine();

		System.out.print("Enter age: ");
		age = generateRandomAge(gender);
//		age = scanner.nextInt();
//		scanner.nextLine(); 

		System.out.print("Enter gender (Male/Female): ");
		gender = scanner.nextLine();
	}

	public void displayDetails() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Gender: " + gender);
		System.out.println("Age: " + age);
		System.out.println("Code: " + code);
		System.out.println("Salary: " + salary);
		System.out.println("Tong so objects: " + count);
	}

	private int generateRandomAge(final String gender) {
		Random random = new Random();
		if (gender.equalsIgnoreCase("Male")) {
			return 18 + random.nextInt(48); // Tuổi từ 18 đến 65
		} else if (gender.equalsIgnoreCase("Female")) {
			return 18 + random.nextInt(43); // Tuổi từ 18 đến 60
		} else {
			return 0; // Giá trị mặc định nếu giới tính không hợp lệ
		}
	}

	public static void main(String[] args) {
		Person[] persons = new Person[10];

		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(i + 1);
//			System.out.println("Enter details for person " + (i + 1) + ":");
//			persons[i].inputDetails();
		}

		for (int i = 0; i < persons.length; i++) {
			System.out.println("\nDetails of person " + (i + 1) + ":");
			persons[i].displayDetails();
		}

		// Hiển thị nhân viên có tuổi > 30
		System.out.println("\nDanh sách nhân viên có tuổi > 30:");
		for (Person nv : persons) {
			if (nv.age > 30) {
				nv.displayDetails();
				System.out.println("----------------------");
			}
		}

		scanner.close();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}