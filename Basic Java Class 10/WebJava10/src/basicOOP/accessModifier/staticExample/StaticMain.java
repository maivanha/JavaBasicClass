package basicOOP.accessModifier.staticExample;

public class StaticMain {
	public static void main(String[] args) {
		System.out.println(StaticExample.CONNECTION_STRING);
		StaticExample.getConnection();
		
		StaticExample se1 = new StaticExample();
		StaticExample se2 = new StaticExample();
		StaticExample se3 = new StaticExample();
		
		StringBuilder sb = new StringBuilder();
		sb.append("se1: ").append(se1.CONNECTION_STRING).append("\n");
		sb.append("se2: ").append(se2.CONNECTION_STRING).append("\n");
		sb.append("se3: ").append(se3.CONNECTION_STRING).append("\n");
		
		System.out.println(sb.toString());
		
		// Thay đổi giá trị của static field từ 1 object:
		se2.CONNECTION_STRING = "Chuoi ket noi moi";
		
		sb = new StringBuilder();
		sb.append("se1: ").append(se1.CONNECTION_STRING).append("\n");
		sb.append("se2: ").append(se2.CONNECTION_STRING).append("\n");
		sb.append("se3: ").append(se3.CONNECTION_STRING).append("\n");
		System.out.println(sb.toString());
		
	}
}
