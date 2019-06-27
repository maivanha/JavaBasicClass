package basicOOP.loopExample;

import java.util.Scanner;

public class TongCacSoChan {
	public static void main(String[] args) {
		int n,s=0,i,count=0;
		System.out.println("nhap n:");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(i = 0; count < n; i++) {
			if(i % 2 == 0) {
				s += i;
				count ++;
			}
		}
		System.out.println("tong " + n + " so chan dau tien la =" + s);
	}
}
