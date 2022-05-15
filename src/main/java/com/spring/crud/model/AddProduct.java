package com.spring.crud.model;

import javax.persistence.*;


@Entity
@Table(name = "material")
public class AddProduct {
	@Id
	@Column(name = "MATERIALID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialID;
	@Column(name = "CATEGORYID")
	private int categoryID;
	@Column(name = "MATERIALNAME")
	private String materialName;
	@Column(name = "PRICE")
	private float price;
	@Column(name = "IMAGEURL")
	private String imageURL;
	@Column(name = "DESCRIPTION")
	private String description;
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddProduct(int categoryID, String materialName, float price, String imageURL,
			String description) {
		super();
		this.categoryID = categoryID;
		this.materialName = materialName;
		this.price = price;
		this.imageURL = imageURL;
		this.description = description;
	}

	public int getMaterialID() {
		return materialID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Materials [categoryID=" + categoryID + ", materialName=" + materialName + ", price=" + price + "]";
	}

}
