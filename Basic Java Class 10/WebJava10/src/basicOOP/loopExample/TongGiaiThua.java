package basicOOP.loopExample;

import java.util.Scanner;

public class TongGiaiThua {
	public static void main(String[] args) {

		System.out.print("Nhap n= ");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int GT = 1, S = 0;
		for (int i = 1; i <= n; i++) {
			GT *= i;
			S += GT;
		}
		System.out.println("Tong giai thua la S= " + S);
		GT = 1;
		S = 0;
		int i=1,j= 1;
		while ( i <= n)  {
			while (j <= i) {
				GT = GT * j;
				j++;
			} 
			S = S + GT;
			i++;
		}
		System.out.println("Giai thua la: " + S);
	}
}
