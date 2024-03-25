package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.get the data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		Long mobile=Long.parseLong(request.getParameter("phonenumber"));
		String DOB=request.getParameter("dob");
		String Gender=request.getParameter("gender");
		String[] qual=request.getParameterValues("qualification");
		String country=request.getParameter("country");
		String[] lang=request.getParameterValues("language");
		String text=request.getParameter("comments");
		
		//2.Process the data
		
		String q=String.join(",", qual);
		String l=String.join("-", lang);
		
		//3.Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h2> Registration Details </h2>");
		writer.println("Your Name: "+username);
		writer.println("<br><br>");
		
		writer.println("Your Password: "+password);
		writer.println("<br><br>");

		writer.println("Email: "+email);
		writer.println("<br><br>");

		writer.println("Your Mobile: "+mobile);
		writer.println("<br><br>");

		writer.println("Your DOB: "+DOB);
		writer.println("<br><br>");

		writer.println("Gender: "+Gender);
		writer.println("<br><br>");

		writer.println("Qualification: "+q);
		writer.println("<br><br>");

		writer.println("Country: "+country);
		writer.println("<br><br>");

		writer.println("Languages: "+l);
		writer.println("<br><br>");

		writer.println("Your Comments: "+text);
		writer.println("<br><br>");

		writer.println("</body>");
		writer.println("</html>");

		






		
	}

}
