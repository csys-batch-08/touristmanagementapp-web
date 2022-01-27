package com.ajith.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rating")
public class prerating extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		int bookingId = Integer.parseInt(request.getParameter("bookingid"));
		
		request.setAttribute("ratingbookingid", bookingId);
		RequestDispatcher rd = request.getRequestDispatcher("rating.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
