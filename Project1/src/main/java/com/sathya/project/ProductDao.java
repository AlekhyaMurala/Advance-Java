package com.sathya.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {

	public int save(Product product) throws SQLException 
	{
		
		int saveResult=0;
		try(Connection connection=DBConnection.createConnection();
				PreparedStatement preparedStatement =connection.prepareStatement("insert into Product values(?,?,?,?,?,?,?,?,?,?)"))
		{
			
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBytes(8, product.getProImage());
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10, product.getProVideo());

			saveResult = preparedStatement.executeUpdate();
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return saveResult;
  	}
	
	public List<Product> findAll()
	{
			List<Product> list=new ArrayList<>();
			
			try(Connection connection=DBConnection.createConnection();
					Statement statement=connection.createStatement())
			{	
				String query="select * from Product";
				ResultSet resultSet= statement.executeQuery(query);
				
				while(resultSet.next())
				{
					Product product=new Product();
					product.setProId(resultSet.getString(1));
					product.setProName(resultSet.getString(2));
					product.setProPrice(resultSet.getDouble(3));
					product.setProBrand(resultSet.getString(4));
					product.setProMadeIn(resultSet.getString(5));
					product.setProMfgDate(resultSet.getDate(6));
					product.setProExpDate(resultSet.getDate(7));
					product.setProImage(resultSet.getBytes(8));
					product.setProAudio(resultSet.getBytes(9));
					product.setProVideo(resultSet.getBytes(10));
					
					list.add(product);
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return list;
		}
	
	public int deleteById(String proId)
	{
		int count=0;
		try(Connection connection=DBConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("delete from Product where proId=?"))
		{
			preparedstatement.setString(1,proId);
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	
	public Product findById(String proId) throws SQLException
	{
		Product product=null;
		
		try(Connection connection=DBConnection.createConnection();

			PreparedStatement preparedstatement =connection.prepareStatement("select * from Product where proId=?"))
		{
			//set the data
			preparedstatement.setString(1,proId);
			
			//execute the query
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				product=new Product();
				product.setProId(resultset.getString(1));
				product.setProName(resultset.getString(2));
				product.setProPrice(resultset.getDouble(3));
				product.setProBrand(resultset.getString(4));
				product.setProMadeIn(resultset.getString(5));
				product.setProMfgDate(resultset.getDate(6));
				product.setProExpDate(resultset.getDate(7));
				product.setProImage(resultset.getBytes(8));
				product.setProAudio(resultset.getBytes(9));
				product.setProVideo(resultset.getBytes(10));
				
				
				
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	public int updateById(Product product)
	{
		int saveResult=0;
		String sql="Update Product SET proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?,proImage=?,proAudio=?,proVideo=? WHERE proId=?";
		
		try(Connection connection=DBConnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement(sql))
		{
			preparedstatement.setString(1, product.getProName());
			preparedstatement.setDouble(2, product.getProPrice());
			preparedstatement.setString(3, product.getProBrand());
			preparedstatement.setString(4, product.getProMadeIn());
			preparedstatement.setDate(5, product.getProMfgDate());
			preparedstatement.setDate(6, product.getProExpDate());
			preparedstatement.setBytes(7, product.getProImage());
			preparedstatement.setBytes(8, product.getProAudio());
			preparedstatement.setBytes(9, product.getProVideo());
			
			
			
			preparedstatement.setString(10, product.getProId());

			

			saveResult=preparedstatement.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return saveResult;
	}
	
	
	
}

