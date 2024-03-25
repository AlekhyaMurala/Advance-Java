package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;

public class DatabaseClient {

	public static void main(String[] args) throws SQLException  {
		
		EmployeeDao employeedao=new EmployeeDao();
		//inserting the data into database
		/*int res1=employeedao.save(new Employee(1001,"ABC",78990));
		System.out.println("Data inserted Successfully"+res1);
		
		int res2=employeedao.save(new Employee(1002,"DEF",78988));
		System.out.println("Data inserted Successfully"+res2);*/
		
		//to find the employee details using empId
		/*Employee emp=employeedao.findById(1001);
		System.out.println(emp);*/
		
		
		//to delete the employee details using empId
		/*int deletecount=employeedao.deleteById(1001);
		if(deletecount==1)
		{
			System.out.println("Deletion Successfull");
		}
		else
		{
			System.out.println("Deletion Failed");
		}*/
		
		
		//to delete the employee salary with condition using empSalary
		/*int deletecount=employeedao.deleteBySalary(70000);
		System.out.println(deletecount+" records deleted");*/
		
		
		/*List<Employee> emp1=employeedao.findAll();
		for(Employee emp2:emp1)
			System.out.println(emp2);*/
		
		int count=employeedao.updateSalary(10000, 5000);
		System.out.println(count+"rows Updated");
		
	}

}
