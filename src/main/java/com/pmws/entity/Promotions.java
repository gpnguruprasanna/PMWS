package com.pmws.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "promotions")
public class Promotions {
	private Long promotionId;
	private Long productId;
	private Date startDate;
	private Date endDate;
	private String reviewStatus;
	private Double discount;
	private String status;

	public Promotions(Long promotionId,Long productId,Date startDate,Date endDate,String reviewStatus,Double discount,String status) {
		this.promotionId=promotionId;
		this.productId=productId;
		this.startDate=startDate;
		this.endDate=endDate;
		this.reviewStatus=reviewStatus;
		this.discount=discount;
		this.status=status;
	}

	public	Promotions(){

	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "promotion_Id", unique = true, nullable = false)
	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	@Column(name="product_Id",unique=true,nullable=false)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	@Column(name="startDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name="endDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name="review_status")
	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Column(name="discount")
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
