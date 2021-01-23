package basic;

import java.util.Random;
import java.util.Scanner;

public class MaTran {
	public static int intMa[][] = null;
	public static int n;
	public static int m;
	public static Scanner sc = new Scanner(System.in);

	public static void khoiTaoMaTran() {
		System.out.print("n = ");
		n = sc.nextInt();
		System.out.print("m = ");
		m = sc.nextInt();

		intMa = new int[n][m];

		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				intMa[i][j] = rd.nextInt(100);
			}
		}
	}

	public static void inMaTran() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(intMa[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	public static void oddInt() {
		boolean flag = false;
		int min = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (intMa[i][j] % 2 != 0 && 
						(flag == false || min > intMa[i][j])) {
					flag = true;
					min = intMa[i][j];
				}
			}
		}

		if (flag)
			System.out.println("min = " + min);
		else
			System.out.println("Khong co so le");
	}

	public static void main(String[] args) {
		khoiTaoMaTran();
		inMaTran();
		oddInt();
	}

}
