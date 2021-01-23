package basic;

import java.util.Scanner;

public class GiaiPhuongTrinhBacHai {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap a: ");
		double a = sc.nextFloat();
		System.out.println("Nhap b: ");
		double b = sc.nextFloat();
		System.out.println("Nhap c: ");
		double c = sc.nextFloat();
		double delta = (b * b) - 4 * (a * c);
		if (delta >= 0) {
			if (delta > 0) {
				System.out.println("Nghiem thu nhat:" + ((-b + Math.sqrt(delta)) / (2 * a)));
				System.out.println("Nghiem thu hai: " + ((-b - Math.sqrt(delta)) / (2 * a)));
			} else if (delta == 0) {
				System.out.println("Phuong trinh co mot nghiem duy nhat: " + -b / (2 * a));
			}
		} else {
			System.out.println("Phuong trinh vo nghiem!!!");
			sc.close();
		}
	}
}
