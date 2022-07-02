package model;

public class Product { 
	
	private String productName; 
	private Integer quantity; 
	private String description;
	
	public Product() {
		super();
	} 
	
	
	@Override
	public String toString() {
		return "{productName:"+'"' + productName +'"'+ ", quantity:" + quantity + ", descriptio:" + '"'+description +'"'+ "}";
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Product(String productName, Integer quantity, String description) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.description = description;
	}


	public String getProductName() {
		return productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	} 
	
	

}
