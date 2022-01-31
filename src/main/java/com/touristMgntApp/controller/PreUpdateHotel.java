package com.touristMgntApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touristMgntApp.daoImpl.HotelTableDaoImplement;
import com.touristMgntApp.models.HotelClass;

@WebServlet("/updateHotel")
public class PreUpdateHotel extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		HotelTableDaoImplement hotelDao = new HotelTableDaoImplement();
		HotelClass hotel = hotelDao.getSingleHotel(hotelId);

		request.setAttribute("updatehotel", hotel);

		RequestDispatcher rd = request.getRequestDispatcher("updateHotel.jsp");
		
			rd.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

}