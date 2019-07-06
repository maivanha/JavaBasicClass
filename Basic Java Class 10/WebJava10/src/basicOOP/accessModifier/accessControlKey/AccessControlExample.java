package basicOOP.accessModifier.accessControlKey;

public class AccessControlExample {
	private int priAt;
	int defAt;
	protected int proAt;
	public int pubAt;
	
	private void priFunction() {
		System.out.println("Private function");
	}
	
	void defFunction() {
		System.out.println("Default function");
	}
	
	protected void proFunction() {
		System.out.println("Protected function");
	}
	
	public void pubFunction() {
		System.out.println("Public function");
	}
	
}
