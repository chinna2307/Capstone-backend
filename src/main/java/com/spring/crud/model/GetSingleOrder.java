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
@Table(name = "orderMaterials")
public class GetSingleOrder {
	@Id
	@Column(name = "orderMaterialsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderMaterialsId;
	@Column(name = "MATERIALID")
	private int materialID;
	@Column(name = "USERID")
	private int userID;
	@Column(name = "or_fk")
	private int or_fk;
	@OneToOne
	@JoinColumn(name="materialID", nullable=true)
	private AddProduct addProduct ;
	public GetSingleOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetSingleOrder(int orderMaterialsId, int materialID, int userID, int or_fk, AddProduct addProduct) {
		super();
		this.orderMaterialsId = orderMaterialsId;
		this.materialID = materialID;
		this.userID = userID;
		this.or_fk = or_fk;
		this.addProduct = addProduct;
	}
	public int getCheckoutID() {
		return orderMaterialsId;
	}
	public int getMaterialID() {
		return materialID;
	}
	public int getUserID() {
		return userID;
	}
	public int getOr_fk() {
		return or_fk;
	}
	public AddProduct getAddProduct() {
		return addProduct;
	}
	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setOr_fk(int or_fk) {
		this.or_fk = or_fk;
	}
	public void setAddProduct(AddProduct addProduct) {
		this.addProduct = addProduct;
	}
	
}
