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
@Table(name = "checkout")
public class GetOrderedProducts {
	@Id
	@Column(name = "CHECKOUTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int checkoutID;
	@Column(name = "MATERIALID")
	private int materialID;
	@Column(name = "USERID")
	private int userID;
	@Column(name = "ORDERDATE")
	private String orderDate;
	@OneToOne
	@JoinColumn(name="materialID", nullable=true)
	private AddProduct addProduct ;
	public GetOrderedProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetOrderedProducts(int checkoutID, int materialID, int userID, String orderDate, AddProduct addProduct) {
		super();
		this.checkoutID = checkoutID;
		this.materialID = materialID;
		this.userID = userID;
		this.orderDate = orderDate;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getCheckoutID() {
		return checkoutID;
	}
	public AddProduct getAddProduct() {
		return addProduct;
	}
	
}
