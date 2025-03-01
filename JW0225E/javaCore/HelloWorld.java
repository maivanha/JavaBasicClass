package javaCore;

import java.io.IOException;
import java.util.Scanner;

/**
 * HelloWorld class</br>
 * Đây là Class đầu tiên của lớp để làm quen với Java.</br>
 */
public class HelloWorld {
	
	// Đây là hàm Main.
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World !!!");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Your name is:");
		String name = sc.next();
		
		System.out.print("Hello \"" + name + "\", welcome to Java World !!!");
		/*
		 * int ch; System.out.println("Nhap vap ky tu:"); while( (ch = System.in.read())
		 * != '\n') { System.out.println((char) ch); }
		 */
		// 15 --> | | | |  --> 1 1 1 1 --> 1*2^3 + 1*2^2 +  1*2^1 + 1*2^0 --> 8 + 4 + 2 + 1
		// 13 --> | | | | --> 1 1 0 1 --> 1*2^3 + 1*2^2 + 0*2^1 + 1*2^0 --> 8 + 4 + 0 + 1
		// AND --> x --> 0 x a = 0;
		// OR --> + --> 1 + a = 1 
		int a = 5;
		int b = 2;
		int r = 0;
		
		r = a / b;
		
		double c = 5;
		System.out.println("a / b = " + (a / b) );
		System.out.println("a % b = " + (a / b) );
		System.out.println("c / b = " + (c / b) );
		
		System.out.println("+a = " + +a);
		System.out.println("-a = " + -a);
		
		System.out.println("++a = " + ++a);
		System.out.println("--a = " + --a);
		
		// a = 5
		System.out.println("a++ = " + a++);
		System.out.println("a-- = " + a--);
		System.out.println(a);
		
//		a = a + b;
//		a += b;
		
		String result = (a / 2 == 0)? "so chan" : "so le";
		System.out.println(result);
		
	}
}
