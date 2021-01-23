package service.serviceImpl;

import entiy.Product;

public class ProductServiceImpl {
	public static void main(String[] args) {
		Product pro = new Product();
		pro.setId(1);
		pro.setColor("RED");
		
		System.out.println(pro);
	}
}
