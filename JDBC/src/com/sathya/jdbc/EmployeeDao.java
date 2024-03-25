package com.sathya.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDao 
{
	public int save(Employee emp) throws SQLException
	{
		//System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getEmpSalary());
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		int count=0;
		try
		{
			//get the connection
			connection=DbConnection.createConnection();
			//create the prepared statements
			preparedstatement =connection.prepareStatement("insert into emp values(?,?,?)");
			
			//adding data into parameters
			preparedstatement.setInt(1,emp.getEmpId());
			preparedstatement.setString(2,emp.getEmpName());
			preparedstatement.setDouble(3,emp.getEmpSalary());
			
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
				connection.close();
			if(preparedstatement!=null)
				preparedstatement.close();
		}
		return count;
	}
	
	//find by id
	
	public Employee findById(int empId) throws SQLException
	{
		Employee employee=null;
		
		try(Connection connection=DbConnection.createConnection();

			PreparedStatement preparedstatement =connection.prepareStatement("select * from emp where empId=?"))
		{
			//set the data
			preparedstatement.setInt(1,empId);
			
			//execute the query
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				employee=new Employee();
				employee.setEmpId(resultset.getInt(1));
				employee.setEmpName(resultset.getString(2));
				employee.setEmpSalary(resultset.getDouble(3));
				
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	
	//find by salary
	
	public int deleteById(int empId) throws SQLException
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("delete from emp where empId=?"))
		{
			preparedstatement.setInt(1,empId);
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//delete the employee using empsalary
	public int deleteBySalary(int empSalary) throws SQLException
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("delete from emp where empSalary>=?"))
		{
			preparedstatement.setInt(1,empSalary);
			count=preparedstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	//find all records
	public List<Employee> findAll()
	{
		List<Employee> emps=new ArrayList<Employee>();
		
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement())
		{
			ResultSet resultset=statement.executeQuery("Select * from emp");
			
			while(resultset.next())
			{
				Employee employee=new Employee();
				employee.setEmpId(resultset.getInt(1));
				employee.setEmpName(resultset.getString(2));
				employee.setEmpSalary(resultset.getDouble(3));
				
				emps.add(employee);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return emps;
	}
		
		//update the salary
		
		public int updateSalary(double currentSalary, double IncSalary)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("update emp set empSalary=empSalary+? where empSalary>?"))			
			{
				preparedstatement.setDouble(1, currentSalary);
				preparedstatement.setDouble(2, IncSalary);
				count=preparedstatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
	
	
}
