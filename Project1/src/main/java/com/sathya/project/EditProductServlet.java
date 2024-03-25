package com.sathya.project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId=request.getParameter("proId");
		ProductDao productDao= new ProductDao();
		Product existingproduct=null;
		
		try 
		{
			existingproduct = productDao.findById(proId);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		 
		 //sending the product object to edit-form 
		 request.setAttribute("existingproduct", existingproduct);
		 
		 //forward the request to edit form
		 RequestDispatcher dispatcher=request.getRequestDispatcher("Editform.jsp");
		 dispatcher.forward(request, response);
	}

}
