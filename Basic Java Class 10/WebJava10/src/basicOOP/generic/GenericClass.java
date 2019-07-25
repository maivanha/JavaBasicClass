package basicOOP.generic;

public class GenericClass <T> {
	private T t;

	public T getValue() {
		return t;
	}

	public void setValue(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		GenericClass<String> gString = new GenericClass<String>();
		gString.setValue("Hello World");
		System.out.println(gString.getValue());
		
		// Cac wrapper class
		GenericClass<Integer> gInteger = new GenericClass<Integer>();
		String intValue = "100000";
		int i = Integer.parseInt(intValue);
		/*
		 * Integer wrapperInt = new Integer(i); Integer wInt = i;
		 */
		gInteger.setValue(i);
		System.out.println(gInteger.getValue());
	}
}
