package com.sathya.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/java")
public class HelloWorldServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");

		PrintWriter writer=response.getWriter();
		
		writer.println("<Html>");
		writer.println("<h1>Hello World Application</h1>");
		writer.println("<h2>This is Advance java class</h2>");
		writer.println("<h3>This is Ratan Sir class...</h3>");
		writer.println("</html>");

		
	}

}
