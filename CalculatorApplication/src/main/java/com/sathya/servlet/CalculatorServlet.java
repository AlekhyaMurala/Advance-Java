package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.get the data
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("Operation");
		
		//2.Process the data
		
		int result=0;
		switch(operation)
		{
		case "+" :	result=num1+num2;
					break;
		case "-" :	result=num1-num2;
					break;
		case "*" :	result=num1*num2;
					break;
		case "/" :	result=num1/num2;
					break;
		case "%" :	result=num1%num2;
					break;
		}
		
		//3.Render the response
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h2> Your Result </h2>");
		writer.println("<b>Entered first number: </b>"+num1);
		writer.println("<br><br>");
		writer.println("<b>Entered Second number: </b>"+num2);
		writer.println("<br><br>");
		writer.println("<b>Entered Operation: </b>"+operation);
		writer.println("<br><br>");
		writer.println("<b>Result: </b>"+result);
		writer.println("</body>");
		writer.println("</html>");



	}

}
