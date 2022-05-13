package com.spring.crud.model;
import javax.persistence.*;
@Entity
@Table(name = "userdetails")
public class UserDetails {
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "roleID")
	private int roleID;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String email, String name,int roleID, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.roleID = roleID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", email=" + email + ", roleID=" + roleID + "]";
	}
	
	

}
