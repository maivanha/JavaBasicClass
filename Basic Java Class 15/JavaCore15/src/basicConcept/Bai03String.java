package basicConcept;

import java.util.Scanner;

public class Bai03String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// cho nguoi dung nhap
		String str = sc.nextLine();
		
		// in ra chieu dai cua chuoi:
		System.out.println("chieu dai cua chuoi: " + str.length());
		
		// lay ra ky tu o vi tri thu 3
		char c = str.charAt(3);
		System.out.println("Ky tu o vi tri thu 3: " + c);
		
		// lay ra vi tri chu a dau tien trong chuoi
		int index = str.indexOf('a');
		System.out.println("Vi tri cua chu a dau tien: " + index);
		
		// thay ky tu a bang ky tu b
		str = str.replace('a', 'b');
		System.out.println("Chuoi moi: " + str);
		
		// dem tong so ky tu c
		int count = 0;
		for(char ch : str.toCharArray()) {
			if(ch == 'c') count ++;
		}
		System.out.println("Tong so ky tu c trong " + str + " la: " + count);
		
		count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'c') count ++;
		}
		System.out.println("Tong so ky tu c trong " + str + " la: " + count);
		
		// xoa khoang trang trong chuoi
		String str2 = str.trim();
		System.out.println("Chuoi da xoa khoang trang o truoc va sau: " + str2);
		
		// chuyen sang chu vie hoa
		str2 = str.toUpperCase().substring(5);
		
		// dem so nguyen am, phu am:
		String nguyenAm = "aeiou";
		count = 0;
		for(char ch : str.toCharArray()) {
			if(nguyenAm.indexOf(ch) >= 0) count ++;
		}
		System.out.println("So nguye am: " + count);
		
		
		
	}
}
