package javaCore.basic;

import java.util.Scanner;

public class StringExample {
	String inputString = "abbbccddccee";

	//	Đảo chuỗi
	public void daoChuoi() {
		String str = inputString;

		char[] strArr = str.toCharArray();
		char[] newArr = strArr.clone();
		int j = 0;
		for (int i = strArr.length - 1; i >= 0; i --) {
			newArr[j ++] = strArr[i];
		};

		System.out.println(new String(newArr));
	}

	// Nguyen Minh Duc 
	public void daoChuoi2() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Nhập chuỗi: ");
			String str = scanner.nextLine();
			String reversedStr = new StringBuilder(str).reverse().toString();
			System.out.println("Chuỗi sau khi đảo: " + reversedStr);
		}
	}

	// Lấy ra chỉ số cuối cùng của chuỗi "abc" trong chuỗi hiện tại
	public void LayChiSOCuoiCuaChuoi() {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		// Nhập chuỗi
		System.out.println("Nhập một chuỗi: "); // 
		inputString = sc.nextLine();
		// Hiển thị chuỗi đã nhập
		System.out.println("Chuỗi bạn đã nhập: "+inputString);
		// Tìm chuỗi abc
		String searchString = "abc"; 
		// Lấy chỉ số cuối cùng của chuỗi "abc"
		int lastIndex = inputString.lastIndexOf(searchString);
		// In ra kết quả
		if (lastIndex != -1) {  
			System.out.println("Chỉ số cuối cùng của chuỗi '" + searchString + "' là: " + lastIndex);
		} else {
			System.out.println("Chuỗi '" + searchString + "' không được tìm thấy trong chuỗi hiện tại.");
		}
		sc.close();
	}

	//Đếm tổng số nguyên âm và phụ âm trong chuỗi
	public void DemSoNguyenAmPhuAm() {
		String input = inputString;

		int vowelCount = 0, consonantCount = 0;

		// Xác định nguyên âm và phụ âm
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) { 
				if ("ueoai".indexOf(c) != -1) {
					vowelCount++;
				} else {
					consonantCount++;
				}
			}
		}

		// Hiển thị kết quả
		System.out.println("Số nguyên âm: " + vowelCount);
		System.out.println("Số phụ âm: " + consonantCount);
	}


}
