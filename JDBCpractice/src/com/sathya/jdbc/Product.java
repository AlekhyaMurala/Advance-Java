package com.sathya.jdbc;

public class Product 
{
	int proId;
	String proName;
	float proPrice;
	
	public Product(int proId, String proName, float proPrice) 
	{
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	
	public Product() 
	{
		super();
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public float getProPrice() {
		return proPrice;
	}

	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
	}
	
	
	
}

