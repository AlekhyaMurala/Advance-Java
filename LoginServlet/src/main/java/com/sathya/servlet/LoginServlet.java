package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data
		
		String username=request.getParameter("User Name");
		String password=request.getParameter("Password");
		
		//process the data
		String status;
		if(username.equals("sathya")&& password.equals("Sathya@123"))
		{
			status="Login successfull";
		}
		else
		{
			status="Login failed";
		}
		
		//render the response
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Login status:</h1>"+status);
		writer.println("</html>");
		
	}

}
