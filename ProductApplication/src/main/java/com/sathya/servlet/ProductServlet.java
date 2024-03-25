package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//1.Get the data
		
				int proId=Integer.parseInt(request.getParameter("proId"));
				String proName=request.getParameter("proName");
				double proPrice=Double.parseDouble(request.getParameter("proPrice"));
				int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
				
				//2.Process the data.
				
				Double Totalbill=proPrice*proQuantity;
				Double discountamount=0.0;
				Double bill = 0.0;
				
				if(Totalbill < 1000)
				{
					discountamount=0.0;
					bill=Totalbill;
				}
				else if(Totalbill>1000 && Totalbill<5000)
				{
					discountamount=(Totalbill*5)/100;
					bill=Totalbill-discountamount;		
				}
				else if(Totalbill>5000 && Totalbill<10000)
				{
					discountamount=(Totalbill*10)/100;
					bill=Totalbill-discountamount;		
				}
				else if(Totalbill>10000)
				{
					discountamount=(Totalbill*15)/100;
					bill=Totalbill-discountamount;		
				}
				
				
				//3.render the response
				
				response.setContentType("text/html");
				PrintWriter writer=response.getWriter();
				writer.println("<html>");
				writer.println("<body bgcolor=pink>");
				writer.println("<h2> Product Bill Invoice </h2>");
				writer.println("<b>ProductId: </b>"+proId );
				writer.println("<br><br>");
				writer.println("<b>ProductName: </b>"+proName);
				writer.println("<br><br>");
				writer.println("<b>ProductPrice: $</b>"+proPrice);
				writer.println("<br><br>");
				writer.println("<b>ProductQuantity: </b>"+proQuantity);
				writer.println("<br><br>");
				writer.println("<b>Totalbill: $</b>"+Totalbill);
				writer.println("<br><br>");
				writer.println("<b>DiscountAmount: $</b>"+discountamount);
				writer.println("<br><br>");
				writer.println("<b>Net amount to pay: $</b>"+bill);
				writer.println("</body>");
				writer.println("</html>");
	}

}
