package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//get the data
				String first=request.getParameter("First Name");
				String middle=request.getParameter("Middlename");
				String last=request.getParameter("Lastname");

				
				//process the data
				String full;
				full=first+" "+middle+" "+last;
				
				//render the response
				PrintWriter writer=response.getWriter();
				response.setContentType("text/html");
				writer.println("<html>");
				writer.println("<h3>Full Name</h3>"+full);
				writer.println("</html>");
	}

}
