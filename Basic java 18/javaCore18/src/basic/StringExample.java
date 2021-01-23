package basic;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringExample {
	public static void main(String[] args) {
		String str = "    Hello World!    ";
		
		String str2 = "";
		
		StringBuilder sb = new StringBuilder();
		
		System.out.println(str);
		System.out.println("length: " + str.length());
		
		System.out.println("1. Chuyen String thanh char-array:");
		char[] cAra = str.toCharArray();
		for( char c : cAra) {
			System.out.println(c);
			if(c != ' ') {
				sb.append(c);
				str2 += c;
			}
		}
		
		str = str.trim();

		System.out.println("2. Duyet chuoi qua index:");
		for(int i = 0; i < str.length(); i ++) {
			System.out.println(str.charAt(i));
		}
		
		System.out.println("3. Cat chuoi thanh 01 String - Array");
		String[] strAr = str.split(" ");
		for(String s : strAr) {
			System.out.println(s);
		}
		
		System.out.println("4. StringBuilder:");
		System.out.println(sb.toString());
		System.out.println(str2);
		
		StringTokenizer st = new StringTokenizer(str, " ", true);
		while(st.hasMoreElements()) {
			System.out.println("tokenizer: " + st.nextElement());
		}
		
		System.out.println("6. String regex");
		Pattern p = Pattern.compile("[abc]at");
		if(p.matcher(str).matches()) 
			System.out.println(str + " thoa man cau truc ");
		else 
			System.out.println(str + " Khong thoa man cau truc ");
		
		if(p.matcher("aatf").matches()) 
			System.out.println("aat thoa man cau truc ");
		else 
			System.out.println("aat Khong thoa man cau truc ");
	}
}
