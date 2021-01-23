package basicConcept;

import java.util.StringTokenizer;

public class Bai03StringBufferBuilder {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" ").append("Wold").append(" ");
		sb.append("\n");
		sb.append("My name is");
		sb.append(" Ha");
		
		System.out.println(sb);
		System.out.println("Tach cac token:");
		StringTokenizer st = new StringTokenizer(sb.toString(), "\n");
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}
}
