package com.spring.crud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	@Column(name = "orderDate")
	private String orderDate;
	@Column(name = "userID")
	private int userID;
	@Column(name = "price")
	private float price;
	@Column(name = "ADRESS")
	private String adress;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "PINCODE")
	private String pincode;
	@Column(name = "STATE")
	private String state;
	@Column(name = "CNAME")
	private String cName;
	@Column(name = "CNUM")
	private String cNum;
	@Column(name = "CVC")
	private int cvc;
	@Column(name = "CEXP")
	private String cExp;


	@OneToMany(targetEntity = OrderMaterials.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "or_fk", referencedColumnName = "orderID")
	private List<OrderMaterials> orderMaterials;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<OrderMaterials> getOrderMaterials() {
		return orderMaterials;
	}
	public void setOrderMaterials(List<OrderMaterials> orderMaterials) {
		this.orderMaterials = orderMaterials;
	}
	public int getOrderID() {
		return orderID;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getcExp() {
		return cExp;
	}
	public void setcExp(String cExp) {
		this.cExp = cExp;
	}
	
	
}
