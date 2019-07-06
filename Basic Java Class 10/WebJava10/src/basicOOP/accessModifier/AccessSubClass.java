package basicOOP.accessModifier;

import basicOOP.accessModifier.accessControlKey.AccessControlExample;

public class AccessSubClass extends AccessControlExample {
	public void testAccess() {
		int a = this.proAt;
		a = this.pubAt;
		this.proFunction();
		this.pubFunction();
		
		AccessControlExample ace = new AccessControlExample();
		a = ace.pubAt;
		ace.pubFunction();
	}
	
	public static void main(String[] args) {
		AccessSubClass accessClass = new AccessSubClass();
		accessClass.testAccess();
	}
}
