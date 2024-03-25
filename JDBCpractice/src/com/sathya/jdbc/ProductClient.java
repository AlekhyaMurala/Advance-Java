package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ProductDao productdao=new ProductDao();
		
		//productdao.createProductTable();		

		
		/*int ins1=productdao.saveProduct(new Product(11,"Mobile",12345));
		System.out.println("row inserted Successfully.."+ins1);
		
		int ins2=productdao.saveProduct(new Product(12,"Laptop",68892));
		System.out.println("row inserted Successfully.."+ins2);
		
		int ins3=productdao.saveProduct(new Product(13,"AC",98765));
		System.out.println("row inserted Successfully.."+ins3);*/
		
		/*Product product=productdao.getProductById(11);
		System.out.println(product);*/
		
		/*List<Product> list=productdao.getAllProducts();
		for(Product lists:list)
			System.out.println(lists);*/
		
		/*int update=productdao.updateByPrice(400,50);
		System.out.println(update + " Rows Updated Successfully");*/
		
		/*int count=productdao.deleteById(11);
		System.out.println(count+" rows deleted Successfully");*/
		
		/*int count=productdao.deleteByPrice(1000);
		System.out.println(count+ " rows deleted Successfully");*/
		
		productdao.dropTable();
		
	}

}
