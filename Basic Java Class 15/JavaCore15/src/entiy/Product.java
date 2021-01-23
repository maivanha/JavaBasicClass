package entiy;

public class Product {
	private int id;
	private String productCode;
	private String prodcutName;
	private String description;
	private int price;		// Giá bán ra (thay đổi theo thời gian)
	private int cost;		// chi phí: giá nhập vào, các chi phí khác phát sinh
	private int categoryId;
	protected String color;
	
	public static int intancedCount = 0;
	
	public Product() {
		categoryId = 1;
		intancedCount ++;
	};
	
	public Product(int id, String productCode, 
			String prodcutName, int price, 
			int cost, int categoryId) {
		this.id = id;
		this.productCode = productCode;
		this.prodcutName = prodcutName;
		this.price = price;
		this.cost = cost;
		this.categoryId = categoryId;
		
		intancedCount++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Thông tin sản phẩm").append("\n");
		sb.append("\tid: ").append(this.getId()).append("\n");
		sb.append("\tproductCode:").append(this.getProductCode()).append("\n");
		sb.append("\tproductName:").append(this.getProdcutName()).append("\n");
		sb.append("\tcost:").append(this.getCost()).append("\n");
		sb.append("\tprice:").append(this.getPrice()).append("\n");
		sb.append("\tintancedCount:").append(intancedCount).append("\n");
		sb.append("\tColor:").append(color).append("\n");
		return sb.toString();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProdcutName() {
		return prodcutName;
	}

	public void setProdcutName(String prodcutName) {
		this.prodcutName = prodcutName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
