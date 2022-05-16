package com.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "addtocart")
public class AddToCart {
	@Id
	@Column(name = "CARTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartID;
	@Column(name = "MATERIALID")
	private int materialID;
	@Column(name = "USERID")
	private int userID;
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToCart(int cartID, int materialID, int userID) {
		super();
		this.cartID = cartID;
		this.materialID = materialID;
		this.userID = userID;
	}
	public int getMaterialID() {
		return materialID;
	}
	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCartID() {
		return cartID;
	}
	

}
