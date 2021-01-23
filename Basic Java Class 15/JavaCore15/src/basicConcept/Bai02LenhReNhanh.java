package basicConcept;

import java.util.Scanner;

public class Bai02LenhReNhanh {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao ngay(gia tri tu 1 - 7): ");
		int day = sc.nextInt();
		switch (day) {
		case 1:
			System.out.println("Hom nay la thu 2");
			break;
		case 2:
			System.out.println("Hom nay la thu 3");
			break;
		case 3:
			System.out.println("Hom nay la thu 4");
			//break;
		case 4:
			System.out.println("Hom nay la thu 5");
			//break;
		case 5:
			System.out.println("Hom nay la thu 6");
			//break;
		case 6:
			System.out.println("Hom nay la thu 7");
			break;
		case 7:
			System.out.println("Hom nay la thu CN");
			break;

		default:
			System.out.println("Chi nhan gia tri tu 1 - 7");
			break;
		}
	}
}
