package javaCore.basic;
import java.util.Scanner;

public class TongGiaThuaDenN {
	/**
	 * Tinh tong va trung binh cong cua cac so chi het cho 3
	 * va nam trong khoang tu 200 den 600
	 */
	public void timSoChiahetCho3() {
		 int sum = 0;
	        int count = 0;
	        for (int i = 200; i <= 600; i++) {
	            if (i % 3 == 0) {
	                sum += i;
	                count++;
	            }
	        }
	        double average = (double) sum / count;
	        System.out.println("kết quả = " + sum);
	        System.out.println("kết quả = : " + average);
	}
	/**
	 * Tim cac so le trong khoang tu 50 den 100 ma chia het cho 7
	 */
	public void timSoLeVaChiaHetCho7() {
		for (int i = 50; i <= 100; i++) {
            if (i % 2 != 0 && i % 7 == 0) {
                System.out.println(i);
            }
        }
	}
	
	/**
	 * tim cac so tu 20 den 50 va chia het cho 3
	 */
	public void timSoChiaHetCho3 () {
		int i = 20;
        while (i <= 50) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
            i++;
        }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập n = ");
		int n = scanner.nextInt();
		scanner.close();
		//			int sum = 0;
		//			for (int i = 1; i <= n; i ++) {
		//				int giaiThuaI = 1;
		//				for (int j = 1; j <= i; j ++) {
		//					giaiThuaI *= j; 
		//				}
		//				sum += giaiThuaI;
		//			}
		//			

		long sum = 0;
		long giaiThua = 1;

		for (int i = 1; i <= n; i ++) {
			giaiThua *= i;
			sum += giaiThua;
		}

		System.out.println("Kết quả = " + sum);
	}
}
