package com.worldpay.challenge.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private String id;
	private String name;
	private String category;
	private String productDescription;
	private float unitSalePrice;
	private int numberOfUnits;

	public Product() {

	}

	public Product(String id, String name, String category, String productDescription, float salePrice, int units) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.productDescription = productDescription;
		this.unitSalePrice = salePrice;
		this.numberOfUnits = units;
	}

	public String getCategory() {
		return category;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public float getUnitSalePrice() {
		return unitSalePrice;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setUnitSalePrice(float unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}

}