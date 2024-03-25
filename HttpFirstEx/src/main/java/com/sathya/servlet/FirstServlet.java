package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//get the client data
		String username=request.getParameter("username");
		int userage=Integer.parseInt(request.getParameter("userage"));
		
		//create the Session object
		HttpSession session=request.getSession();
		
		//place the data into Session object
		session.setAttribute("username", username);
		session.setAttribute("userage", userage);
		
		//send the another form to the user
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Form2.html");
		dispatcher.forward(request, response);
	}

}
