package com.pmws.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements java.io.Serializable{
	private Long productId;
	private String productName;
	private Double price;
	private String status;
	private Date createdDate;
	private String category;
	private Integer quantity;
	
	public Products() {
	}
	
	Products(Long productId,String productName,Double price,String status,Date createdDate,String category,Integer quantity){
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.status=status;
		this.createdDate=createdDate;
		this.category=category;
		this.quantity=quantity;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Column(name="product_name",unique=true,nullable=false)
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name="price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Column(name="status",unique=true,nullable=false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
