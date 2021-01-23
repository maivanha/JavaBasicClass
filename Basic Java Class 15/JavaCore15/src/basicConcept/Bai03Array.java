package basicConcept;

import java.util.Scanner;

public class Bai03Array {
	public static void main(String[] args) {
		int n = 3, m = 4;
		Scanner sc = new Scanner(System.in);
		
		//I. Mang mot chieu
		//1.1 Khoi tao mang mot chieu
		System.out.println("Nhap vao kich co cua mang 01 chieu: ");
		n = sc.nextInt();
		
		double dAr[] = new double[n];
		
		//1.2 Nhập giá trị cho mảng
		for(int i = 0; i < n; i ++) {
			System.out.print("dAr[" + i + "] = ");
			dAr[i] = sc.nextDouble();
		}
		
		//in mang da nhap
		System.out.println("Mang da nhap: ");
		for(int i = 0; i < n; i ++) {
			System.out.println("dAr[" + i + "] = " + dAr[i]);
		}
		
		//1.3 Tìm giá trị lớn nhất, nhỏ nhất trong mảng
		double max = dAr[0], min = dAr[0];
		for(int i = 0; i < n; i ++) {
			if(max < dAr[i]) max = dAr[i];
			else if(min > dAr[i]) min = dAr[i];
		}
		System.out.println("Max = " + max);
		System.out.println("Min = " + min);
		
		//1.4 Trung binh cong cac so chia het cho 5
		double sum = 0;
		double count = 0;
		for(int i = 0 ; i < n; i ++) {
			if((dAr[i] % 5) == 0) {
				sum += dAr[i];
				count ++;
			}
		}
		double avr = sum / count;
		System.out.println("Trung binh cong cac so "
				+ "chia het cho 5 = avr = " + avr);
		
		
		int ar[][] = new int [][] {
			{12, 23, 1, 15},
			{10, 5, 3, 16},
			{25, 1, 0, -3}
		};
		
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 4; j ++) {
				System.out.print(ar[i][j] + "\t");
			}
			System.out.println("");
		}
		
		
		int ar2[][] = new int[n][m];
		
	}
}
