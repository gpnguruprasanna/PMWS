package com.pmws.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class Users {
	private Long userId;
	private String userName;
	private String passWord;
	private String status;
	private String roles;
	public Users() {
	}
	public Users(Long userId,String userName,String passWord,String status,String roles) {
		this.userId=userId;
		this.userName=userName;
		this.passWord=passWord;
		this.status=status;
		this.roles=roles;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name="user_name",unique=true,nullable=false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="user_password",unique=true,nullable=false)
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name="status",unique=true,nullable=false,length=1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="roles",unique=true,nullable=false)
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

}
