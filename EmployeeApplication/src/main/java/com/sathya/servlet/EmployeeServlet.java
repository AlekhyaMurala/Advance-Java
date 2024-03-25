package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1-Get the data
		String empId=request.getParameter("empId");
		String empName=request.getParameter("empName");
		double empSalary=Double.parseDouble(request.getParameter("empSalary"));
		
		//2-Process the data
		double HRA=0.0;
		double DA=0.0;
		double PF=0.0;

		if(empSalary>=50000)
		{
		HRA=(empSalary*30)/100;
		DA=(empSalary*10)/100;
		PF=(empSalary*6)/100;
		}
		else if(empSalary<50000 && empSalary>25000)
		{
			HRA=(empSalary*20)/100;
			DA=(empSalary*5)/100;
			PF=(empSalary*3)/100;
		}
		else if(empSalary<=25000)
		{
			HRA=(empSalary*10)/100;
			DA=(empSalary*3)/100;
			PF=(empSalary*2)/100;
		}
		double GrossSalary=empSalary+HRA+DA-PF;
		
		//Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h2> Salary Info </h2>");
		writer.println("<b>empId: </b>"+empId );
		writer.println("<br><br>");
		writer.println("<b>empName: </b>"+empName);
		writer.println("<br><br>");
		writer.println("<b>empSalary: $</b>"+empSalary);
		writer.println("<br><br>");
		writer.println("<b>HRA: </b>"+HRA);
		writer.println("<br><br>");
		writer.println("<b>DA: $</b>"+DA);
		writer.println("<br><br>");
		writer.println("<b>PF: $</b>"+PF);
		writer.println("<br><br>");
		writer.println("<b>Gross salary: $</b>"+GrossSalary);
		writer.println("</body>");
		writer.println("</html>");
	}
	

}
