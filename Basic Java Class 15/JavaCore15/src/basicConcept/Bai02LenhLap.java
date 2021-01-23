package basicConcept;

import java.util.Scanner;

public class Bai02LenhLap {
	public static void main(String[] args) {
		//1. Tinh n giai thua voi n nhap vao tu ban phim
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao n: ");
		int n = sc.nextInt();
		
		double gt = 1;
		int i = 1;
		while(i <= n) {
			gt *= i;
			i ++;
		}
		System.out.println(n + "! = " + gt);
		
		//2. Tinh tong cua n so dau tien
		int tong = 0;
		i = 0;
		do {
			tong += i;
			i ++;
		} while(i <= n);
		System.out.println("Tong cua " + n + " so dau tien: " + tong);
		
		//3. Tong tong cua n so chan dau tien
		tong = 0;
		i = 0;
		int m = n*2;
		for(i = 0; i < m ; i += 2) {
			tong += i;
		}
		System.out.println("Tong cua " + n + " so chan dau tien: " + tong);
		
		//4. In tuan tu phan tu trong mang
		int[] inArray = new int[] {12, 22, 24, 45, 56, 76};
		i = 0;
		for (int x : inArray) {
			System.out.print(x);
			if(i++ < inArray.length - 1)System.out.print(",");
		}
		
		System.out.println("\n");
		//5. In ra cac so tu 0 den n, tru so 3
		for(i = 0; i <= n; i ++) {
			if(i == 3) continue;
			System.out.println(i);
		}
		
		//6. Nhap mang tu ban phim
		inArray = new int[n];

		
		//7. IN cac phan tu trong mang, su dung index
		for(i = 0; i < inArray.length; i ++) {
			System.out.println("inArray[" + i + "] = " + inArray[ i ]);
		}
		
		System.out.println(">>>>>> Done");
		
	}
}
