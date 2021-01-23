package basicConcept;

import java.util.Scanner;

public class Bai01 {
	public static int a = 5;
	public static int b = 2;

	public static int tangA(Bai01 obj) {
		obj.a += 1;
		return obj.a;
	}

	public static int tangB(Bai01 obj) {
		obj.b += 1;
		return obj.b;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bai01 obj = new Bai01();

		/*
		 * System.out.print("Ten cua ban: "); String name = scanner.nextLine();
		 * System.out.println("Xin chao ban " + name);
		 */

		/*
		 * System.out.print("nhap vao a: "); int a = scanner.nextInt();
		 * 
		 * System.out.print("nhap vao b: "); int b = scanner.nextInt();
		 */

		System.out.println("Phuong trinh \"bac 01\" da tao:\n\t" + a + "*x + " + b + " = 0");

		int c = a / b; // phep chia lay phan nguyen
		System.out.println("c = a / b = " + c);

		double d = a % b; // phep chia lay phan du
		System.out.println("d = a % b = " + d);

		float f = a;
		float e = f / b; // phep chia voi so float hoac double se tra ve gia tri thuc
		System.out.println("e = a / b = " + e);

		a += 1; // tuong duong lenh: a = a + 1
		System.out.println("a = " + a);

		int i = 1;
		int j = i++;
		int k = ++i;
		System.out.println(i + " " + j + " " + k);

		if (a == 6)
			System.out.println("a co gia tri la 6");
		if (a > b)
			System.out.println("a > b");

		String message = (a > 6) ? "a lon hon 6" : "a khong lon hon 6";
		System.out.println("message: " + message);

		a = 5;
		b = 2;
		if (tangA(obj) > 4 | tangB(obj) > 2) {
			System.out.println("thoa man dieu kien nhap vao");
		} else {
			// do some thing
		}
		System.out.println(a + " " + b);

		a = 5;
		b = 2;
		if (tangA(obj) > 4 || tangB(obj) > 2) {
			System.out.println("thoa man dieu kien nhap vao");
		}
		System.out.println(a + " " + b);

		i = (int) f;

		if (a > b ) {
			System.out.println("A lon hon B");
		} else if (a < b){
			System.out.println("A nho hon B");
		} else {
			System.out.println("A bang B");
		}

		if (a == b)
			System.out.println("a bang b");
		else
			System.out.println("a khong bang b");

	}

}
