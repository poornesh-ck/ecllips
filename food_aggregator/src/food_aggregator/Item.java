package food_aggregator;

public class Item {

	private String name;
	private Double price;
	private String type;
	
	public Item() {
		
	}
	
	public Item(String name, Double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	public static Item createItems(String item) {
		String[] list = item.split(",");
		Double price = new Double(list[1]);
		return new Item(list[0],price,list[2]);
		
	}

	@Override
	public String toString() {
		return "Item ->name=" + name + ", price=" + price + ", type=" + type  ;
	}
	
	

}
