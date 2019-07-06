package basicOOP.accessModifier.finalExample;

public final class FinalExample {
	final int a = 12;
	
	public void test() {
		//a = 15; 	// Không đc phép thay đổi giá trị của biến final
	}
}
