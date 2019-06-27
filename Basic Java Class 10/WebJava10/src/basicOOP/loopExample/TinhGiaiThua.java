package basicOOP.loopExample;

public class TinhGiaiThua {
	public static void main(String[] args) {
		int num=5,fact=1;
			while (num>=1) {
				fact*=num;
				num--;
			}
		System.out.println(fact);
	}
}
