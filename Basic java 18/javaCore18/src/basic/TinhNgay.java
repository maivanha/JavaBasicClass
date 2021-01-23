package basic;

import java.util.Scanner;

public class TinhNgay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Điền thứ của này hôm nay: ");
		int ngay = sc.nextInt();
		switch (ngay) {
		case 1:
			System.out.println("Ngày hôm nay là ngày chủ nhật: ");
			break;
		case 2:
			System.out.println("Ngày hôm nay là ngày thứ 2: ");
			break;
		case 3:
			System.out.println("Ngày hôm nay là ngày thứ 3: ");
			break;
		case 4:
			System.out.println("Ngày hôm nay là ngày thứ 4: ");
			break;
		case 5:
			System.out.println("Ngày hôm nay là ngày thứ 5: ");
			break;
		case 6:
			System.out.println("Ngày hôm nay là ngày thứ 6: ");
			break;
		case 7:
			System.out.println("Ngày hôm nay là ngày thứ 7: ");
			break;
		default:
			System.out.println("Invalid!");
			break;
		}
		sc.close();
	}
}
