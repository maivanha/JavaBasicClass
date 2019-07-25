package basicOOP.generic;

public class GenericMethod {
	public <T> T display(T t) {
		return t;
	}
	
	public <E> void printArray(E[] eArray) {
		for(E e : eArray) {
			System.out.printf("%s", e);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		GenericMethod gM = new GenericMethod();
		System.out.println(gM.display(1000));
		System.out.println(gM.display("Hello World"));
		System.out.println(gM.display(7.5));
		
		String[] sArray = new String[] {"Hello", "World", "My", "Name", "is", "..."};
		Integer[] iArray = new Integer[] {1, 2, 3, 5 , 8};
		
		gM.printArray(sArray);
		gM.printArray(iArray);
	}
}
