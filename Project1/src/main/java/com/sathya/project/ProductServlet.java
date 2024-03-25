package com.sathya.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/ProductServlet")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		
		Date MfgDate=Date.valueOf(request.getParameter("proMfgdate"));
		Date ExpDate=Date.valueOf(request.getParameter("proExpdate"));
		
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proImage=IOUtils.toByteArray(inputStream);
		
		
		Part part1=request.getPart("proAudio");
		InputStream inputStream1=part1.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proAudio=IOUtils.toByteArray(inputStream1);
		
		Part part2=request.getPart("proVideo");
		InputStream inputStream2=part2.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proVideo=IOUtils.toByteArray(inputStream2);
		
		//Using above details create the product Object...
				Product product = new Product();
				product.setProId(proId);
				product.setProName(proName);
				product.setProPrice(proPrice);
				product.setProBrand(proBrand);
				product.setProMadeIn(proMadeIn);
				product.setProMfgDate(MfgDate);
				product.setProExpDate(ExpDate);
				product.setProImage(proImage);
				product.setProAudio(proAudio);
				product.setProVideo(proVideo);
				
				//Giving the Product  Object to DAO Layer..
				ProductDao productdao = new ProductDao();
				
					int result = 0;
					try {
						result = productdao.save(product);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
				if(result==1)
				{
					//to send the data to JSP file
					request.setAttribute("SaveResult", result);
					RequestDispatcher dispatcher=request.getRequestDispatcher("Product.jsp");
					dispatcher.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter writer=response.getWriter();
					writer.println("Data not Inserted "+result);
					RequestDispatcher dispatcher=request.getRequestDispatcher("Product.html");
					dispatcher.include(request, response);
				}

	}

}
