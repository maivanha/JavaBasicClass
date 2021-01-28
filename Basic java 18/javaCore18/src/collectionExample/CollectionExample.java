package collectionExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import oop.Animal;
import oop.Cat;
import oop.Dog;
import oop.Fish;

public class CollectionExample {
	Dog dog = new Dog("Lu Lu", 5, "Thành phố");
	Cat cat = new Cat("MiMi", 3, "Thành phố");
	Fish fish = new Fish("Cá vàng", 2, "Nước ngọt");
	Animal dogAni = new Dog("Mi Lu", 5, "Trang trại");

	List<Animal> aniList = new ArrayList<Animal>();
	Queue<Integer> intQue = new LinkedList<Integer>();

	public void listExample() {

		aniList.add(dog);
		aniList.add(cat);
		aniList.add(fish);
		aniList.add(dogAni);

		System.out.println(aniList);
	}

	public void mapExample() {
		Map<String, Animal> aniMap = new HashMap<String, Animal>();
		for (Animal ani : aniList) {
			aniMap.put(ani.getName(), ani);
		}

		System.out.println("Danh sách Animal trong Map:");
		for (String key : aniMap.keySet()) {
			System.out.println("Tên: " + key + "\t" + aniMap.get(key));
		}
		System.out.println("Animal có tên là Lu Lu, có thông tin: \n\t" + aniMap.get("Lu Lu"));
	}

	public void stackExample() {
		Stack<Animal> aniStack = new Stack<Animal>();
		for (Animal ani : aniList) {
			aniStack.push(ani);
		}
		Animal ani = null;
		while (aniStack.size() > 0) {
			System.out.println("Lấy ra từ Stack: ");
			ani = aniStack.pop();
			System.out.println(ani);
		}
	}

	public void queueExample(int number) {
		if (number > 0) {
			queueExample(number/2);
			intQue.add((number % 2));
		}
	}

	public void changeToBinary(int number) {
		Stack<Integer> stack = new Stack();
		while (number > 0) {
			stack.push((number % 2));
			number = number / 2;
		}
		while (stack.size() > 0) {
			System.out.print(stack.pop());
		}

	}

	public static void main(String[] args) {
		CollectionExample ce = new CollectionExample();
		// ce.listExample();
		// ce.mapExample();
		// ce.stackExample();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao so can chuyen sang nhi phan: ");
		int n = sc.nextInt();
		// ce.changeToBinary(n);
		ce.queueExample(n);
		while(ce.intQue.isEmpty() == false) System.out.print(ce.intQue.poll());
	}
}
