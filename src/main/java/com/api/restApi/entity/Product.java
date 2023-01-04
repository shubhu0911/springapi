package com.api.restApi.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private String productID;
	private String productName;
	private String productBrand;
	
	
	public Product() {}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductDetails(String productBrand) {
		this.productBrand = productBrand;
	}


	@Override
	public String toString() {
	return "Product [id=" + productID + ", product_name=" + productName + ", brand="+ productBrand + "]";
	}

}
	