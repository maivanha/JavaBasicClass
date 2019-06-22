package basicOOP.helloWorld;

import java.util.Scanner;

/**
 * Bai lap trinh dau tien tren Java<br/>
 * <ul>
 * <li>Function <strong>helloWorld</strong>In ha HelloWorld trong ham helloWorld
 * <li>Function <b>lamQuenLenh</b> Lam quen voi cac phep toan voi kieu du lieu
 * so trong java
 * <li>Function <b>giaiPhuongTrinhBacNhat</b> Giai phuong trinh bac 1
 * </ul>
 * 
 * @author Mai Van Ha
 *
 */
public class HelloWorld {
	public void helloWorld() {
		System.out.println("Hello World !!!\n\tMy name is \"YOUR_NAME\"");
	}

	/**
	 * Ham giai phuong trinh bac nhat <br/>
	 * Nhap vao a, b <br/>
	 * Hien thi gia phuong trinh bac 1 co dang: ax + b = 0
	 */
	public void giaiPhuongTrinhBacNhat(double a, double b) {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.print("a = "); a = sc.nextDouble(); System.out.print("b = "); b =
		 * sc.nextDouble();
		 */

		System.out.println("phuong trinh bac 1: " + a + "x + " + b + " = 0");
		/*
		 * if (a != 0 ) { System.out.println(" Phuong trinh co nghiem x = " + -b/a); }
		 * else { if(b == 0) { System.out.println("Phuong trinh co vo so nghiem"); }
		 * else { System.out.println("Phuong trinh vo nghiem"); } }
		 */
		String message;
		message = (a != 0) ? ("Phuong trinh co nghiem x = " + -b / a)
				: ((b == 0) ? "Phuong trinh co vo so nghiem" : "Phuong trinh vo nghiem");

		System.out.println(message);
	}

	/**
	 * Giai phuong trinh bac 2 co dang: a*x<sup>2</sup> + b*x + c = 0 <br/>
	 * <ul>
	 * <li>Nếu a = 0 --> chuyển về giải phương trình bậc 1
	 * <li>Nếu a != 0, tính delta = b<sup>2</sup> - 4*a*c
	 * <li>Nếu Delta == 0 --> Phương trình có nghiệm duy nhất x = -b/ 2a
	 * <li>Nếu Delta > 0 --> Phương trình có 2 nghiệm: x1 = (-b + SQRT(delta))/2a,
	 * x2 = (-b - SQRT(delta))/2a,
	 * <li>Nếu Delta < 0 --> Phương trinh vô nghiệm
	 * </ul>
	 * 
	 * @param a
	 *            la so double
	 * @param b
	 *            la so double
	 * @param c
	 *            kieu double
	 */
	public void giaiPhuongTrinhBacHai(double a, double b, double c) {
		if (a == 0) {
			if (b == 0) {
				if (c != 0) {
					System.out.println("pt vo nghiem");
				} else {
					System.out.println("pt co vo so nghiem");
				}
			} else {
				System.out.println("pt co 1 nghiem :" + (-c / b));
			}
		} else {
			double delta = (double) (b * b - 4 * a * c);
			double x1;
			double x2;
			if (delta > 0) {
				x1 = (double) ((-b - Math.sqrt(delta)) / 2 * a);
				x2 = (double) ((-b + Math.sqrt(delta)) / 2 * a);
				System.out.println("pt co 2 nghiem " + x1 + " ," + x2);
			} else if (delta == 0) {
				x1 = (double) (-b / 2 * a);
				System.out.println("pt co 1 nghiem " + x1);
			} else {
				System.out.println("pt vo nghiem");
			}

		}
	}

	public void lamQuenLenh() {
		int a = 10;
		int b = 8;
		double c = 10;
		int d = a / b; // == 1
		int e = a % b; // == 2

		// c += b; //c = c + b; hay lenh nay tuong duong nhau
		// System.out.println("c = c + b = 10 " + b + " = " + c);
		System.out.println("a / b = " + d);
		System.out.println("a % b = " + e);

		double f = c / b; // == 1 --> day la ep kieu ngam dinh
		double g = c % b; // == 2
		System.out.println("c / b = " + f);
		System.out.println("c % b = " + g);

		int h = (int) c; // day la ep kieu tuong minh

	}
	
	/**
	 * In ra man hình từ 0 --> n trừ số m
	 * @param n	cận trên
	 * @param m	số sẽ không hiển thị, m < n
	 */
	public void inRaManHinh(int n, int m) {
		
	}

	public static void main(String args[]) {
		HelloWorld hw = new HelloWorld();
		hw.helloWorld();
		// hw.lamQuenLenh();
		double a = 0;
		double b = 0;
		double c = 0;
		
		int luaChon = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Lua chon chuc nang can dung:");
		System.out.println("1. Giai phuong trinh bac 1");
		System.out.println("2. Giai phuong trinh bac 2");
		System.out.println("3. in so ra man hinh");
		System.out.println("4. Tinh tong 10 so chan dau tien");
		System.out.println("5. Thoat");
		
		while(luaChon != 3) {
			System.out.print("Lua chon:");
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 1:
				System.out.println("Giai phuong trinh bac 1: ax + b = 0");
				System.out.print("a = ");
				a = sc.nextDouble();
				
				System.out.print("b = ");
				b = sc.nextDouble();
				
				hw.giaiPhuongTrinhBacNhat(a, b);
				break;
			case 2:
				System.out.println("Giai phuong trinh bac 1: ax^2 + bx + c = 0");
				System.out.print("a = ");
				a = sc.nextDouble();
				
				System.out.print("b = ");
				b = sc.nextDouble();
				
				System.out.print("c = ");
				c = sc.nextDouble();
				
				hw.giaiPhuongTrinhBacHai(a, b, c);
				break;
			case 3:
				System.out.print("n = ");
				int n = sc.nextInt();
				System.out.print("m = ");
				int m = sc.nextInt();
				hw.inRaManHinh(n, m);
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Chao tam biet!!!");
				return;
			default:
				System.out.println("Chi lua chon cac gia tri: 1 - 2 - 3");
				break;
			}
		}
		
		hw.giaiPhuongTrinhBacNhat(a, b);
		hw.giaiPhuongTrinhBacHai(a, b, c);
	}
}
