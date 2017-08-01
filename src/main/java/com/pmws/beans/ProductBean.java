package com.pmws.beans;
/**
 *@author guruprasanna n
 */
public class ProductBean extends ResponseBean<ProductBean>{
	private Long productId;
	private String productName;
	private Double price;
	private String status;
	private String createdDate;
	private int quantity;
	private String category;
	
	public Long getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
