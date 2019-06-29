package basicOOP.arrayAndString;

public class StringExample {
	public static void main(String[] args) {
		String str = "abc";
		str = new String();
		str = new String("Hello World");
		
		System.out.println(str);
		
		StringBuilder sb = new StringBuilder("select * from ");
		sb.append(str);
		sb.append(" where username = ");
		sb.append("tendangnhap").append(" and password = ").append("mat khau");
		
		System.out.println(sb.toString());
	}
}
