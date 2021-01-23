import entiy.Category;
import entiy.Product;
import service.serviceImpl.ProductServiceImpl;

public class MainClass {
	public static void main(String[] args) {
		ProductServiceImpl psi = new ProductServiceImpl();
		
		entiy.ProductServiceImpl ePSI = new entiy.ProductServiceImpl(); 
		
		Category mobilePhone = new Category();
		
		Product nokia = new Product();
		nokia.setId(1);
		nokia.setProdcutName("Nokia 100i");
		nokia.setCost(1000000);
		nokia.setPrice(1500000);
		nokia.setDescription("Điện thoại cổ, dòng Nokia 100i");
		nokia.setColor("Black");
		
		Product iphone = new Product(2, "iPhone6s", 
				"iPhone 6s", 10000000, 9200000, 1);
		iphone.setColor("Silver");
		
		Product lg = new Product(2, "LG01", 
				"LG 1", 9500000, 7000000, 1);
		lg.setColor("WHite");
		
		/*
		 * System.out.println(nokia); System.out.println("\tcolor:" + nokia.color);
		 * 
		 * System.out.println(iphone); System.out.println("\tcolor:" + iphone.color);
		 * 
		 * System.out.println(lg); System.out.println("\tcolor:" + lg.color);
		 */
		
		lg.intancedCount = 4;
		Product.intancedCount = 5;		
		
		Product proArray[] = new Product[3];
		proArray[0] = iphone;
		proArray[1] = nokia;
		proArray[2] = lg;
		for(Product pr : proArray) {
			System.out.print(pr);
			System.out.println("\t" + pr.getColor());
		}
		
		System.out.println("Truyền tham trị:");
		int price = iphone.getPrice();
		int cost = iphone.getCost();
		System.out.println("\tprice: " + price);
		calculator(price, 5, cost);
		System.out.println("\tprice: " + price);
		
		System.out.println("Truyền tham chiếu:");
		System.out.println("\t" + iphone.getPrice());
		calculator(iphone, 10);
		System.out.println("\t" + iphone.getPrice());
		
		MainClass mc = new MainClass();
		mc.sayHello();
	}
	
	public void sayHello() {
		System.out.println("Hello World!");
	}
	
	public static void calculator(int price, int number, int cost) {
		int loiNhuan = price - cost;
		loiNhuan *= number;
		System.out.println("Lợi nhuận: " + loiNhuan);
		if(loiNhuan/ cost < 0.1)
			price *= 1.2;
		
	}
	
	public static void calculator(Product pr, int number) {
		int loiNhuan = pr.getPrice() - pr.getCost();
		loiNhuan *= number;
		System.out.println("Lợi nhuận: " + loiNhuan);
		if(loiNhuan/ pr.getCost() < 0.1)
			pr.setPrice((int)(pr.getPrice() * 1.2));
		
	}
}
