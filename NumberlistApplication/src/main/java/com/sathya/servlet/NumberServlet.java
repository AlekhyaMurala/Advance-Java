package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NumberServlet")
public class NumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.get the data
		int num1=Integer.parseInt(request.getParameter("start"));
		int num2=Integer.parseInt(request.getParameter("end"));
		String operation=request.getParameter("Operation");
		
		//2.process the data
		switch(operation)
		{
		case "even" :	for(int i=num1;i<=num2;i++) {
							if(i%2==0) {
								response.getWriter().print(i+" ");
							}
						}
				
						break;
						
		case "odd" :	for(int i=num1;i<=num2;i++) {
							if(i%2!=0) {
								response.getWriter().print(i+" ");
							}
						}
		
						break;
						
		case "prime" :	for(int i=num1;i<=num2;i++) {
							int count=0;
								for(int j=1;j<=i;j++) {
									if(i%j==0) {
										count++;
									}
								}
								if(count==2) {
									response.getWriter().print(i+" ");
								}
							}
					
						break;
						
				
		case "Armstrong":
					for (int num = num1; num <= num2; num++) {
						int temp = num;
						int sum = 0;
						int count = 0;
						while (temp > 0) {
							temp = temp / 10;
							count++;
							}
							temp = num;
							while (temp > 0) {
								int digit = temp % 10;
								sum += Math.pow(digit, count);
								temp = temp / 10;
								}
							if (sum == num) {
								response.getWriter().print(num + " ");
            }
        }
	}
		
		}
}


