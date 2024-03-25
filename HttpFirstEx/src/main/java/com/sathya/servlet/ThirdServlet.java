package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<pre>");
		writer.println("Username: "+ session.getAttribute("username"));
		writer.println("User Age: "+ session.getAttribute("userage"));
		writer.println("qualification: "+ session.getAttribute("qualification"));
		writer.println("designation: "+ session.getAttribute("designation"));
		writer.println("Email: "+ request.getParameter("email"));
		writer.println("Mobile No: "+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");		
		writer.println("</html>");

		
		
		
	}

}
