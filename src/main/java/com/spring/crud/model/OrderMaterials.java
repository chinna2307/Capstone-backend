package com.spring.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderMaterials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderMaterialsID;
	private int materialID;
	private int userID;
//	private int or_fk;
//	
//	public int getOr_fk() {
//		return or_fk;
//	}
//	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getMaterialID() {
		return materialID;
	}
	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}
	
	public int getOrderMaterialsID() {
		return orderMaterialsID;
	}
}
