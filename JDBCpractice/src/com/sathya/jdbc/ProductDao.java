package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Table creation
public class ProductDao 
{
	public void createProductTable() throws SQLException, ClassNotFoundException 
	{
		try (Connection connection = DbConnection.createConnection();
				Statement statement = connection.createStatement()) 
		{
			String query = "create table product(proId number,proName varchar(20),proPrice number(8,2))";
			statement.executeUpdate(query);
			System.out.println("Table created successfully.....");

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

	// Inserting elements in the table

	public int saveProduct(Product prod) throws ClassNotFoundException, SQLException 
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		int count = 0;

		try 
		{
			connection = DbConnection.createConnection();
			preparedstatement = connection.prepareStatement("insert into product values(?,?,?)");

			preparedstatement.setInt(1, prod.getProId());
			preparedstatement.setString(2, prod.getProName());
			preparedstatement.setDouble(3, prod.getProPrice());

			count = preparedstatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (connection != null)
				connection.close();
			if (preparedstatement != null)
				preparedstatement.close();
		}
		return count;

	}

	// Getting the record by using proId

	public Product getProductById(int proId) 
	{
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		Product product = new Product();

		try 
		{

			connection = DbConnection.createConnection();
			preparedstatement = connection.prepareStatement("select * from product where proId=?");

			preparedstatement.setInt(1, proId);

			ResultSet resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) 
			{
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getFloat(3));

			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		return product;
	}

	// get all the products details

	public List<Product> getAllProducts()
	{
		List<Product> list=new ArrayList<>();
		try(Connection connection=DbConnection.createConnection();
				Statement statement=connection.createStatement())
		{	
			String query="select * from product";
			ResultSet resultSet= statement.executeQuery(query);
			
			while(resultSet.next())
			{
				Product product=new Product();
				product.setProId(resultSet.getInt(1));
				product.setProName(resultSet.getString(2));
				product.setProPrice(resultSet.getFloat(3));
				
				list.add(product);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	// update the price of a product

	public int updateByPrice(float PriceRange,int IncValue)
	{
		int count=0;
		
		try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("update product set proPrice=proPrice+? where proPrice>?"))
		{
			preparedstatement.setFloat(1, IncValue);
			preparedstatement.setFloat(2, PriceRange);
			
			count=preparedstatement.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//delete the record by using id
	public int deleteById(int proId) 
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("delete from product where proId=?"))
		{
			preparedstatement.setInt(1,proId);
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//delete the record by using product price
	public int deleteByPrice(int proPrice) 
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("delete from product where proPrice>=?"))
		{
			preparedstatement.setInt(1,proPrice);
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//drop the table
	
	public void dropTable()  
	{
		try (Connection connection = DbConnection.createConnection();
				Statement statement = connection.createStatement()) 
		{
			String query = "drop table product";
			statement.executeUpdate(query);
			System.out.println("Table deleted successfully.....");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	
}
