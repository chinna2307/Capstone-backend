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
	
	
}
