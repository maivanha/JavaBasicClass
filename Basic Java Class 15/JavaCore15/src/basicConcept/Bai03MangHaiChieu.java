package basicConcept;

import java.util.Scanner;

public class Bai03MangHaiChieu {
	public static void main(String[] args) {
		int n = 0, m = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("So dong n = ");
		n = sc.nextInt();
		
		System.out.println("So cot m = ");
		m = sc.nextInt();
		
		// 1. khoi tao mang 2 chieu
		int ar[][] = new int[n][m];
		
		System.out.println(ar.length);
		System.out.println(ar[0].length);
		
		// 2. nhap gia tri cho mang 2 chieu
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				System.out.println("a[" + i + "][" + j + "] = ");
				ar[i][j] = sc.nextInt();
			}
		}
		
		// 3. In mang 2 chieu da nhap
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				System.out.print(ar[i][j] + "\t");
			}
			System.out.println("");
		}
		
		// 4. Tim kiem phan tu trong mag
		System.out.println("So can tim: ");
		int num = sc.nextInt();
		String str = new String();
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				if(ar[i][j] == num) str += i + " - " + j + "; ";
			}
		}
		System.out.println((str.length() > 0)? ("Cac vi tri co " + m + " xuat hien:"  + str) :
			"Khong tim thay!");
		
	}
	
	
	
	
	
	
}
