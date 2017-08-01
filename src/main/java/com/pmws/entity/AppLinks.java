package com.pmws.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_links")
public class AppLinks {

	private Long linkId;
	private String linkName;
	private String url;
	private String status;	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "link_id", unique = true, nullable = false)
	public Long getLinkId() {
		return linkId;
	}
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	
	@Column(name="link_name",unique=true,nullable=false)
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	@Column(name="url",unique=true,nullable=false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="status",unique=true,nullable=false,length=1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
