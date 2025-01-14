package com.sathya.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId=request.getParameter("proId");
		String updatedProductName=request.getParameter("proName");
		double updatedProductPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedProductBrand=request.getParameter("proBrand");
		String updatedProductMadeIn=request.getParameter("proMadeIn");
		
		Date updatedMfgDate=Date.valueOf(request.getParameter("proMfgdate"));
		Date updatedExpDate=Date.valueOf(request.getParameter("proExpdate"));
		
		
		
		
		
		
		
//		Part imagePart=request.getPart("newProImage");
//		Part audioPart=request.getPart("newProAudio");
//		Part videoPart=request.getPart("newProVideo");
		
		Part part=request.getPart("newProImage");
		InputStream inputStream=part.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proImage=IOUtils.toByteArray(inputStream);
		
		
		Part part1=request.getPart("newProAudio");
		InputStream inputStream1=part1.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proAudio=IOUtils.toByteArray(inputStream1);
		
		Part part2=request.getPart("newProVideo");
		InputStream inputStream2=part2.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proVideo=IOUtils.toByteArray(inputStream2);
		
		
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(updatedProductName);
		product.setProPrice(updatedProductPrice);
		product.setProBrand(updatedProductBrand);
		product.setProMadeIn(updatedProductMadeIn);
		product.setProMfgDate(updatedMfgDate);
		product.setProExpDate(updatedExpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
//		//newProImage is the name of your file input field
//		if( imagePart!=null && imagePart.getSize()>0)
//		{
//			InputStream inputStream=imagePart.getInputStream();
//			byte[] newProImage=IOUtils.toByteArray(inputStream);
//			product.setProImage(newProImage);
//			
//		}
//		else
//		{
//			String s=request.getParameter("existingImage");
//			byte[] existingImage=Base64.getDecoder().decode(s);
//			product.setProImage(existingImage);
//		}
		
		
		
		
		ProductDao productDao=new ProductDao();
		int result=productDao.updateById(product);
		if(result==1)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Product.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data updation fail check once..."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Product.html");
			dispatcher.include(request, response);
		}
	}

}
