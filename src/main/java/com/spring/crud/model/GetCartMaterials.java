package com.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "addtocart")
public class GetCartMaterials {
	@Id
	@Column(name = "CARTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartID;
	@Column(name = "MATERIALID")
	private int materialID;
	@Column(name = "USERID")
	private int userID;
	@OneToOne
	@JoinColumn(name="materialID", nullable=true)
	private AddProduct addProduct ;
	public GetCartMaterials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetCartMaterials(int cartID, int materialID, int userID, AddProduct addProduct) {
		super();
		this.cartID = cartID;
		this.materialID = materialID;
		this.userID = userID;
		this.addProduct = addProduct;
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
	public AddProduct getAddProduct() {
		return addProduct;
	}
	
}
