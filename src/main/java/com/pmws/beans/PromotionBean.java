package com.pmws.beans;
/**
 *@author guruprasanna n
 */
import java.util.ArrayList;
import java.util.List;

public class PromotionBean extends ResponseBean<PromotionBean>{
	private long promotionId;
	private long productId;
	private String productName;
	private double dicount;
	private String startDate;
	private String endDate;
	private String reviewStatus;
	private String status;
	private List<String> listOfReviewStatus=new ArrayList<String>();
	
	
	public long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(long promotionId) {
		this.promotionId = promotionId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getDicount() {
		return dicount;
	}
	public void setDicount(double dicount) {
		this.dicount = dicount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getListOfReviewStatus() {
		return listOfReviewStatus;
	}
	public void setListOfReviewStatus(List<String> listOfReviewStatus) {
		this.listOfReviewStatus = listOfReviewStatus;
	}
}
